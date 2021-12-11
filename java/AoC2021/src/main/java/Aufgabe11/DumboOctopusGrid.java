package Aufgabe11;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DumboOctopusGrid {

  private DumboOctopus[][] grid;

  public DumboOctopusGrid(DumboOctopus[][] grid) {
    this.grid = grid;
  }

  public DumboOctopusGrid(String field) {
    grid = stringToOctoArr(field);
  }

  private static DumboOctopus[][] stringToOctoArr(String field) {
    return Arrays.stream(field.split("\n")).map(line ->
        Arrays.stream(line.split(""))
            .filter(place -> !place.isBlank())
            .map(Integer::parseInt)
            .map(DumboOctopus::new)
            .toArray(size -> new DumboOctopus[size])
    ).toArray(DumboOctopus[][]::new);
  }

  public void nextRound() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j].nextReound();
      }
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j].canFlash()) {
          grid[i][j].flash();
          recursiveNeighbourIncreas(i, j);
        }
      }
    }
  }

  private void recursiveNeighbourIncreas(int i, int j) {
    for (int x = i - 1; x < i + 2; x++) {
      for (int y = j - 1; y < j + 2; y++) {
        if (x != i || y != j) {
          increaseAndCallRecurse(x, y);
        }
      }
    }
  }

  private void increaseAndCallRecurse(int x, int y) {
    try {
      DumboOctopus dumboOctopus = grid[x][y];
      dumboOctopus.increaseEnergyByNeighbour();
      if (dumboOctopus.canFlash()) {
        dumboOctopus.flash();
        recursiveNeighbourIncreas(x, y);
      }
    } catch (IndexOutOfBoundsException ignored) {
    }
  }

  public long countFlashing() {
    return Arrays.stream(grid).mapToLong(line ->
        Arrays.stream(line).filter(DumboOctopus::isFlashing).count()
    ).sum();
  }

  int[][] getGridAsIntArr() {
    return Arrays.stream(grid).map(line ->
        Arrays.stream(line).mapToInt(DumboOctopus::getEnergy).toArray()
    ).toArray(int[][]::new);
  }

  @Override
  public String toString() {
    return String.format("""
        DumboOctopusGrid{ grid =
        %s
        """, Arrays.stream(grid).map(Arrays::toString).collect(Collectors.joining("\n")));
  }


  public int size() {
    return grid.length * grid[0].length;
  }
}
