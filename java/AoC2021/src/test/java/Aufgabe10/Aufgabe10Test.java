package Aufgabe10;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;

class Aufgabe10Test {

  private final String testPath = "./src/test/resources/Aufgabe10/testData.txt";

  @Test
  void testFirstLineWithError() {
    final Character expected = '}';
    final String firstLineWithError = "{([(<{}[<>[]}>{[]{[(<()>";

    final Character errorSymbol = Aufgabe10.firstErrorSymbol(firstLineWithError);

    assertThat(errorSymbol).isEqualTo(expected);
  }

  @Test
  void testSecondLineWithError() {
    final Character expected = ')';
    final String firstLineWithError = "[[<[([]))<([[{}[[()]]]";

    final Character errorSymbol = Aufgabe10.firstErrorSymbol(firstLineWithError);

    assertThat(errorSymbol).isEqualTo(expected);
  }

  @Test
  void testthirdLineWithError() {
    final Character expected = ']';
    final String firstLineWithError = "[{[{({}]{}}([{[{{{}}([]";

    final Character errorSymbol = Aufgabe10.firstErrorSymbol(firstLineWithError);

    assertThat(errorSymbol).isEqualTo(expected);
  }

  @Test
  void testFourthLineWithError() {
    final Character expected = ')';
    final String firstLineWithError = "[<(<(<(<{}))><([]([]()";

    final Character errorSymbol = Aufgabe10.firstErrorSymbol(firstLineWithError);

    assertThat(errorSymbol).isEqualTo(expected);
  }

  @Test
  void testFifthLineWithError() {
    final Character expected = '>';
    final String firstLineWithError = "<{([([[(<>()){}]>(<<{{";

    final Character errorSymbol = Aufgabe10.firstErrorSymbol(firstLineWithError);

    assertThat(errorSymbol).isEqualTo(expected);
  }

  @Test
  void task1Test() throws FileNotFoundException {
    int expected = 26397;

    int result = Aufgabe10.task1(testPath);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void testFirstLineWithMisses() {
    final List<Character> expected = List.of('}', '}', ']', ']', ')', '}', ')', ']');
    final String firstLineWithMisses = "[({(<(())[]>[[{[]{<()<>>";

    final List<Character> missingSymbols = Aufgabe10.missingSymbols(firstLineWithMisses);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testSecondLineWithMisses() {
    final List<Character> expected = List.of(')', '}', '>', ']', '}', ')');
    final String firstLineWithMisses = "[(()[<>])]({[<{<<[]>>(";

    final List<Character> missingSymbols = Aufgabe10.missingSymbols(firstLineWithMisses);

    assertThat(missingSymbols).isEqualTo(expected);
  }


  @Test
  void testthirdLineWithMisses() {
    final List<Character> expected =
        List.of('}', '}', '>', '}', '>', ')', ')', ')', ')');
    final String firstLineWithMisses = "(((({<>}<{<{<>}{[]{[]{}";

    final List<Character> missingSymbols = Aufgabe10.missingSymbols(firstLineWithMisses);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testFourthLineWithMisses() {
    final List<Character> expected =
        List.of(']', ']', '}', '}', ']', '}', ']', '}', '>');
    final String firstLineWithMisses = "{<[[]]>}<{[{[{[]{()[[[]";

    final List<Character> missingSymbols = Aufgabe10.missingSymbols(firstLineWithMisses);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testFifthLineWithMisses() {
    final List<Character> expected = List.of(']', ')', '}', '>');
    final String firstLineWithMisses = "<{([{{}}[<[[[<>{}]]]>[]]";

    final List<Character> missingSymbols = Aufgabe10.missingSymbols(firstLineWithMisses);

    assertThat(missingSymbols).isEqualTo(expected);
  }


  @Test
  void testFirstLinePenalty() {
    final int expected = 288957;
    final List<Character> firstLinePenalty = List.of('}', '}', ']', ']', ')', '}', ')', ']');

    final long missingSymbols = Aufgabe10.task2Penalty(firstLinePenalty);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testSecondLinePenalty() {
    final int expected = 5566;
    final List<Character> firstLinePenalty = List.of(')', '}', '>', ']', '}', ')');

    final long missingSymbols = Aufgabe10.task2Penalty(firstLinePenalty);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testThirdLinePenalty() {
    final int expected = 1480781;
    final List<Character> firstLinePenalty = List.of('}', '}', '>', '}', '>', ')', ')', ')', ')');

    final long missingSymbols = Aufgabe10.task2Penalty(firstLinePenalty);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testFourthLinePenalty() {
    final int expected = 995444;
    final List<Character> firstLinePenalty = List.of(']', ']', '}', '}', ']', '}', ']', '}', '>');

    final long missingSymbols = Aufgabe10.task2Penalty(firstLinePenalty);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void testFifthLinePenalty() {
    final int expected = 294;
    final List<Character> firstLinePenalty = List.of(']', ')', '}', '>');

    final long missingSymbols = Aufgabe10.task2Penalty(firstLinePenalty);

    assertThat(missingSymbols).isEqualTo(expected);
  }

  @Test
  void task2Test() throws FileNotFoundException {
    int expected = 288957;

    long result = Aufgabe10.task2(testPath);

    assertThat(result).isEqualTo(expected);
  }

}