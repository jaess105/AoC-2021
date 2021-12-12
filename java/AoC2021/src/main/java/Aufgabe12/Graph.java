package Aufgabe12;

import static Aufgabe12.Helper.findDuplicates;
import static Aufgabe12.Helper.findWithQuantityDuplicates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Graph {


  private final Set<Node> nodes;
  private final Set<Edge> edges;
  private final Set<Node> startNodes;
  private final Set<Node> endNodes;

  private Graph(Set<Node> nodes, Set<Edge> edges, Set<Node> startNodes,
      Set<Node> endNodes) {
    this.nodes = nodes;
    this.edges = edges;
    this.startNodes = startNodes;
    this.endNodes = endNodes;
  }

  /**
   * After reviewing the available paths, you realize you might have time to visit a single small
   * cave twice. Specifically, big caves can be visited any number of times, a single small cave can
   * be visited at most twice, and the remaining small caves can be visited at most once. However,
   * the caves named start and end can only be visited exactly once each: once you leave the start
   * cave, you may not return to it, and once you reach the end cave, the path must end
   * immediately.
   *
   * @return
   */
  Set<List<Node>> findAllPathsTask2() {
    Set<List<Node>> allPaths = pathsThatImmediatlyEnd();

    Predicate<List<Node>> taskBoundries = x -> {
      List<Node> duplicatesWithQuantity = findWithQuantityDuplicates(x);
      return hasMaxOneLowerCaseLetterTwice(duplicatesWithQuantity);
    };

    Set<List<Node>> currentPaths = startPaths(taskBoundries);
    Set<List<Node>> endingPaths = findPathsThatCanEnd(currentPaths);
    allPaths.addAll(endingPaths);

    while (!currentPaths.isEmpty()) {
      currentPaths = extendPaths(currentPaths, taskBoundries);
      endingPaths = findPathsThatCanEnd(currentPaths);
      allPaths.addAll(endingPaths);
    }

    return allPaths;
  }


  private Set<List<Node>> pathsThatImmediatlyEnd() {
    return startNodes.stream()
        .filter(endNodes::contains)
        .map(List::of)
        .collect(Collectors.toSet());
  }


  Set<List<Node>> findAllPathsTask1() {
    Set<List<Node>> allPaths = pathsThatImmediatlyEnd();

    Set<List<Node>> currentPaths = startPaths(this::noDublicatedLowerCase);
    Set<List<Node>> endingPaths = findPathsThatCanEnd(currentPaths);
    allPaths.addAll(endingPaths);

    while (!currentPaths.isEmpty()) {
      currentPaths = extendPaths(currentPaths, this::noDublicatedLowerCase);
      endingPaths = findPathsThatCanEnd(currentPaths);
      allPaths.addAll(endingPaths);
    }

    return allPaths;
  }

  private Set<List<Node>> extendPaths(Set<List<Node>> currentPaths,
      Predicate<List<Node>> filterArgs) {
    var listStream = currentPaths.stream()
        .flatMap(path -> {
          Node lastNode = path.get(path.size() - 1);
          return toPaths(path, findConnectedNodes(lastNode)).stream();
        }).toList();
    return listStream.stream()
        .filter(filterArgs)
        .collect(Collectors.toSet());
  }

  private boolean noDublicatedLowerCase(List<Node> path) {
    return hasNoLowerCaseLetters(findDuplicates(path));
  }

  private Set<List<Node>> findPathsThatCanEnd(Set<List<Node>> collect) {
    return collect.stream()
        .filter(x -> endNodes.contains(x.get(x.size() - 1)))
        .collect(Collectors.toSet());
  }

  private Set<List<Node>> startPaths(Predicate<List<Node>> filterArgs) {

    return startNodes.stream().flatMap(
            startN -> toPaths(startN, findConnectedNodes(startN)).stream()
        )
        .filter(filterArgs)
        .collect(Collectors.toSet());
  }

  private Set<List<Node>> toPaths(Node startN, List<Node> outgoing) {
    return outgoing.stream().map(nextNode -> List.of(startN, nextNode))
        .collect(Collectors.toSet());
  }

  private Set<List<Node>> toPaths(List<Node> startN, List<Node> outgoing) {
    return outgoing.stream().map(nextNode -> {
          List<Node> nodes = new ArrayList<>(startN);
          nodes.add(nextNode);
          return nodes;
        })
        .collect(Collectors.toSet());
  }

  private List<Node> findConnectedNodes(Node startN) {
    return edges.stream().filter(edge -> edge.start().equals(startN)).map(Edge::end).toList();
  }

  public static boolean hasNoLowerCaseLetters(Collection<Node> col) {
    return col.stream().map(Node::name).noneMatch(x -> x.equals(x.toLowerCase()));
  }

  public static boolean hasMaxOneLowerCaseLetterTwice(Collection<Node> duplicates) {
    return duplicates.stream().map(Node::name)
        .filter(x -> x.equals(x.toLowerCase()))
        .count() <= 1;
  }

  private record Node(String name) {

  }

  private record Edge(Node start, Node end) {

  }

  public static class GraphBuilder {

    private final Set<Node> startNodes = new HashSet<>();
    private final Set<Node> endNodes = new HashSet<>();
    private final Set<Node> nodes = new HashSet<>();
    private final Set<Edge> edges = new HashSet<>();

    void addLine(String line) {
      String[] split = line.split("-");
      if (split[0].equals("start")) {
        addNodeTo(startNodes, split[1]);
      } else if (split[1].equals("start")) {
        addNodeTo(startNodes, split[0]);
      } else if (split[0].equals("end")) {
        addNodeTo(endNodes, split[1]);
      } else if (split[1].equals("end")) {
        addNodeTo(endNodes, split[0]);
      } else {
        addNodesAndEdges(split);
      }
    }

    private void addNodeTo(Set<Node> startOrEndNodes, String nodeName) {
      Node endNode = new Node(nodeName);
      startOrEndNodes.add(endNode);
      nodes.add(endNode);
    }

    private void addNodesAndEdges(String[] split) {
      Node node1 = new Node(split[0]);
      Node node2 = new Node(split[1]);
      nodes.add(node1);
      nodes.add(node2);
      edges.add(new Edge(node1, node2));
      edges.add(new Edge(node2, node1));
    }

    public Graph build() {
      return new Graph(nodes, edges, startNodes, endNodes);
    }


  }
}


