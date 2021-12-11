package Aufgabe11;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

class Aufgabe11Test {

  private static final String TEST_PATH = "./src/test/resources/Aufgabe11/testData.txt";

  @Test
  void task1() throws FileNotFoundException {
    long expected = 1656;

    long totalFlashes = Aufgabe11.task1(TEST_PATH);

    assertThat(totalFlashes).isEqualTo(expected);

  }

  @Test
  void task2() throws FileNotFoundException {
    int expected = 195;

    int roundOfSynchronizedFlash = Aufgabe11.task2(TEST_PATH);

    assertThat(roundOfSynchronizedFlash).isEqualTo(expected);

  }
}