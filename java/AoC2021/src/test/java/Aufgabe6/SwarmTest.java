package Aufgabe6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SwarmTest {


  @Test
  void oneRound() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    int expectedPopulation = 5;

    swarm.nextRound();

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

  @Test
  void twoRounds() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    int expectedPopulation = 6;

    swarm.nextRound();
    swarm.nextRound();

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

  @Test
  void threeRounds() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    int expectedPopulation = 7;

    swarm.nextRound();
    swarm.nextRound();
    swarm.nextRound();

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

  @Test
  void fourRounds() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    int expectedPopulation = 9;

    int numberOfRounds = 4;
    for (int i = 0; i < numberOfRounds; i++) {
      swarm.nextRound();
    }

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

  @Test
  void elevenRounds() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    int expectedPopulation = 15;

    int numberOfRounds = 11;
    for (int i = 0; i < numberOfRounds; i++) {
      swarm.nextRound();
    }

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

  @Test
  void eighteenRounds_and_Example() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    int expectedPopulation = 26;

    int numberOfRounds = 18;
    for (int i = 0; i < numberOfRounds; i++) {
      swarm.nextRound();
    }

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

  @Test
  void twoHoundredFiftySixRounds_and_Example() {
    List<Integer> swarmAge = List.of(3, 4, 3, 1, 2);
    SwarmObjects swarm = new SwarmObjects(swarmAge);
    long expectedPopulation = 26984457539L;

    int numberOfRounds = 256;
    for (int i = 0; i < numberOfRounds; i++) {
      swarm.nextRound();
    }

    assertThat(swarm.populationCount()).isEqualTo(expectedPopulation);
  }

}