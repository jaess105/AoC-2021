package Aufgabe5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void test_point1() {
    Line line = new Line("0,9 -> 5,9");
    assertThat(line.getPoint1()).isEqualTo(new Point(0, 9));
  }

  @Test
  void test_point2() {
    Line line = new Line("0,9 -> 5,9");
    assertThat(line.getPoint2()).isEqualTo(new Point(5, 9));
  }

  @Test
  void test_points() {
    Line line = new Line("1,1 -> 1,3");

    assertThat(line.getPoint1()).isEqualTo(new Point(1, 1));
    assertThat(line.getPoint2()).isEqualTo(new Point(1, 3));
  }


  @Test
  void vertOrHorCoveredPoints() {
    List<Point> expected = List.of(new Point(1, 1), new Point(1, 2), new Point(1, 3));
    Line line = new Line("1,1 -> 1,3");

    List<Point> coveredPoints = line.vertOrHorCoveredPoints();

    assertThat(coveredPoints).isEqualTo(expected);
  }


  @Test
  void vertOrHorCoveredPoints_2() {
    List<Point> expected = List.of(new Point(9, 7), new Point(8, 7), new Point(7, 7));
    Line line = new Line("9,7 -> 7,7");

    List<Point> coveredPoints = line.vertOrHorCoveredPoints();

    assertThat(coveredPoints).containsAll(expected);
  }

  @Test
  void vertOrHorCoveredPoints_3() {
    List<Point> expected = List.of(
        new Point(0, 9),
        new Point(1, 9),
        new Point(2, 9),
        new Point(3, 9),
        new Point(4, 9),
        new Point(5, 9));
    Line line = new Line("0,9 -> 5,9");

    List<Point> coveredPoints = line.vertOrHorCoveredPoints();

    assertThat(coveredPoints).containsAll(expected);
  }

  @Test
  void allCoveredPoints_1() {
    List<Point> expected = List.of(
        new Point(1, 1),
        new Point(2, 2),
        new Point(3, 3));
    Line line = new Line("1,1 -> 3,3");

    List<Point> coveredPoints = line.allCoveredPoints();

    assertThat(coveredPoints).containsAll(expected);
  }

  @Test
  void allCoveredPoints() {
    List<Point> expected = List.of(
        new Point(9, 7),
        new Point(8, 8),
        new Point(7, 9));
    Line line = new Line("9,7 -> 7,9");

    List<Point> coveredPoints = line.allCoveredPoints();

    assertThat(coveredPoints).containsAll(expected);
  }
}