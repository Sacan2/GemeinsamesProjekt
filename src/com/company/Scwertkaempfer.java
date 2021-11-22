package com.company;

public class Scwertkaempfer extends Spielcharakter {

  public boolean resistenz;

  public Scwertkaempfer(int Herze, int Skills, int schaden, boolean resistenz) {
    super(Herze, Skills, schaden);
    this.resistenz = resistenz;
  }
}
