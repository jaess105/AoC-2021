package Aufgabe4;

import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

  private final int[][] board;

  public Board(String input) {
    this.board = boardErstellen(input);
  }

  Board(int[][] input) {
    this.board = input;
  }

  private static int[][] boardErstellen(String input) {
    int[][] board = new int[5][5];
    String[] inputAsArr = inputAsArrWithoutBlanks(input);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        board[i][j] = Integer.parseInt(inputAsArr[i * 5 + j]);
      }
    }
    return board;
  }

  private static String[] inputAsArrWithoutBlanks(String input) {
    return stream(input.split("[ \n]"))
        .filter(x -> !x.isBlank())
        .toArray(String[]::new);
  }

  int[][] getBoard() {
    return board;
  }


  public int wonInRound(int[] winSeq) {
    for (int i = 0; i < winSeq.length; i++) {
      if (changeIfPresent(winSeq[i]) && isWinner()) {
        return i + 1;
      }
    }
    return -1;
  }

  public boolean isWinner() {
    for (int i = 0; i < board.length; i++) {
      boolean rowCanBe = true;
      boolean colCanBe = true;
      for (int j = 0; j < board[i].length; j++) {
        if (((rowCanBe && board[i][j] == -1) || (colCanBe && board[j][i] == -1)) && j == 4) {
          return true;
        } else if (!rowCanBe && !colCanBe) {
          break;
        }
        if (board[i][j] != -1) {
          rowCanBe = false;
        }
        if (board[j][i] != -1) {
          colCanBe = false;
        }
      }
    }
    return false;
  }


  /**
   * @param numberDrawn die gezogene Nummer der Lottozahlen.
   * @return gibt true zurück, wenn die Nummer geändert wurde.
   */
  private boolean changeIfPresent(int numberDrawn) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (numberDrawn == board[i][j]) {
          board[i][j] = -1;
          return true;
        }
      }
    }
    return false;
  }


  public int sumWithoutMarked() {
    return stream(board).map(Arrays::stream)
        .map(this::removeMarked)
        .mapToInt(IntStream::sum)
        .sum();
  }

  private IntStream removeMarked(IntStream x) {
    IntPredicate notMarked = y -> y != -1;
    return x.filter(notMarked);
  }

  @Override
  public String toString() {
    return "Board{" +
        "board=" + Arrays.stream(board).map(Arrays::toString).collect(Collectors.joining("\n")) +
        '}';
  }
}
