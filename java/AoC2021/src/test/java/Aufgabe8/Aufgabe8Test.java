package Aufgabe8;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class Aufgabe8Test {

  @Test
  void inputTest() throws IOException {
    final String path = "./src/test/resources/Aufgabe8/testData8.txt";
    int expected = 10;

    List<String[]> strings = Aufgabe8.readInTask1(path);

    assertThat(strings.size()).isEqualTo(expected);
  }

  @Test
  void task1Test() throws IOException {
    final String path = "./src/test/resources/Aufgabe8/testData8.txt";
    int expected = 26;

    long erg = Aufgabe8.task1(path);

    assertThat(erg).isEqualTo(expected);
  }


  @Test
  void task2Mapping() throws IOException {
    final String path = "./src/test/resources/Aufgabe8/testData8.txt";
    int expected = 61229;

    long erg = Aufgabe8.task2(path);

    assertThat(erg).isEqualTo(expected);
  }
}