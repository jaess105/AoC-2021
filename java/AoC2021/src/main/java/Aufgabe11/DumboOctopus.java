package Aufgabe11;

class DumboOctopus {

  private int energy;

  DumboOctopus(int energy) {
    this.energy = energy;
  }

  void nextReound() {
    energy++;
  }

  boolean isFlashing() {
    return energy > 9 || energy == 0;
  }

  boolean canFlash() {
    return energy > 9;
  }

  void flash() {
    if (energy > 9) {
      energy = 0;
    }
  }

  void increaseEnergyByNeighbour() {
    if (energy != 0) {
      energy++;
    }
  }

  @Override
  public String toString() {
    return "DumboOctopus{" +
        "energy=" + energy +
        '}';
  }

  public int getEnergy() {
    return energy;
  }
}
