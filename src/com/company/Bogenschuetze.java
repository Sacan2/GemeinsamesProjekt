package com.company;

public class Bogenschuetze extends Spielcharakter {

  public int Pfeile;

  public Bogenschuetze(int Herze, int Skills, int schaden, int Pfeile) {
    super(Herze, Skills, schaden);

    this.Pfeile = Pfeile;
  }
}
