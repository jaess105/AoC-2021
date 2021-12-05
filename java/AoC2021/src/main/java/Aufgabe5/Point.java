package Aufgabe5;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

record Point(int x, int y) {

  // TODO: be carefull here. Correct formular but could make Problems later on.
  int distanceVerOrHor(Point other) {
    return (int) sqrt(
        pow(abs(x - other.x), 2) + pow(abs(y - other.y), 2)
    );
    //return abs(other.x - this.x) + abs(other.y - this.y);
  }

  public int distanceX(Point point2) {
    return abs(point2.x - this.x);
  }

  public int distanceY(Point point2) {
    return abs(point2.y - this.y);
  }
}
