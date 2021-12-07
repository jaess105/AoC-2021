package Aufgabe7;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.BiFunction;

public class Aufgabe7 {

  static final String path = "./src/main/resources/Aufgabe7/input7.txt";

  public static void main(String[] args) throws IOException {
    final FileReader file = new FileReader(path);
    String input = new BufferedReader(file).readLine();
    System.out.println(task2(input));
  }


  public static int[] readIn(String input) {
    return Arrays.stream(input.split(","))
        .map(String::strip)
        .map(Integer::parseInt)
        .mapToInt(x -> x)
        .toArray();
  }

  final static BiFunction<Integer, Integer, Integer> fuelFunctionTask2 =
      (alignPos, element) -> {
        int n = abs(alignPos - element);
        return n * (n + 1) / 2;
      };

  public static int task2(String input) {
    int[] inputAsInts = readIn(input);

    return findBestPosition(inputAsInts, fuelFunctionTask2);
  }

  public static int task1(String input) {
    int[] inputAsInts = readIn(input);

    BiFunction<Integer, Integer, Integer> fuelFunction =
        (alignPos, element) -> abs(alignPos - element);

    return findBestPosition(inputAsInts, fuelFunction);
  }

  private static int findBestPosition(int[] inputAsInts,
      BiFunction<Integer, Integer, Integer> fuelFunction) {
    int min = Arrays.stream(inputAsInts).min().getAsInt();
    int max = Arrays.stream(inputAsInts).max().getAsInt();

    int best = Integer.MAX_VALUE;

    for (int alignPos = min; alignPos < max; alignPos++) {
      int current = 0;
      for (int i = 0; i < inputAsInts.length && current < best; i++) {
        current += fuelFunction.apply(alignPos, inputAsInts[i]);
      }
      if (current < best) {
        best = current;
      }
    }
    return best;
  }


}



