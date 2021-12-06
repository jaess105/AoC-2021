package Aufgabe6;

import java.util.List;

public class LanternFish {

  private int age;

  public LanternFish(int age) {
    this.age = age;
  }

  public List<LanternFish> newRound() {
    if (age == 0) {
      age = 6;
      return List.of(this, new LanternFish(8));
    } else {
      age -= 1;
      return List.of(this);
    }

  }


}
