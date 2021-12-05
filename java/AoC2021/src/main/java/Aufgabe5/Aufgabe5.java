package Aufgabe5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe5 {

  public static void main(String[] args) throws FileNotFoundException {
    final FileReader file = new FileReader("./src/main/resources/Aufgabe5/input5.txt");
    System.out.println(task2(file));
  }

  static List<Line> readIn(FileReader file) {
    return new BufferedReader(file).lines().map(Line::new).collect(Collectors.toList());
  }

  public static long task1(FileReader testFile) {
    List<Line> input = readIn(testFile);
    List<Point> coveredPoints = input.stream()
        .filter(Line::vertOrHor)
        .map(Line::vertOrHorCoveredPoints)
        .flatMap(List::stream)
        .collect(Collectors.toList());

    return countDistincCoveredPoints(coveredPoints);
  }


  public static long task2(FileReader testFile) {
    List<Line> input = readIn(testFile);
    List<Point> coveredPoints = input.stream()
        .map(Line::allCoveredPoints)
        .flatMap(List::stream)
        .collect(Collectors.toList());

    return countDistincCoveredPoints(coveredPoints);
  }

  private static long countDistincCoveredPoints(List<Point> coveredPoints) {
    return coveredPoints.stream()
        .distinct()
        .mapToInt(x -> Collections.frequency(coveredPoints, x))
        .filter(x -> x > 1)
        .count();
  }
}
