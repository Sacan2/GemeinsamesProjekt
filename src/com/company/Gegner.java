package com.company;

public class Gegner {
  String[] enemies = {"Skelett", "Zombie", "Krieger", "Assasine"};

  int Leben;
  int Schaden;

  public Gegner(int Leben, int Schaden) {
    this.Leben = Leben;
    this.Schaden = Schaden;
  }
}
