package core;

public class Computer extends Product {
  private int clockSpeed;

  private int ramSize;

  public int getClockSpeed() {
    return clockSpeed;
  }

  public void setClockSpeed(int clockSpeed) {
    this.clockSpeed = clockSpeed;
  }

  public int getRamSize() {
    return ramSize;
  }

  public void setRamSize(int ramSize) {
    this.ramSize = ramSize;
  }
}
