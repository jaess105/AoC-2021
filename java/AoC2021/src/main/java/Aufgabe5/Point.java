package Aufgabe5;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

record Point(int x, int y) {

  int distanceVerOrHor(Point other) {
    return (int) sqrt(
        pow(x - other.x, 2) + pow(y - other.y, 2)
    );
  }

  public int distanceX(Point point2) {
    return abs(point2.x - this.x);
  }

  public int distanceY(Point point2) {
    return abs(point2.y - this.y);
  }


}
