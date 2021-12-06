package Aufgabe6;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwarmMap implements Swarm {

  private Map<Integer, Long> population = new HashMap<>();

  public SwarmMap(List<Integer> populationAge) {
    populationAge.stream().distinct().forEach(
        x -> population.put(x, (long) Collections.frequency(populationAge, x))
    );
  }

  @Override
  public void nextRound() {
    Map<Integer, Long> newPopulation = new HashMap<>();
    population.forEach((key, value) -> {
      if (key != 0) {
        newPopulation.merge(key - 1, value, Long::sum);
      } else {
        newPopulation.merge(8, value, Long::sum);
        newPopulation.merge(6, value, Long::sum);
      }
    });
    population = newPopulation;
  }

  @Override
  public long populationCount() {
    return population.values().stream().reduce(Long::sum).get();
  }
}
