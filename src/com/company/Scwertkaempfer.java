package com.company;

public class Scwertkaempfer extends Spielcharakter {

  public boolean resistenz;

  public Scwertkaempfer(
      int Herze,
      int Skills,
      int schaden,
      boolean resistenz,
      int numHealthPots,
      int healtjPotionHealZahl,
      int healthPotionDropChance) {
    super(Herze, Skills, schaden, numHealthPots, healtjPotionHealZahl, healthPotionDropChance);
    this.resistenz = resistenz;
  }
}
