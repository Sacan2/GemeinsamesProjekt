package com.company;

public class Bogenschuetze extends Spielcharakter {
  public int Herze;
  public int schaden;
  public int Pfeile;
  public int Skills;

  public Bogenschuetze(int Herze, int schaden, int Pfeile, int Skills) {
    this.Herze = Herze;
    this.schaden = schaden;
    this.Pfeile = Pfeile;
    this.Skills = Skills;
  }
}
