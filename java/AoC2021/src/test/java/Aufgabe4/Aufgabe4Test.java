package Aufgabe4;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class Aufgabe4Test {

  @Test
  void get_drawn_numbers() throws FileNotFoundException {
    int[] ergebnis = {7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18,
        20, 8, 19, 3, 26, 1};
    int[] drawnNumbers = Aufgabe4.getDrawnNumbers(
        "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1");
    assertThat(drawnNumbers).isEqualTo(ergebnis);
  }

  @Test
  void test1() throws FileNotFoundException {
    final FileReader file = new FileReader("./src/test/resources/Aufgabe4/test_data_test1.txt");
    int[][] goalBoard = {
        {14, 21, 17, 24, 4},
        {10, 16, 15, 9, 19},
        {18, 8, 23, 26, 20},
        {22, 11, 13, 6, 5},
        {2, 0, 12, 3, 7}
    };

    List<Board> boards = Aufgabe4.createBoards(new Scanner(file));

    Board board = boards.get(0);
    assertThat(board.getBoard()).isEqualTo(goalBoard);
  }

  @Test
  void two_boards() throws FileNotFoundException {
    final FileReader file = new FileReader(
        "./src/test/resources/Aufgabe4/test_data_two_boards.txt");
    int[][] goalBoard = {
        {14, 21, 17, 24, 4},
        {10, 16, 15, 9, 19},
        {18, 8, 23, 26, 20},
        {22, 11, 13, 6, 5},
        {2, 0, 12, 3, 7}
    };

    List<Board> boards = Aufgabe4.createBoards(new Scanner(file));

    Board board1 = boards.get(0);
    Board board2 = boards.get(1);
    assertThat(board1.getBoard()).isEqualTo(goalBoard);
    assertThat(board2.getBoard()).isEqualTo(goalBoard);
  }

  @Test
  void case_from_task() throws FileNotFoundException {
    final FileReader file = new FileReader(
        "./src/test/resources/Aufgabe4/test_data_full.txt");

    int i = Aufgabe4.task1(file);

    assertThat(i).isEqualTo(4512);
  }
}