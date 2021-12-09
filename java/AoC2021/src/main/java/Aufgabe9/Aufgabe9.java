package Aufgabe9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Aufgabe9 {

  static final String path = "./src/main/resources/Aufgabe9/input9.txt";

  public static void main(String[] args) throws IOException {
    System.out.println(task2(path));

  }

  static int task2(String path) throws IOException {
    int[][] input = readIn(path);
    List<Position> lowestPositions = getLowestPositions(input);
    List<Set<Position>> grids = lowestPositions.stream().map(
        x -> {
          Set<Position> grid = new HashSet<>();
          getGridRec(grid, input, x);
          return grid;
        }
    ).toList();
    return grids.stream().map(Set::size)
        .sorted((x, y) -> Integer.compare(y, x))
        .limit(3)
        .reduce((x, y) -> x * y)
        .orElse(-1);
  }

  private static void getGridRec(Set<Position> grid, int[][] input, Position pos) {
    if (!grid.contains(pos) &&
        pos.x() >= 0 && pos.y() >= 0 &&
        checkNotNineAndInArr(input, pos)) {
      grid.add(pos);
      getGridRec(grid, input, new Position(pos.x() - 1, pos.y()));
      getGridRec(grid, input, new Position(pos.x() + 1, pos.y()));
      getGridRec(grid, input, new Position(pos.x(), pos.y() - 1));
      getGridRec(grid, input, new Position(pos.x(), pos.y() + 1));
    }
  }

  private static boolean checkNotNineAndInArr(int[][] input, Position pos) {
    try {
      return input[pos.x()][pos.y()] != 9;
    } catch (ArrayIndexOutOfBoundsException exception) {
      return false;
    }
  }

  private static List<Position> getLowestPositions(int[][] input) throws IOException {
    List<Position> list = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        int current = input[i][j];
        if (safeCheckLower(input, i - 1, j, current) &&
            safeCheckLower(input, i, j - 1, current) &&
            safeCheckLower(input, i + 1, j, current) &&
            safeCheckLower(input, i, j + 1, current)) {
          list.add(new Position(i, j));
        }
      }
    }
    return list;
  }


  static long task1(String path) throws IOException {
    List<Integer> list = new ArrayList<>();
    int[][] input = readIn(path);
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        int current = input[i][j];
        if (safeCheckLower(input, i - 1, j, current) &&
            safeCheckLower(input, i, j - 1, current) &&
            safeCheckLower(input, i + 1, j, current) &&
            safeCheckLower(input, i, j + 1, current)) {
          list.add(current);
        }
      }
    }
    return list.stream().mapToInt(x -> x + 1).sum();
  }

  static boolean safeCheckLower(int[][] arr, int i, int j, int current) {
    try {
      return current < arr[i][j];
    } catch (ArrayIndexOutOfBoundsException exception) {
      return true;
    }
  }

  static int[][] readIn(String path) throws IOException {
    final FileReader file = new FileReader(path);
    return new BufferedReader(file).lines()
        .map(str -> str.split(""))
        .map(Arrays::stream)
        .map(stringStream -> stringStream.filter(x -> !x.isBlank()))
        .map(stringStream -> stringStream.mapToInt(Integer::parseInt))
        .map(IntStream::toArray)
        .toArray(int[][]::new);
  }

}
