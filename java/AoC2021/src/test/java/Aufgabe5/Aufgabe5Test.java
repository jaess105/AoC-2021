package Aufgabe5;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.junit.jupiter.api.Test;

class Aufgabe5Test {


  @Test
  void correctReadIn() throws FileNotFoundException {
    List<Line> expected = List.of(new Line(0, 9, 5, 9),
        new Line(8, 0, 0, 8),
        new Line(9, 4, 3, 4),
        new Line(2, 2, 2, 1),
        new Line(7, 0, 7, 4),
        new Line(6, 4, 2, 0),
        new Line(0, 9, 2, 9),
        new Line(3, 4, 1, 4),
        new Line(0, 0, 8, 8),
        new Line(5, 5, 8, 2));
    FileReader testFile = new FileReader("./src/test/resources/Aufgabe5/test.txt");

    List<Line> lines = Aufgabe5.readIn(testFile);

    assertThat(lines).containsAll(expected);

  }

  @Test
  void task1Test() throws FileNotFoundException {
    int expected = 5;
    FileReader testFile = new FileReader("./src/test/resources/Aufgabe5/test.txt");

    long result = Aufgabe5.task1(testFile);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void task2Test() throws FileNotFoundException {
    int expected = 12;
    FileReader testFile = new FileReader("./src/test/resources/Aufgabe5/test.txt");

    long result = Aufgabe5.task2(testFile);

    assertThat(result).isEqualTo(expected);
  }

}