package com.company;

public class Scwertkaempfer extends Spielcharakter {

  public int Herze;
  public int schaden;
  public boolean resistenz;
  public int Skills;

  public Scwertkaempfer(int Herze, int schaden, boolean resistenz, int Skills) {
    this.Herze = Herze;
    this.schaden = schaden;
    this.resistenz = resistenz;
    this.Skills = Skills;
  }
}
