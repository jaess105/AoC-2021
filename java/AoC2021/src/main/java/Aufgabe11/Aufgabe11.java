package Aufgabe11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Aufgabe11 {

  private static final String PATH = "./src/main/resources/Aufgabe11/input11.txt";


  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(task1(PATH));
    System.out.println(task2(PATH));
  }

  static int task2(String path) throws FileNotFoundException {
    String input = readIn(path);
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(input);
    final int size = dumboOctopusGrid.size();
    return 1 + IntStream.iterate(0, i -> i + 1)
        .filter(i -> {
          dumboOctopusGrid.nextRound();
          return dumboOctopusGrid.countFlashing() == size;
        })
        .findFirst()
        .orElse(-1);
  }

  static long task1(String path) throws FileNotFoundException {
    String input = readIn(path);
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(input);
    return IntStream.range(0, 100).mapToLong(x -> {
      dumboOctopusGrid.nextRound();
      return dumboOctopusGrid.countFlashing();
    }).sum();
  }

  private static String readIn(String path) throws FileNotFoundException {
    return new BufferedReader(new FileReader(path)).lines()
        .collect(Collectors.joining("\n"));
  }
}
