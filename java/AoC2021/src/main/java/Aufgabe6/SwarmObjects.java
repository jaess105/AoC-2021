package Aufgabe6;

import java.util.List;
import java.util.stream.Collectors;

public class SwarmObjects implements Swarm {

  private List<LanternFish> swarm;


  public SwarmObjects(List<Integer> swarmAge) {
    this.swarm = swarmAge.stream().map(LanternFish::new).collect(Collectors.toList());
  }


  @Override
  public void nextRound() {
    swarm = swarm.stream().flatMap(fish -> fish.newRound().stream()).collect(Collectors.toList());
  }

  @Override
  public long populationCount() {
    return swarm.size();
  }
}
