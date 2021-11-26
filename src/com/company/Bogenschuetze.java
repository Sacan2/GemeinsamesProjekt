package com.company;

public class Bogenschuetze extends Spielcharakter {

  public int Pfeile;

  public Bogenschuetze(
      int Herze,
      int Skills,
      int schaden,
      int Pfeile,
      int numHealthPots,
      int healtjPotionHealZahl,
      int healthPotionDropChance) {
    super(Herze, Skills, schaden, numHealthPots, healtjPotionHealZahl, healthPotionDropChance);

    this.Pfeile = Pfeile;
  }
}
