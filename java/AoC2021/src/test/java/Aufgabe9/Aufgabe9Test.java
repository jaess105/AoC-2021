package Aufgabe9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class Aufgabe9Test {

  @Test
  void readIn() throws IOException {
    int[][] expected = {
        {2, 1, 9, 9, 9, 4, 3, 2, 1, 0},
        {3, 9, 8, 7, 8, 9, 4, 9, 2, 1},
        {9, 8, 5, 6, 7, 8, 9, 8, 9, 2},
        {8, 7, 6, 7, 8, 9, 6, 7, 8, 9},
        {9, 8, 9, 9, 9, 6, 5, 6, 7, 8}};
    int[][] readIn = Aufgabe9.readIn("./src/test/resources/Aufgabe9/testData.txt");

    assertThat(readIn).isEqualTo(expected);
  }

  @Test
  void task1Test() throws IOException {
    int expected = 15;

    long readIn = Aufgabe9.task1("./src/test/resources/Aufgabe9/testData.txt");

    assertThat(readIn).isEqualTo(expected);
  }

  @Test
  void task2Test() throws IOException {
    int expected = 1134;

    long readIn = Aufgabe9.task2("./src/test/resources/Aufgabe9/testData.txt");

    assertThat(readIn).isEqualTo(expected);
  }
}