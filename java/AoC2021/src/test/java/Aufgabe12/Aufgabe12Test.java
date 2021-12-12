package Aufgabe12;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Aufgabe12Test {

  private static final String SMALL_DATA_PATH = "./src/test/resources/Aufgabe12/testDataSmall.txt";
  private static final String MEDIUM_DATA_PATH = "./src/test/resources/Aufgabe12/testDataMedium.txt";
  private static final String LARGE_DATA_PATH = "./src/test/resources/Aufgabe12/testDataLarge.txt";

  @Nested
  class task1_tests {

    @Test
    void testSmallData() throws FileNotFoundException {
      int expected = 10;
      int result = Aufgabe12.task1(SMALL_DATA_PATH);
      assertThat(result).isEqualTo(expected);
    }

    @Test
    void testMediumData() throws FileNotFoundException {
      int expected = 19;
      int result = Aufgabe12.task1(MEDIUM_DATA_PATH);
      assertThat(result).isEqualTo(expected);
    }

    @Test
    void testLargeData() throws FileNotFoundException {
      int expected = 226;
      int result = Aufgabe12.task1(LARGE_DATA_PATH);
      assertThat(result).isEqualTo(expected);
    }
  }

  @Nested
  class Tas2_Tests {

    @Test
    void testSmallDataTask2() throws FileNotFoundException {
      int expected = 36;
      int result = Aufgabe12.task2(SMALL_DATA_PATH);
      assertThat(result).isEqualTo(expected);
    }

    @Test
    void testMediumDataTask2() throws FileNotFoundException {
      int expected = 103;
      int result = Aufgabe12.task2(MEDIUM_DATA_PATH);
      assertThat(result).isEqualTo(expected);
    }

    @Test
    void testLargeDataTask2() throws FileNotFoundException {
      int expected = 3509;
      int result = Aufgabe12.task2(LARGE_DATA_PATH);
      assertThat(result).isEqualTo(expected);
    }
  }


}