package Aufgabe3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Aufgabe3 {

  public static void main(String[] args) throws FileNotFoundException {
    final FileReader file = new FileReader("./src/main/resources/Aufgabe3/input3.txt");
    final BufferedReader reader = new BufferedReader(file);

    List<String> input = reader.lines().collect(Collectors.toList());

    List<String> oxy = new ArrayList<>(input);
    List<String> co2 = new ArrayList<>(input);

    oxy = commonBitMethod(oxy);

    for (int i = 0; i < co2.get(0).length(); i++) {
      int n = co2.size();
      int oxy1Sum = countOnesAtPos(co2, i);
      char common = (char) ('0' + (char) ((n - oxy1Sum <= n / 2) ? 1 : 0));
      final int index = i;
      co2 = filterIfMoreThanOneItem(co2, common == '1' ? '0' : '1', index);
    }

    int oxyBit = toBit(oxy.get(0));
    int co2Bit = toBit(co2.get(0));
    System.out.println(oxyBit);
    System.out.println(co2Bit);
    System.out.println(oxyBit * co2Bit);

  }

  private static List<String> commonBitMethod(List<String> oxy) {
    for (int i = 0; i < oxy.get(0).length(); i++) {
      int n = oxy.size();
      int oxy1Sum = countOnesAtPos(oxy, i);
      char common = (char) ('0' + (char) ((n - oxy1Sum <= n / 2) ? 1 : 0));
      final int index = i;
      oxy = filterIfMoreThanOneItem(oxy, common, index);
    }
    return oxy;
  }

  private static List<String> filterIfMoreThanOneItem(List<String> oxy, char common, int index) {
    if (oxy.size() > 1) {
      oxy = oxy.stream()
          .filter(x -> x.charAt(index) == common)
          .collect(Collectors.toList());
    }
    return oxy;
  }

  private static int countOnesAtPos(List<String> input, int i) {
    return input.stream()
        .mapToInt(str -> str.charAt(i) == '1' ? 1 : 0)
        .sum();
  }

  private static int[] countOnesAtPosInArr(List<String> input) {
    int[] arr = new int[input.get(0).length()];
    for (int j = 0; j < input.size(); j++) {
      String bits = input.get(j);
      for (int i = 0; i < bits.length(); i++) {
        char current = bits.charAt(i);
        arr[i] += current == '1' ? 1 : 0;
      }
    }
    return arr;
  }

  private static int toBit(String common) {
    return IntStream.range(0, common.length())
        .map(i -> (int) (Character.getNumericValue(common.charAt(i))
            * Math.pow(2, common.length() - i - 1)))
        .sum();
  }


  private static void teilaugabe1(BufferedReader reader) {
    List<String> input = reader.lines().collect(Collectors.toList());
    int[] arr = countOnesAtPosInArr(input);
    int gamma = 0;
    int epsilon = 0;
    int n = input.size();
    for (int i = 0; i < arr.length; i++) {
      int common = (n - arr[i] < n / 2) ? 1 : 0;
      double pos = Math.pow(2, arr.length - i - 1);
      gamma += common * pos;
      epsilon += (common == 1 ? 0 : 1) * pos;
    }
    System.out.println(gamma);
    System.out.println(epsilon);
    System.out.println(gamma * epsilon);
  }
}

