package Aufgabe8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Segment {

  private final Map<String, Integer> segments;

  Segment(List<String> line) {
    this.segments = deduce(line);
  }

  int getValue(String segmentLights) {
    String key = segments.keySet().stream()
        .filter(x -> xContainsExactlyCharsOfY(x, segmentLights)).findFirst().get();
    Integer integer = segments.get(key);
    return integer;
  }

  Map<String, Integer> deduce(List<String> line) {

    line = line.stream().map(String::strip).sorted(Comparator.comparingInt(String::length))
        .toList();

    String one = getStringOfSize(line, 2);
    String seven = getStringOfSize(line, 3);
    String four = getStringOfSize(line, 4);
    String eight = getStringOfSize(line, 7);

    List<String> nullSixNine = getStringsOfSize(line, 6);
    List<String> twoThreeFive = getStringsOfSize(line, 5);

    Predicate<String> deduceSix = x -> !xContainsAllCharsOfY(x, one);
    String six = duduce(nullSixNine, deduceSix);

    Predicate<String> deduceNine = x ->
        xContainsAllCharsOfY(x, four)
            && !x.equals(six);
    String nine = duduce(nullSixNine, deduceNine);

    Predicate<String> deduceZero = x -> !x.equals(six) && !x.equals(nine);
    String zero = duduce(nullSixNine, deduceZero);

    Predicate<String> deduceFive = x -> xContainsAllCharsOfY(six, x);
    String five = duduce(twoThreeFive, deduceFive);

    Predicate<String> deduceThree = x -> xContainsAllCharsOfY(nine, x) && !x.equals(five);
    String three = duduce(twoThreeFive, deduceThree);

    Predicate<String> deduceTwo = x -> !x.equals(three) && !x.equals(five);
    String two = duduce(twoThreeFive, deduceTwo);

    Map<String, Integer> map = Map.of(
        zero, 0,
        one, 1,
        two, 2,
        three, 3,
        four, 4,
        five, 5,
        six, 6,
        seven, 7,
        eight, 8,
        nine, 9);
    return map;
  }

  private boolean xContainsExactlyCharsOfY(String x, String y) {
    Set<String> listX = Arrays.stream(x.split("")).collect(Collectors.toSet());
    Set<String> listY = Arrays.stream(y.split("")).collect(Collectors.toSet());
    return listX.equals(listY);
  }

  private boolean xContainsAllCharsOfY(String x, String y) {
    List<String> listX = Arrays.stream(x.split("")).toList();
    List<String> listY = Arrays.stream(y.split("")).toList();
    return listX.containsAll(listY);
  }


  private String duduce(List<String> list, Predicate<String> deductor) {
    var stringStream = list.stream().filter(deductor).toList();
    return stringStream.stream()
        .findFirst()
        .get();
  }


  private String getStringOfSize(List<String> line, int size) {
    return line.stream()
        .filter(x -> x.length() == size)
        .findFirst().get();
  }

  private List<String> getStringsOfSize(List<String> line, int size) {
    return line.stream().filter(x -> x.length() == size).toList();
  }


}
