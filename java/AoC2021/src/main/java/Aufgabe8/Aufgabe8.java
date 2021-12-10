package Aufgabe8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Aufgabe8 {

  static final String path = "./src/main/resources/Aufgabe8/input8.txt";

  public static void main(String[] args) throws IOException {
    System.out.println(task1(path));
    System.out.println(task2(path));
  }

  static long task1(String path) throws IOException {
    List<String[]> input = readInTask1(path);
    return input.stream()
        .flatMap(Arrays::stream)
        .map(String::length)
        .filter(x -> x == 2 || x == 3 || x == 4 | x == 7)
        .count();
  }

  static List<String[]> readInTask1(String path) throws IOException {
    final FileReader file = new FileReader(path);
    return new BufferedReader(file).lines()
        .map(str -> str.split("\\|"))
        .map(x -> x[1])
        .map(String::strip)
        .map(str -> str.split(" "))
        .toList();
  }

  static long task2(String path) throws IOException {
    List<String> input = readInTask2(path);
    Function<String[], String> getSegmentValues = arr -> {
      Segment segment = new Segment(
          Arrays.asList(arr[0].strip().split(" "))
      );
      return Arrays.stream(arr[1].split(" "))
          .filter(x -> !x.isBlank())
          .map(segment::getValue)
          .map(Object::toString)
          .collect(Collectors.joining(""));
    };
    return input.stream()
        .map(str -> str.split("\\|"))
        .map(getSegmentValues)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static List<String> readInTask2(String path) throws FileNotFoundException {
    return new BufferedReader(new FileReader(path)).lines()
        .map(String::strip)
        .toList();
  }


}
