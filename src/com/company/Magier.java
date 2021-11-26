package com.company;

public class Magier extends Spielcharakter {

  public int Mana;

  public Magier(
      int Herze,
      int Skills,
      int schaden,
      int Mana,
      int numHealthPots,
      int healtjPotionHealZahl,
      int healthPotionDropChance) {
    super(Herze, Skills, schaden, numHealthPots, healtjPotionHealZahl, healthPotionDropChance);
    this.Mana = Mana;
  }
}
