package Aufgabe7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Aufgabe7Test {

  @Test
  void inputTest() {
    String input = "16, 1 ,2 ,0 ,4 ,2 ,7 ,1 ,2 ,14";
    int[] expect = {16, 1, 2, 0, 4, 2, 7, 1, 2, 14};
    int[] inputAsInt = Aufgabe7.readIn(input);

    assertThat(inputAsInt).isEqualTo(expect);
  }

  @Test
  void task1Test() {
    String input = "16, 1 ,2 ,0 ,4 ,2 ,7 ,1 ,2 ,14";
    int expect = 37;

    int result = Aufgabe7.task1(input);

    assertThat(result).isEqualTo(expect);
  }

  @Test
  void task2Test() {
    String input = "16, 1 ,2 ,0 ,4 ,2 ,7 ,1 ,2 ,14";
    int expect = 168;

    int result = Aufgabe7.task2(input);

    assertThat(result).isEqualTo(expect);
  }

  @Test
  void fuelFunctionTask2() {
    int expect = 66;

    Integer fuelCost = Aufgabe7.fuelFunctionTask2.apply(5, 16);

    assertThat(fuelCost).isEqualTo(expect);
  }

  @Test
  void fuelFunctionTask2_2() {
    int expect = 10;

    Integer fuelCost = Aufgabe7.fuelFunctionTask2.apply(5, 1);

    assertThat(fuelCost).isEqualTo(expect);
  }

  @Test
  void fuelFunctionTask2_3() {
    int expect = 45;

    Integer fuelCost = Aufgabe7.fuelFunctionTask2.apply(5, 14);

    assertThat(fuelCost).isEqualTo(expect);
  }
}