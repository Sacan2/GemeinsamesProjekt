package com.company;

import java.util.Scanner;

public class Gameplay {
    Scanner Eingabe = new Scanner(System.in);


    // Unsere Charaktere in Objekten umwandeln
    Scwertkaempfer Aragon = new Scwertkaempfer(5, 15, true, 1);
    Magier Gandalf = new Magier(2, 25, 10, 3);
    Bogenschuetze Legolas = new Bogenschuetze(4, 10, 10, 2);

    public void Intro (){
        // Intro
        System.out.println("Willkommen zu D&D");
        System.out.println("Die Regeln des Spieles sind Simpel, wähle einen der 3 Charaktere aus. Jeder Charakter hat seine Stärken und Schwächen.");
        System.out.println("Um die Charaktere anzusehen schreibe den vollen Namen des Charakteres oder den ersten Buchstaben klein geschrieben.(Schwertkämpfer,s,Magier,m,Bogenschütze,b)");
        System.out.println("Solltest du 0 Herze erreichen ist das Spiel vorbei.Mit help werden dir die Befehle angezeigt, die Story ist selbst erklärend Viel Glück!");
    }


    public void Spielsollstarten () {
        boolean Spielstarten= true;
        Spielcharakter AusgewaehlteCharakter = null;

        //Schleife Start
        while (Spielstarten) {

            String Antwort = Eingabe.nextLine();



            //Eingabe und Auswahl

                    switch (Antwort) {
                        case "Schwertkämpfer","s"  -> {
        
                            if (!istCharakterBereitsAusgewaehlt(AusgewaehlteCharakter)){


                                    System.out.println("Der Schwertkämpfer Status:");
                                    System.out.println("Die Anzahl an Herzen " + Aragon.Herze);
                                    System.out.println("Der Schaden pro Angriff " + Aragon.schaden);
                                    System.out.println("Hat er Resistenzen? " + Aragon.resistenz);
                                    System.out.println("Die Anzahl an Fähugkeiten "+Aragon.Skills + "\n");
                                    System.out.println("Wollen Sie diesen Charakter auswählen? Falls ja schreiben Sie y falls nicht können Sie dei anderen Charaktere ansehen.");
        
                                    String bestaetigenfuerchamp = Eingabe.nextLine();
                                    if (bestaetigenfuerchamp.equals("y") ) {
                                        AusgewaehlteCharakter=Aragon;
                                        AnfangStory();
        
                                    }


                            }
                        }
        
                        case "Magier","m" -> {
                            if (!istCharakterBereitsAusgewaehlt(AusgewaehlteCharakter)){


                                      System.out.println("Der Magier Status:");
                                      System.out.println("Die Anzahl an Herzen " + Gandalf.Herze);
                                      System.out.println("Der Schaden pro Angriff "+Gandalf.Magischenschaden);
                                      System.out.println("Sein Mana "+Gandalf.Mana);
                                      System.out.println("Die Anzahl an Fähugkeiten "+Gandalf.Skills+ "\n");
                                      System.out.println("Wollen Sie diesen Charakter auswählen? Falls ja schreiben Sie y falls nicht können Sie dei anderen Charaktere ansehen.");
                                  }
                                    String bestaetigenfuerchamp = Eingabe.nextLine();
                                    if (bestaetigenfuerchamp.equals("y")) {
                                        AusgewaehlteCharakter=Gandalf;
                                        AnfangStory();

                                    }


                        }
        
                        case "Bogenschütze","b" -> {
                            if (!istCharakterBereitsAusgewaehlt(AusgewaehlteCharakter)){

                            System.out.println("Der Bogenschütze Status:");
                            System.out.println("Die Anzahl an Herzen "+Legolas.Herze);
                            System.out.println("Der Scchaden Pro Angriff "+Legolas.schaden);
                            System.out.println("Die Anzahl an Pfeilen "+Legolas.Pfeile);
                            System.out.println("Die Anzahl an Fähugkeiten "+Legolas.Skills+ "\n");
        
                                System.out.println("Wollen Sie diesen Charakter auswählen? Falls ja schreiben Sie y falls nicht können Sie dei anderen Charaktere ansehen.");
                                }
                                String bestaetigenfuerchamp = Eingabe.nextLine();
                                if (bestaetigenfuerchamp.equals("y") ) {
                                    AusgewaehlteCharakter=Legolas;
                                    AnfangStory();
        
                                }


                        }
                        case "EXIT" -> {
                            System.out.println("YOU DIED!");
                            System.out.println("Du hat keine Herzen mehr!");
                            Spielstarten = false;
                        }
                        case "stats" -> System.out.println(istCharakterBereitsAusgewaehlt(AusgewaehlteCharakter));
                        case "help" -> System.out.println("Mit 'EXIT' wird das Spiel beendet ");

                        default ->{
                            System.out.println("'"+ Antwort+"'" +"  ist keine Eingabe die angenommen werden kann bitte wiederholen oder Spiel verlassen!");

                        }
                    }
                    if (Aragon.Herze==0||Gandalf.Herze==0||Legolas.Herze==0){

                        System.out.println("Game OVER!");
                        System.exit(0);
                    }
                }

        }


    //Methoden benutzen um die Story zu schreiben, um es afu jeden Charakter zu benutzen
    public boolean istCharakterBereitsAusgewaehlt (Spielcharakter AusgewaehlterCharakter) {
        if (AusgewaehlterCharakter!=null){
            System.out.println("Du hast bereits einen Charakter ausgewählt!!");
            return true;
        }
        else {
            return false;
        }
    }
    public void AnfangStory(){
        System.out.println("Die Leere bahnte sich mit der Entstehung des Universums ihren Weg in die Existenz und ist die Manifestation des unergründlichen Nichts,");
        System.out.println("das dahinter liegt. Sie ist eine Kraft voller unstillbarem Verlangen, die Äonen lang wartet,bis ihre Meister, die mysteriösen Wächter,");
        System.out.println("endlich den Untergang der Welt herbeiführen.Wenn ein Sterblicher von dieser Macht berührt wird,erhält er einen quälenden Einblick");
        System.out.println("in die unendlichen Unwirklichkeiten, die selbst die stärksten Geister erschüttern.Die Bewohner der Leere selbst sind Konstrukt-Kreaturen, ");
        System.out.println("oft von beschränkter Intelligenz, die einem einzigen Zweck dienen – die totale Vernichtung über Runeterra zu bringen."+ "\n");
        System.out.println("Du wachst auf mit keiner Erinnerung über dein Leben. Rechts von dir steht ein Portal.");
        System.out.println("Zur selben Zeit hörst du eine Person um Hilfe schreien der Schrei kommt von deiner Linken Seite!('r' um das Portal zu betretten und 'l' um den Schrei nachzugehen )");


        char Ersteentscheidung = Eingabe.next().charAt(0);
        if (Ersteentscheidung=='r'){
                inVoidbleiben();
        }
        else if (Ersteentscheidung=='l'){
                Targonbetreten();
        }
    }
    public void inVoidbleiben(){
            System.out.println("Du bist im Void geblieben!");
        char ErsteVoidentscheidung = Eingabe.next().charAt(0);
        if (ErsteVoidentscheidung=='s'){
            VoidersterPart();
        }
        else if (ErsteVoidentscheidung=='l'){

        }
    }
    public void VoidersterPart(){
        System.out.println("Der Schrei kam von einem Kleinen Mädchen das sich verlaufen hat!");
    }

    public void Targonbetreten(){
            System.out.println("Du bist im Taragon!");
    }
}