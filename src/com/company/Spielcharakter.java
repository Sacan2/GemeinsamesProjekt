package com.company;

public class Spielcharakter {
  int Herze;
  int Skills;
  int schaden;
  int numHealthPots;
  int healtjPotionHealZahl;
  int healthPotionDropChance;

  public Spielcharakter(
      int Herze,
      int Skills,
      int scahden,
      int numHealthPots,
      int healtjPotionHealZahl,
      int healthPotionDropChance) {
    this.Herze = Herze;
    this.Skills = Skills;
    this.schaden = scahden;
    this.numHealthPots = numHealthPots;
    this.healtjPotionHealZahl = healtjPotionHealZahl;
    this.healthPotionDropChance = healthPotionDropChance;
  }
}
