package Aufgabe4;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class BoardTest {


  @Test
  void board_Erstellung() {
    String input = """
        36 11 70 77 80
        63  3 56 75 28
        89 91 27 33 82
        53 79 52 96 32
        58 14 78 65 38
        """;
    assertThat(new Board(input)).isOfAnyClassIn(Board.class);
  }

  @Test
  void korrektes_Board_eingelesen() {
    int[][] ergebnissBoard = {
        {36, 11, 70, 77, 80},
        {63, 3, 56, 75, 28},
        {89, 91, 27, 33, 82},
        {53, 79, 52, 96, 32},
        {58, 14, 78, 65, 38}
    };
    String input = """
        36 11 70 77 80
        63  3 56 75 28
        89 91 27 33 82
        53 79 52 96 32
        58 14 78 65 38
        """;
    Board board = new Board(input);
    assertThat(board.getBoard()).isEqualTo(ergebnissBoard);
  }

  @Test
  void test_not_won() {
    String input = """
        14 21 17 24  4
        10 16 15  9 19
        18  8 23 26 20
        22 11 13  6  5
        2  0 12  3  7
                """;
    int[] winSeq = {7, 4, 9, 5, 11, 17, 23, 2, 0, 14};
    Board board = new Board(input);
    assertThat(board.wonInRound(winSeq)).isEqualTo(-1);
  }


  @Test
  void isWinner() {
    int[][] input = {
        {-1, -1, -1, -1, -1},
        {10, 16, 15, 9, 19},
        {18, 8, 23, 26, 20},
        {22, 11, 13, 6, 5},
        {2, 0, 12, 3, 7}
    };
    Board board = new Board(input);
    assertThat(board.isWinner()).isEqualTo(true);
  }

  @Test
  void isWinner_2() {
    int[][] input = {
        {10, 16, 15, 9, 19},
        {-1, -1, -1, -1, -1},
        {18, 8, 23, 26, 20},
        {22, 11, 13, 6, 5},
        {2, 0, 12, 3, 7}
    };
    Board board = new Board(input);
    assertThat(board.isWinner()).isEqualTo(true);
  }

  @Test
  void isWinner_3() {
    int[][] input = {
        {10, 16, 15, 9, 19},
        {18, 8, 23, 26, 20},
        {22, 11, 13, 6, 5},
        {2, 0, 12, 3, 7},
        {-1, -1, -1, -1, -1}
    };
    Board board = new Board(input);
    assertThat(board.isWinner()).isEqualTo(true);
  }

  @Test
  void isWinner_column() {
    int[][] input = {
        {-1, 16, 15, 9, 19},
        {-1, 8, 23, 26, 20},
        {-1, 11, 13, 6, 5},
        {-1, 0, 12, 3, 7},
        {-1, 1, 1, 1, 1}
    };
    Board board = new Board(input);
    assertThat(board.isWinner()).isEqualTo(true);
  }

  @Test
  void isWinner_column_2() {
    int[][] input = {
        {36, 11, 70, -1, 80},
        {63, 3, 56, -1, 28},
        {89, 91, 27, -1, 82},
        {53, 79, 52, -1, 32},
        {58, 14, 78, -1, 38}
    };
    Board board = new Board(input);
    assertThat(board.isWinner()).isEqualTo(true);
  }

  @Test
  void test() {
    String input = """
        14 21 17 24  4
        10 16 15  9 19
        18  8 23 26 20
        22 11 13  6  5
        2  0 12  3  7
                """;
    int[] winSeq = {7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24};
    Board board = new Board(input);
    assertThat(board.wonInRound(winSeq)).isEqualTo(winSeq.length);
  }

  @Test
  void sum_Without_marked() {
    int[][] input = {
        {14, 21, 17, 24, 4},
        {10, 16, 15, 9, 19},
        {18, 8, 23, 26, 20},
        {22, 11, 13, 6, 5},
        {2, 0, 12, 3, 7}
    };
    int[] winSeq = {7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24};
    Board board = new Board(input);
    board.wonInRound(winSeq);
    assertThat(board.sumWithoutMarked()).isEqualTo(188);

  }

  @Test
  void sum_Without_marked_2() {
    int[][] input = {
        {36, 11, 70, -1, 80},
        {63, 3, 56, -1, 28},
        {89, 91, 27, -1, 82},
        {53, 79, 52, -1, 32},
        {58, 14, 78, -1, 38}
    };
    Board board = new Board(input);
    assertThat(board.sumWithoutMarked()).isNotEqualTo(-1);
  }

  @Test
  void sum_Without_marked_1() {
    int[][] input = {
        {36, 11, 70, -1, 80},
        {63, 3, 56, -1, 28},
        {89, 91, 27, -1, 82},
        {53, 79, 52, -1, 32},
        {58, 14, 78, -1, 38}
    };
    int sum = 36 + 11 + 70 + 80
        + 63 + 3 + 56 + 28
        + 89 + 91 + 27 + 82
        + 53 + 79 + 52 + 32
        + 58 + 14 + 78 + 38;

    Board board = new Board(input);
    assertThat(board.sumWithoutMarked()).isEqualTo(sum);
  }
}