package Aufgabe12;


import Aufgabe12.Graph.GraphBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Aufgabe12 {

  private static final String PATH = "./src/main/resources/Aufgabe12/input12.txt";

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(task1(PATH));
    System.out.println(task2(PATH));
  }

  static int task1(String path) throws FileNotFoundException {
    GraphBuilder graphBuilder = new GraphBuilder();
    new BufferedReader(new FileReader(path)).lines()
        .forEach(graphBuilder::addLine);
    Graph graph = graphBuilder.build();

    return graph.findAllPathsTask1().size();
  }

  public static int task2(String path) throws FileNotFoundException {
    GraphBuilder graphBuilder = new GraphBuilder();
    new BufferedReader(new FileReader(path)).lines()
        .forEach(graphBuilder::addLine);
    Graph graph = graphBuilder.build();

    return graph.findAllPathsTask2().size();
  }
}
