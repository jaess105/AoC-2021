package Aufgabe5;

import static java.lang.Integer.min;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

import com.google.common.collect.Streams;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

  private final Point point1;
  private final Point point2;

  Line(int x1, int y1, int x2, int y2) {
    point1 = new Point(x1, y1);
    point2 = new Point(x2, y2);
  }


  public Line(String eingabe) {
    String points[] = eingabe.split(" -> ");
    point1 = constructPoint(points[0]);
    point2 = constructPoint(points[1]);
  }

  private Point constructPoint(String point) {
    String[] xAndY = point.split(",");
    return new Point(parseInt(xAndY[0]), parseInt(xAndY[1]));
  }

  Point getPoint1() {
    return point1;
  }

  Point getPoint2() {
    return point2;
  }

  boolean vertOrHor() {
    return point1.x() == point2.x() || point1.y() == point2.y();
  }

  List<Point> vertOrHorCoveredPoints() {
    if (point1.x() - point2.x() != 0) {
      int minX = min(point1.x(), point2.x());
      IntFunction<Point> newXCoordinates = x -> new Point(x, point1.y());
      return coveredPoints(minX, newXCoordinates);
    } else {
      int minY = min(point1.y(), point2.y());
      IntFunction<Point> newYCoordinates = y -> new Point(point1.x(), y);
      return coveredPoints(minY, newYCoordinates);
    }
  }

  List<Point> allCoveredPoints() {
    if (point1.x() - point2.x() != 0 && point1.y() - point2.y() != 0) {
      BiFunction<Integer, Integer, Point> newXYCoordinates = (x, y) -> new Point(x, y);
      return coveredPoints(newXYCoordinates);
    } else {
      return vertOrHorCoveredPoints();
    }
  }

  private List<Point> coveredPoints(BiFunction<Integer, Integer, Point> newXYCoordinates) {
    Stream<Integer> xRange = determinRangeFun(point1.x(), point2.x(), point1.distanceX(point2));
    Stream<Integer> yRange = determinRangeFun(point1.y(), point2.y(), point1.distanceY(point2));

    return Streams.zip(xRange, yRange, newXYCoordinates)
        .collect(Collectors.toList());
  }


  private Stream<Integer> determinRangeFun(int coordinate1, int coordinate2, int distance) {
    if (coordinate1 > coordinate2) {
      return iterate(coordinate1,
          x -> x >= coordinate1 - distance,
          x -> x - 1)
          .boxed();
    } else {
      return rangeClosed(coordinate1, coordinate1 + distance).boxed();
    }
  }

  private List<Point> coveredPoints(int min,
      IntFunction<Point> getPointIntFunction) {
    return rangeClosed(min, min + point1.distanceVerOrHor(point2))
        .mapToObj(getPointIntFunction)
        .collect(Collectors.toList());
  }


  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    } else if (!(obj instanceof Line)) {
      return false;
    } else {
      final Line other = (Line) obj;
      return this.point1.equals(other.point1) && this.point2.equals(other.point2);
    }
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + point1.hashCode();
    result = 31 * result + point2.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return format("(x1:%d, y2:%d) -> (x2:%d, y2:%d)", point1.x(), point1.y(), point2.x(),
        point2.y());
  }
}

