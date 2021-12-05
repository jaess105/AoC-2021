package Aufgabe5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void distanceTest_1() {
    Point point1 = new Point(1, 1);
    Point point2 = new Point(1, 3);

    int distance = point1.distanceVerOrHor(point2);

    assertThat(distance).isEqualTo(2);
  }

  @Test
  void distanceTest_2() {
    Point point1 = new Point(9, 7);
    Point point2 = new Point(7, 7);

    int distance = point1.distanceVerOrHor(point2);

    assertThat(distance).isEqualTo(2);
  }

  @Test
  void distanceTest_3() {
    Point point1 = new Point(0, 9);
    Point point2 = new Point(5, 9);

    int distance = point1.distanceVerOrHor(point2);

    assertThat(distance).isEqualTo(5);
  }

  @Test
  void distanceTest_4() {
    Point point1 = new Point(9,4);
    Point point2 = new Point(3,4);

    int distance = point1.distanceVerOrHor(point2);

    assertThat(distance).isEqualTo(6);
  }

}