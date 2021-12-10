package Aufgabe8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SegmentTest {

  @Test
  void deduce() {
    List<String> input = List.of("acedgfb", " cdfbe ", "gcdfa ", "fbcad ", "dab ", "cefabd ",
        "cdfgeb ", "eafb ", "cagedb ", "ab", " cdfeb", " fcadb", " cdfeb", " cdbaf");

    Segment segment = new Segment(input);

    assertThat(segment.getValue("acedgfb")).isEqualTo(8);
    assertThat(segment.getValue("cdfbe")).isEqualTo(5);
    assertThat(segment.getValue("gcdfa")).isEqualTo(2);
    assertThat(segment.getValue("fbcad")).isEqualTo(3);
    assertThat(segment.getValue("dab")).isEqualTo(7);
    assertThat(segment.getValue("cefabd")).isEqualTo(9);
    assertThat(segment.getValue("cdfgeb")).isEqualTo(6);
    assertThat(segment.getValue("eafb")).isEqualTo(4);
    assertThat(segment.getValue("cagedb")).isEqualTo(0);
    assertThat(segment.getValue("ab")).isEqualTo(1);
  }
}