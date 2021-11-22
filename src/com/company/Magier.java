package com.company;

public class Magier extends Spielcharakter {

  public int Mana;

  public Magier(int Herze, int Skills, int schaden, int Mana) {
    super(Herze, Skills, schaden);
    this.Mana = Mana;
  }
}
