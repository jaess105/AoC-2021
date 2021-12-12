package Aufgabe12;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Helper {

  private Helper() {
  }

  public static <T> Set<T> findDuplicates(List<T> listContainingDuplicates) {
    final Set<T> controllSet = new HashSet<>();

    final Set<T> duplicates = listContainingDuplicates.stream()
        .filter(el -> !controllSet.add(el)) // add is false if element already in Set.
        .collect(Collectors.toSet());

    return duplicates;
  }

  public static <T> List<T> findWithQuantityDuplicates(List<T> listContainingDuplicates) {
    final Set<T> controllSet = new HashSet<>();

    final List<T> duplicates = listContainingDuplicates.stream()
        .filter(el -> !controllSet.add(el)) // add is false if element already in Set.
        .toList();

    return duplicates;
  }


}
