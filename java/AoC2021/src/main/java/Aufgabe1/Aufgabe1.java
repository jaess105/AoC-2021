package Aufgabe1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Aufgabe1 {


  public static void main(String[] args) throws IOException {
    final FileReader file = new FileReader("./src/main/resources/Aufgabe1/input1.txt");
    final BufferedReader reader = new BufferedReader(file);

    List<Integer> inputData = toList(reader);
    System.out.println(teilAufgabe1_2(inputData));
    System.out.println(teilAufgabe2_2(inputData));
  }

  private static List<Integer> toList(BufferedReader br) {
    return br.lines().map(Integer::parseInt).collect(Collectors.toList());
  }

  private static int teilAufgabe2_2(List<Integer> inputData) {
    AtomicInteger atom = new AtomicInteger(0);
    IntStream.range(0, inputData.size() - 2)
        .map(i -> inputData.get(i) + inputData.get(i + 1) + inputData.get(i + 2))
        .reduce((x, y) -> {
          atom.addAndGet(x < y ? 1 : 0);
          return y;
        });
    return atom.get();
  }

  private static void teilAufgabe2(BufferedReader reader) {
    List<Integer> inputData = reader.lines().map(Integer::parseInt).collect(Collectors.toList());

    int prev = inputData.stream().limit(3).reduce(Integer::sum).get();
    int largerMeasurement = 0;

    for (int i = 0; i < inputData.size() - 2; i++) {
      int currentDepth = inputData.get(i) + inputData.get(i + 1) + inputData.get(i + 2);
      if (prev < currentDepth) {
        largerMeasurement++;
      }
      prev = currentDepth;
    }
    System.out.println(largerMeasurement);
  }

  private static int teilAufgabe1_2(List<Integer> inputData) {
    AtomicInteger atom = new AtomicInteger(0);
    inputData.stream()
        .reduce((x, y) -> {
          atom.addAndGet(x < y ? 1 : 0);
          return y;
        });
    return atom.get();
  }

  private static void teilAufgabe1(FileReader file) {
    Scanner sc = new Scanner(file);
    int prev = sc.nextInt();
    int largerMeasurement = 0;
    while (sc.hasNext()) {
      int currentDepth = sc.nextInt();
      if (prev < currentDepth) {
        largerMeasurement++;
      }
      prev = currentDepth;
    }
    System.out.println(largerMeasurement);
  }
}
