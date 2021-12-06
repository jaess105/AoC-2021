package Aufgabe6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Aufgabe6 {

  public static void main(String[] args) throws IOException {
    final FileReader file = new FileReader("./src/main/resources/Aufgabe6/input6.txt");
    System.out.println(task1(file));
  }

  static long task1(FileReader file) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(file);
    String inputNumbers = bufferedReader.readLine();
    List<Integer> inputInts = Arrays.stream(inputNumbers.split(",")).map(Integer::parseInt)
        .toList();
    Swarm swarm = new SwarmMap(inputInts);
    for (int i = 0; i < 256; i++) {
      swarm.nextRound();
    }
    return swarm.populationCount();
  }


}
