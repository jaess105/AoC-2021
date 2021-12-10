package Aufgabe10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Aufgabe10 {

  private final static Map<Character, Integer> PENALTY_TASK_1 = Map.of(
      ')', 3,
      ']', 57,
      '}', 1197,
      '>', 25137
  );
  private final static Map<Character, Character> OPEN_CLOSING = Map.of(
      '(', ')',
      '[', ']',
      '{', '}',
      '<', '>'
  );

  private final static Map<Character, Integer> PENALTY_TASK_2 = Map.of(
      ')', 1,
      ']', 2,
      '}', 3,
      '>', 4
  );

  private static final String path = "./src/main/resources/Aufgabe10/input10.txt";

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(task2(path)); // => 113966469 ; awnser to low :thinking:
  }

  static long task2(String path) throws FileNotFoundException {
    List<Long> integers = new BufferedReader(new FileReader(path))
        .lines()
        .filter(x -> firstErrorSymbol(x) == null)
        .map(Aufgabe10::missingSymbols)
        .map(Aufgabe10::task2Penalty)
        .distinct()
        .sorted()
        .toList();
    return integers.get(integers.size() / 2);
  }

  static long task2Penalty(List<Character> missingSymbols) {
    return missingSymbols.stream()
        .map(PENALTY_TASK_2::get)
        .mapToLong(x -> x)
        .reduce(0L, (x, y) -> x * 5 + y);
  }

  static List<Character> missingSymbols(String firstLine) {
    Stack<Character> missesClosing = fillingStackWithBrackets(firstLine);
    return getMissingBrackets(missesClosing);
  }

  private static List<Character> getMissingBrackets(Stack<Character> missesClosing) {
    return missesClosing.stream()
        .map(OPEN_CLOSING::get)
        .reduce(new ArrayList<>(), (x, y) -> {
          x.add(0, y);
          return x;
        }, (x, y) -> {
          x.addAll(y);
          return x;
        });
  }

  private static Stack<Character> fillingStackWithBrackets(String firstLine) {
    final Stack<Character> stack = new Stack<>();
    for (char c : firstLine.toCharArray()) {
      if (OPEN_CLOSING.containsKey(c)) {
        stack.push(c);
      } else if (OPEN_CLOSING.containsValue(c)) {
        stack.pop();
      } else {
        throw new UnsupportedOperationException("Inkorrektes Zeichen gefunden!");
      }
    }
    return stack;
  }


  static int task1(String path) throws FileNotFoundException {
    return new BufferedReader(new FileReader(path)).lines()
        .map(Aufgabe10::firstErrorSymbol)
        .filter(Objects::nonNull)
        .map(PENALTY_TASK_1::get)
        .reduce(0, Integer::sum);
  }


  static Character firstErrorSymbol(String firstLine) {
    final Stack<Character> stack = new Stack<>();
    for (char c : firstLine.toCharArray()) {
      if (OPEN_CLOSING.containsKey(c)) {
        stack.push(c);
      } else if (OPEN_CLOSING.containsValue(c)) {
        Character closing = stack.pop();
        if (!OPEN_CLOSING.get(closing).equals(c)) {
          return c;
        }
      } else {
        throw new UnsupportedOperationException("Inkorrektes Zeichen gefunden!");
      }
    }
    return null;
  }
}
