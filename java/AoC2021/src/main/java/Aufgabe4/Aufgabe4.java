package Aufgabe4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Aufgabe4 {


  public static void main(String[] args) throws IOException {
    final FileReader file = new FileReader("./src/main/resources/Aufgabe4/input4.txt");
    System.out.println(task2(file));
  }

  static int task2(final FileReader file) {
    final Scanner scanner = new Scanner(file);
    final int[] drawnNumbers = getDrawnNumbers(scanner.nextLine());
    final List<Board> boards = createBoards(scanner);
    final Map<Integer, List<Board>> collect = boards.stream()
        .collect(Collectors.groupingBy(
            x -> x.wonInRound(drawnNumbers)));
    final int lastRoundToWin = getLastRondToWin(collect);
    return winnerBoardSum(collect, lastRoundToWin) * drawnNumbers[lastRoundToWin - 1];
  }

  private static int getLastRondToWin(Map<Integer, List<Board>> collect) {
    return collect.keySet().stream()
        .mapToInt(x -> x)
        .filter(x -> x != -1)
        .max()
        .orElseThrow();
  }

  static int task1(final FileReader file) {
    final Scanner scanner = new Scanner(file);
    final int[] drawnNumbers = getDrawnNumbers(scanner.nextLine());
    final List<Board> boards = createBoards(scanner);
    final Map<Integer, List<Board>> collect = boards.stream()
        .collect(Collectors.groupingBy(
            x -> x.wonInRound(drawnNumbers)));
    final int firstRoundToWin = getFirstRondToWin(collect);
    return winnerBoardSum(collect, firstRoundToWin) * drawnNumbers[firstRoundToWin - 1];
  }

  private static int winnerBoardSum(Map<Integer, List<Board>> collect, int roundsToWin) {
    return collect.get(roundsToWin).get(0).sumWithoutMarked();
  }

  private static int getFirstRondToWin(Map<Integer, List<Board>> collect) {
    return collect.keySet().stream()
        .mapToInt(x -> x)
        .filter(x -> x != -1)
        .min()
        .orElseThrow();
  }

  static int[] getDrawnNumbers(String str) {
    return Arrays.stream(str.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  static List<Board> createBoards(Scanner scanner) {
    List<Board> boards = new ArrayList<>();
    while (scanner.hasNext()) {
      StringBuilder bobTheBuilder = getBoardStringBuilder(scanner);
      boards.add(new Board(bobTheBuilder.toString()));
    }
    return boards;
  }

  private static StringBuilder getBoardStringBuilder(Scanner scanner) {
    StringBuilder bobTheBuilder = new StringBuilder();
    for (int i = 0; i < 5 && scanner.hasNext(); i++) {
      String line = scanner.nextLine();
      if (line.isEmpty()) {
        i--;
      } else {
        bobTheBuilder.append(" ").append(line);
      }
    }
    return bobTheBuilder;
  }


}
