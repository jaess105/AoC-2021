package Aufgabe11;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DumboOctopusGridTest {

  @Test
  void gridTest() {
    String field = """
        11111
        19991
        19191
        19991
        11111""";
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(field);

    System.out.println(dumboOctopusGrid);

    assertThat(dumboOctopusGrid).isInstanceOf(DumboOctopusGrid.class);
  }

  @Test
  void smallExampleStep1TestGrid() {
    int[][] expected = {
        {3, 4, 5, 4, 3},
        {4, 0, 0, 0, 4},
        {5, 0, 0, 0, 5},
        {4, 0, 0, 0, 4},
        {3, 4, 5, 4, 3}
    };
    String field = """
        11111
        19991
        19191
        19991
        11111""";
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(field);

    dumboOctopusGrid.nextRound();

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expected);
  }

  @Test
  void smallExampleStep1TestFlashes() {
    int expected = 9;
    String field = """
        11111
        19991
        19191
        19991
        11111""";
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(field);

    dumboOctopusGrid.nextRound();

    long flashing = dumboOctopusGrid.countFlashing();

    assertThat(flashing).isEqualTo(expected);
  }

  @Test
  void smallExampleStep2TestGrid() {
    int[][] expected = {
        {4, 5, 6, 5, 4},
        {5, 1, 1, 1, 5},
        {6, 1, 1, 1, 6},
        {5, 1, 1, 1, 5},
        {4, 5, 6, 5, 4},
    };
    String field = """
        11111
        19991
        19191
        19991
        11111""";
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(field);

    dumboOctopusGrid.nextRound();
    dumboOctopusGrid.nextRound();

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expected);
  }

  @Test
  void smallExampleStep2TestFlashes() {
    int expected = 0;

    String field = """
        11111
        19991
        19191
        19991
        11111""";
    DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(field);

    dumboOctopusGrid.nextRound();
    dumboOctopusGrid.nextRound();

    long flashing = dumboOctopusGrid.countFlashing();

    assertThat(flashing).isEqualTo(expected);
  }

  private static final String LARGE_EXAMPLE_INPUT = """
      5483143223
      2745854711
      5264556173
      6141336146
      6357385478
      4167524645
      2176841721
      6882881134
      4846848554
      5283751526""";

  @Test
  void large_Example_Step_1() {
    final int steps = 1;
    final int expectedFlashes = 0;
    final int[][] expectedGrid = {
        {6, 5, 9, 4, 2, 5, 4, 3, 3, 4},
        {3, 8, 5, 6, 9, 6, 5, 8, 2, 2},
        {6, 3, 7, 5, 6, 6, 7, 2, 8, 4},
        {7, 2, 5, 2, 4, 4, 7, 2, 5, 7},
        {7, 4, 6, 8, 4, 9, 6, 5, 8, 9},
        {5, 2, 7, 8, 6, 3, 5, 7, 5, 6},
        {3, 2, 8, 7, 9, 5, 2, 8, 3, 2},
        {7, 9, 9, 3, 9, 9, 2, 2, 4, 5},
        {5, 9, 5, 7, 9, 5, 9, 6, 6, 5},
        {6, 3, 9, 4, 8, 6, 2, 6, 3, 7},
    };
    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    long flashing = dumboOctopusGrid.countFlashing();
    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(flashing).isEqualTo(expectedFlashes);
    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_2() {
    final int steps = 2;
    final int[][] expectedGrid = {
        {8, 8, 0, 7, 4, 7, 6, 5, 5, 5},
        {5, 0, 8, 9, 0, 8, 7, 0, 5, 4},
        {8, 5, 9, 7, 8, 8, 9, 6, 0, 8},
        {8, 4, 8, 5, 7, 6, 9, 6, 0, 0},
        {8, 7, 0, 0, 9, 0, 8, 8, 0, 0},
        {6, 6, 0, 0, 0, 8, 8, 9, 8, 9},
        {6, 8, 0, 0, 0, 0, 5, 9, 4, 3},
        {0, 0, 0, 0, 0, 0, 7, 4, 5, 6},
        {9, 0, 0, 0, 0, 0, 0, 8, 7, 6},
        {8, 7, 0, 0, 0, 0, 6, 8, 4, 8},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_3() {
    final int steps = 3;
    final int[][] expectedGrid = {
        {0, 0, 5, 0, 9, 0, 0, 8, 6, 6},
        {8, 5, 0, 0, 8, 0, 0, 5, 7, 5},
        {9, 9, 0, 0, 0, 0, 0, 0, 3, 9},
        {9, 7, 0, 0, 0, 0, 0, 0, 4, 1},
        {9, 9, 3, 5, 0, 8, 0, 0, 6, 3},
        {7, 7, 1, 2, 3, 0, 0, 0, 0, 0},
        {7, 9, 1, 1, 2, 5, 0, 0, 0, 9},
        {2, 2, 1, 1, 1, 3, 0, 0, 0, 0},
        {0, 4, 2, 1, 1, 2, 5, 0, 0, 0},
        {0, 0, 2, 1, 1, 1, 9, 0, 0, 0},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_4() {
    final int steps = 4;

    final int[][] expectedGrid = {
        {2, 2, 6, 3, 0, 3, 1, 9, 7, 7},
        {0, 9, 2, 3, 0, 3, 1, 6, 9, 7},
        {0, 0, 3, 2, 2, 2, 1, 1, 5, 0},
        {0, 0, 4, 1, 1, 1, 1, 1, 6, 3},
        {0, 0, 7, 6, 1, 9, 1, 1, 7, 4},
        {0, 0, 5, 3, 4, 1, 1, 1, 2, 2},
        {0, 0, 4, 2, 3, 6, 1, 1, 2, 0},
        {5, 5, 3, 2, 2, 4, 1, 1, 2, 2},
        {1, 5, 3, 2, 2, 4, 7, 2, 1, 1},
        {1, 1, 3, 2, 2, 3, 0, 2, 1, 1},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_20() {
    final int steps = 20;

    final int[][] expectedGrid = {
        {3, 9, 3, 6, 5, 5, 6, 4, 5, 2},
        {5, 6, 8, 6, 5, 5, 6, 8, 0, 6},
        {4, 4, 9, 6, 5, 5, 5, 6, 9, 0},
        {4, 4, 4, 8, 6, 5, 5, 5, 8, 0},
        {4, 4, 5, 6, 8, 6, 5, 5, 7, 0},
        {5, 6, 8, 0, 0, 8, 6, 5, 7, 7},
        {7, 0, 0, 0, 0, 0, 9, 8, 9, 6},
        {0, 0, 0, 0, 0, 0, 0, 3, 4, 4},
        {6, 0, 0, 0, 0, 0, 0, 3, 6, 4},
        {4, 6, 0, 0, 0, 0, 9, 5, 4, 3},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_30() {
    final int steps = 30;

    final int[][] expectedGrid = {
        {0, 6, 4, 3, 3, 3, 4, 1, 1, 8},
        {4, 2, 5, 3, 3, 3, 4, 6, 1, 1},
        {3, 3, 7, 4, 3, 3, 3, 4, 5, 8},
        {2, 2, 2, 5, 3, 3, 3, 3, 3, 7},
        {2, 2, 2, 9, 3, 3, 3, 3, 3, 8},
        {2, 2, 7, 6, 7, 3, 3, 3, 3, 3},
        {2, 7, 5, 4, 5, 7, 4, 5, 6, 5},
        {5, 5, 4, 4, 4, 5, 8, 5, 1, 1},
        {9, 4, 4, 4, 4, 4, 7, 1, 1, 1},
        {7, 9, 4, 4, 4, 4, 6, 1, 1, 9},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_60() {
    final int steps = 60;

    final int[][] expectedGrid = {
        {2, 5, 3, 3, 3, 3, 4, 2, 0, 0},
        {2, 7, 4, 3, 3, 3, 4, 6, 4, 0},
        {2, 2, 6, 4, 3, 3, 3, 4, 5, 8},
        {2, 2, 2, 5, 3, 3, 3, 3, 3, 7},
        {2, 2, 2, 5, 3, 3, 3, 3, 3, 8},
        {2, 2, 8, 7, 8, 3, 3, 3, 3, 3},
        {3, 8, 5, 4, 5, 7, 3, 4, 5, 5},
        {1, 8, 5, 4, 4, 5, 8, 6, 1, 1},
        {1, 1, 7, 5, 4, 4, 7, 1, 1, 1},
        {1, 1, 1, 5, 4, 4, 6, 1, 1, 1},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }

  @Test
  void large_Example_Step_100() {
    final int steps = 100;

    final int[][] expectedGrid = {
        {0, 3, 9, 7, 6, 6, 6, 8, 6, 6},
        {0, 7, 4, 9, 7, 6, 6, 9, 1, 8},
        {0, 0, 5, 3, 9, 7, 6, 9, 3, 3},
        {0, 0, 0, 4, 2, 9, 7, 8, 2, 2},
        {0, 0, 0, 4, 2, 2, 9, 8, 9, 2},
        {0, 0, 5, 3, 2, 2, 2, 8, 7, 7},
        {0, 5, 3, 2, 2, 2, 2, 9, 6, 6},
        {9, 3, 2, 2, 2, 2, 8, 9, 6, 6},
        {7, 9, 2, 2, 2, 8, 6, 8, 6, 6},
        {6, 7, 8, 9, 9, 9, 8, 7, 6, 6},
    };

    final DumboOctopusGrid dumboOctopusGrid = new DumboOctopusGrid(LARGE_EXAMPLE_INPUT);

    for (int i = 0; i < steps; i++) {
      dumboOctopusGrid.nextRound();
    }

    int[][] grid = dumboOctopusGrid.getGridAsIntArr();

    assertThat(grid).isEqualTo(expectedGrid);
  }
}