package com.company;

import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    //Farben
    String ANSI_RESET = "\u001B[0m";
    String ANSI_BLACK = "\u001B[30m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";
    String ANSI_WHITE = "\u001B[37m";


    Scanner Eingabe = new Scanner(System.in);
    Random rand = new Random();


    // Unsere Charaktere in Objekten umwandeln
    Scwertkaempfer Aragon = new Scwertkaempfer(80,1,15,true,10,30,50);
    Magier Gandalf = new Magier( 35,3,45,10,2,15,50);
    Bogenschuetze Legolas = new Bogenschuetze( 55,2,30,10,20,30,50);

    Spielcharakter AusgewaehlteCharakter = null;


    //Gegner erstellen für unseren Charakter
    Gegner Goblin = new Gegner(50,25);

    public void Intro (){
        // Intro
        System.out.println("Willkommen zu Dungeons & Dragons");
        System.out.println("Die Regeln des Spieles sind Simpel, wähle einen der 3 Charaktere aus. Jeder Charakter hat seine Stärken und Schwächen.");
        System.out.println("Um die Charaktere anzusehen schreibe den vollen Namen des Charakteres oder den ersten Buchstaben klein geschrieben.(Schwertkämpfer,s,Magier,m,Bogenschütze,b)");
        System.out.println("Solltest du 0 Herze erreichen ist das Spiel vorbei.Mit help werden dir die Befehle angezeigt, die Story ist selbst erklärend Viel Glück!");
    }


    public void Spielsollstarten () {
        boolean Spielstarten= true;

        //Schleife Start

        while (Spielstarten) {

            String Antwort = Eingabe.nextLine();
            //Eingabe und Auswahl
            switch (Antwort) {
                case "Schwertkämpfer","s"  -> {

                    if (!istCharakterBereitsAusgewaehlt(AusgewaehlteCharakter)){
                        System.out.println("Der Schwertkämpfer Status:");
                        System.out.println("Die Anzahl an Herzen " +ANSI_RED+ Aragon.Herze+ANSI_RESET);
                        System.out.println("Der Schaden pro Angriff " + Aragon.schaden);
                        System.out.println("Hat er Resistenzen? " + Aragon.resistenz);
                        System.out.println("Die Anzahl an Heiltränke "+Aragon.numHealthPots);
                        System.out.println("Die Anzahl an Fähigkeiten "+Aragon.Skills + "\n");
                        System.out.println("Wollen Sie diesen Charakter auswählen? Falls ja schreiben Sie y falls nicht können Sie dei anderen Charaktere ansehen.");
                        }
                        String bestaetigenfuerchamp = Eingabe.nextLine();
                        if (bestaetigenfuerchamp.equals("y") ) {
                            AusgewaehlteCharakter=Aragon;
                            AnfangStory();

                        }

                }

                case "Magier","m" -> {
                    if (!istCharakterBereitsAusgewaehlt(AusgewaehlteCharakter)){
                        System.out.println("Der Magier Status:");
                        System.out.println("Die Anzahl an Herzen "+ANSI_RED+Gandalf.Herze+ANSI_RESET);
                        System.out.println("Der Schaden pro Angriff "+Gandalf.schaden);
                        System.out.println("Sein Mana "+Gandalf.Mana);
                        System.out.println("Die Anzahl an Heiltränke "+Gandalf.numHealthPots);
                        System.out.println("Die Anzahl an Fähigkeiten "+Gandalf.Skills+ "\n");
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
                        System.out.println("Die Anzahl an Herzen "+ANSI_RED +Legolas.Herze+ANSI_RESET);
                        System.out.println("Der Scchaden Pro Angriff "+Legolas.schaden);
                        System.out.println("Die Anzahl an Pfeilen "+Legolas.Pfeile);
                        System.out.println("Die Anzahl an Heiltränke "+Legolas.numHealthPots);
                        System.out.println("Die Anzahl an Fähigkeiten "+Legolas.Skills+ "\n");

                        System.out.println("Wollen Sie diesen Charakter auswählen? Falls ja schreiben Sie y falls nicht können Sie dei anderen Charaktere ansehen.");
                    }
                    String bestaetigenfuerchamp = Eingabe.nextLine();
                    if (bestaetigenfuerchamp.equals("y") ) {
                        AusgewaehlteCharakter=Legolas;
                        AnfangStory();
                    }
                }
                case "EXIT","exit" -> {
                    System.out.println("YOU DIED!");
                    Spielstarten = false;
                }
                case "help" -> System.out.println("Mit 'EXIT' wird das Spiel beendet ");
                default -> System.out.println(ANSI_RED+"'"+ Antwort+"'" +"  ist keine Eingabe die angenommen werden kann bitte wiederholen oder Spiel verlassen!"+ANSI_RESET);
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

        System.out.println(ANSI_PURPLE+"Die Leere bahnte sich mit der Entstehung des Universums ihren Weg in die Existenz und ist die Manifestation des unergründlichen Nichts,");
        System.out.println("das dahinter liegt. Sie ist eine Kraft voller unstillbarem Verlangen, die Äonen lang wartet,bis ihre Meister, die mysteriösen Wächter,");
        System.out.println("endlich den Untergang der Welt herbeiführen.Wenn ein Sterblicher von dieser Macht berührt wird,erhält er einen quälenden Einblick");
        System.out.println("in die unendlichen Unwirklichkeiten, die selbst die stärksten Geister erschüttern.Die Bewohner der Leere selbst sind Konstrukt-Kreaturen, ");
        System.out.println("oft von beschränkter Intelligenz, die einem einzigen Zweck dienen – die totale Vernichtung über Runeterra zu bringen."+ "\n");
        System.out.println("Du wachst auf mit keiner Erinnerung über dein Leben. Rechts von dir steht ein Portal.");
        System.out.println("Zur selben Zeit hörst du eine Person um Hilfe schreien der Schrei kommt von deiner Linken Seite!('r' um das Portal zu betretten und 'l' um den Schrei nachzugehen )"+ANSI_RESET);


        String ErsteEntscheidung = Eingabe.nextLine();
        //Falscheingabe
        while (!ErsteEntscheidung.equals("r") && !ErsteEntscheidung.equals("l")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            ErsteEntscheidung = Eingabe.nextLine();
        }
        if (ErsteEntscheidung.equals("r")){
            Targonbetreten();
        }
        else if (ErsteEntscheidung.equals("l")){
            inVoidbleiben();
        }
    }
    //Passiert wenn man im Void bleiben
    public void inVoidbleiben(){

        System.out.println(ANSI_PURPLE+"Der Schrei kam von einem Kleinen Mädchen das sich verlaufen hat!");
        System.out.println("Sie wird von einem Lila farbigen Wesen angegriffen!");
        System.out.println("Das Wesen hat "+Goblin.Leben+" Herze"+" und einen Schaden von "+Goblin.Schaden);
        System.out.println("'r' um das Wesen zu bekämpfen");
        System.out.println("'l' um abzuhauen(Wie ein feigling)");

        String ErsteVoidEntscheidung = Eingabe.nextLine();
        //Falscheingabe
        while (!ErsteVoidEntscheidung.equals("r") && !ErsteVoidEntscheidung.equals("l")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            ErsteVoidEntscheidung = Eingabe.nextLine();
        }
        if (ErsteVoidEntscheidung.equals("r")){
            ErsterKampfUmDasMaedchen();


        }
        else if (ErsteVoidEntscheidung.equals("l")){
            System.out.println("Du Wurdest von einem Monster gefressen und hast es verdient!");
            AusgewaehlteCharakter.Herze=0;
        }
    }
    public void VoidersterPart(){

        System.out.println(ANSI_PURPLE+"Das Mädchen konnte gerettet werden");
        System.out.println(ANSI_BLUE+"Das Kleine Mädchen:");
        System.out.println("Danke, dass du mich gerettet hast."+ANSI_RESET);

        System.out.println(ANSI_CYAN+"Der Spieler/Du:");
        System.out.println("a) Wer bist du?");
        System.out.println("b) Wie bist du hierher gekommen?");
        System.out.println("c) Wo sind deine Eltern?");
        System.out.println("d) Geht es dir gut? bist du irgendwo verletzt?"+ANSI_RESET);


        String MaedchenFragenABCD = Eingabe.nextLine();
        while (!MaedchenFragenABCD.equals("a") && !MaedchenFragenABCD.equals("b")&& !MaedchenFragenABCD.equals("c")&& !MaedchenFragenABCD.equals("d")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            MaedchenFragenABCD = Eingabe.nextLine();
        }
        switch (MaedchenFragenABCD) {
                    case "a" -> {
                System.out.println(ANSI_BLUE+"Ich bin Kai'sa mein Dorf und meine Eltern wurden von einem Lilalicht verschlungen. ");
                System.out.println("ALs ich die Augen wieder aufgemacht hab, war ich hier und habe nach meinen Eltern gesucht");
                System.out.println("Dann hat mich dieses Monster Angegriffen und den Rest kennst du ja"+"\n");

                System.out.println(ANSI_CYAN+"a) Dein Bein ist verletzt lass es mich ansehen!");
                System.out.println("b) Du wirst allein an diesen Ort nicht überleben. Komm mit mir ich helfe dir deine Familie zu suchen ");
                System.out.println("c) Komme ich dir vertraut vor? Kennst du mich?"+ANSI_RESET);

                                            String MaedchenFragenTeilZwei = Eingabe.nextLine();
                                            while (!MaedchenFragenTeilZwei.equals("a") && !MaedchenFragenTeilZwei.equals("b")&& !MaedchenFragenTeilZwei.equals("c")){
                                                System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                                                MaedchenFragenTeilZwei = Eingabe.nextLine();
                                            }

                                            switch (MaedchenFragenTeilZwei){

                                                case "a" -> {

                                                    System.out.println(ANSI_PURPLE+"Du kannst deine Herzen verwenden, um andere zu heilen, indem du 'h' eintippst.");
                                                    System.out.println("Als Magier kannst du, ebenfalls das Mana verwendet werden, indem du 'ma' eintippst !"+ANSI_RESET);

                                                    String MaedchenHeilen = Eingabe.nextLine();
                                                    while (!MaedchenHeilen.equals("h") && !MaedchenHeilen.equals("ma")){
                                                        System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                                                        MaedchenHeilen = Eingabe.nextLine();
                                                    }

                                                    if (MaedchenHeilen.equals("h")){
                                                        AusgewaehlteCharakter.Herze--;
                                                        System.out.println(ANSI_RED+"Deine übriggebliebenen Herze: "+AusgewaehlteCharakter.Herze+ANSI_RESET);
                                                        VoidStoryMitMaedchen();
                                                    }


                                                    if (MaedchenHeilen.equals("ma")&&AusgewaehlteCharakter==Gandalf){
                                                        Gandalf.Mana--;
                                                        System.out.println(ANSI_BLUE+"Deine übriggebliebenes Mana: "+Gandalf.Mana+ANSI_RESET);
                                                        VoidStoryMitMaedchen();
                                                    }
                                                }

                                                case "b" ->{
                                                    System.out.println(ANSI_BLUE+"Danke sehr Sir. Ich kenne aber noch nichtmal ihren Namen?"+ANSI_RESET);
                                                    System.out.println(ANSI_CYAN+"Es tut mir leid, ich habe keine Ahnung wie ich heiße oder wer ich bin");
                                                    System.out.println("Wir sollten aber jetzt erstmal versuchen von hier zu verschwinden bevor andere Wesen kommen!"+ANSI_RESET);
                                                    VoidStoryMitMaedchen();
                                                }

                                                case "c" -> {
                                                    System.out.println(ANSI_BLUE+"Es tut mir leid. Ich kenne dich nicht und ich weiß nicht einmal wo wir sind"+ANSI_RESET);
                                                    System.out.println(ANSI_CYAN+"Ich weiß selber weder wo wir sind noch wer ich bin. Aber was ich weiß ist, dass wir so schnell wie möglich");
                                                    System.out.println("hier verschwinden sollten!"+ANSI_RESET);
                                                    VoidStoryMitMaedchen();

                                                }
                                            }
            }
                    case "b" -> {
                System.out.println(ANSI_BLUE+"Ich war mit meinen Eltern unterwegs und da war ein Lila Farbigeslicht, dass immer näher kam.");
                System.out.println("und naja dann war ich hier. Hast du meine Eltern gesehen oder andere Menschen? Und wer bist du Eigentlich?"+ANSI_RESET);

                System.out.println(ANSI_CYAN+"a) Dein Bein ist verletzt lass es mich ansehen!");
                System.out.println("b) Du wirst allein an diesen Ort nicht überleben. Komm mit mir ich helfe dir deine Familie zu suchen ");
                System.out.println("c) Komme ich dir vertraut vor? Kennst du mich?");
                System.out.println("d) Ich habe niemanden gesehen ich weiß nicht einmal wer ich bin!");

                                            String MaedchenFragenTeilZwei = Eingabe.nextLine();
                while (!MaedchenFragenTeilZwei.equals("a") && !MaedchenFragenTeilZwei.equals("b")&& !MaedchenFragenTeilZwei.equals("c")&& !MaedchenFragenTeilZwei.equals("d")){
                    System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                    MaedchenFragenTeilZwei = Eingabe.nextLine();
                }

                                            switch (MaedchenFragenTeilZwei){

                                                case "a" -> {

                                                    System.out.println(ANSI_PURPLE+"Du kannst deine Herzen verwenden, um andere zu heilen, indem du 'h' eintippst.");
                                                    System.out.println("Als Magier kannst du, ebenfalls das Mana verwendet werden, indem du 'ma' eintippst !"+ANSI_RESET);

                                                    String MaedchenHeilen = Eingabe.nextLine();
                                                    while (!MaedchenHeilen.equals("h") && !MaedchenHeilen.equals("ma")){
                                                        System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                                                        MaedchenHeilen = Eingabe.nextLine();
                                                    }

                                                    if (MaedchenHeilen.equals("h")){
                                                        AusgewaehlteCharakter.Herze--;
                                                        System.out.println(ANSI_RED+"Deine übriggebliebenen Herze: "+AusgewaehlteCharakter.Herze+ANSI_RESET);
                                                        VoidStoryMitMaedchen();
                                                    }


                                                    if (MaedchenHeilen.equals("ma")&&AusgewaehlteCharakter==Gandalf){
                                                        Gandalf.Mana--;
                                                        System.out.println(ANSI_BLUE+"Deine übriggebliebenes Mana: "+Gandalf.Mana+ANSI_RESET);
                                                        VoidStoryMitMaedchen();
                                                    }
                                                }

                                                    case "b" ->{
                                                        System.out.println(ANSI_BLUE+"Danke sehr Sir. Ich kenne aber noch nichtmal ihren Namen?"+ANSI_RESET);
                                                        System.out.println(ANSI_CYAN+"Es tut mir leid, ich habe keine Ahnung wie ich heiße oder wer ich bin");
                                                        System.out.println("Wir sollten aber jetzt erstmal versuchen von hier zu verschwinden bevor andere Wesen kommen!"+ANSI_RESET);
                                                        VoidStoryMitMaedchen();
                                                    }

                                                    case "c" -> {
                                                        System.out.println(ANSI_BLUE+"Es tut mir leid. Ich kenne dich nicht und ich weiß nicht einmal wo wir sind"+ANSI_RESET);
                                                        System.out.println(ANSI_CYAN+"Ich weiß selber weder wo wir sind noch wer ich bin. Aber was ich weiß ist, dass wir so schnell wie möglich");
                                                        System.out.println("hier verschwinden sollten!"+ANSI_RESET);
                                                        VoidStoryMitMaedchen();

                                                    }
                                                    case "d" -> {
                                                        System.out.println(ANSI_BLUE+"Bitte nimm mich mit lass mich nicht allein!"+ANSI_RESET);
                                                        System.out.println("Um das Mädchen mitzunehmen 'j");
                                                        System.out.println("Um das Mädchen zurückzulassen 'n");

                                                        String WirstMaedchenMitNehmen = Eingabe.nextLine();
                                                        while (!WirstMaedchenMitNehmen.equals("j") && !WirstMaedchenMitNehmen.equals("n")){
                                                            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                                                            WirstMaedchenMitNehmen = Eingabe.nextLine();
                                                        }

                                                        if (WirstMaedchenMitNehmen.equals("j")){
                                                            VoidStoryMitMaedchen();
                                                        }
                                                        else if (WirstMaedchenMitNehmen.equals("n")){
                                                            System.out.println("falsche Entscheidung!!!!!!");
                                                            System.exit(0);
                                                        }
                                                    }
                                                }

                    }
                    case "c" ->{
                        System.out.println(ANSI_BLUE+"Ich weiß es nicht ich Suche sie aber seit dem ich vom Lilafabigenlicht verschlungen worde war ich hier"+ANSI_RESET);

                        System.out.println(ANSI_CYAN+"a) Dein Bein ist verletzt lass es mich ansehen!");
                        System.out.println("b) Du wirst allein an diesen Ort nicht überleben. Komm mit mir ich helfe dir deine Familie zu suchen ");
                        System.out.println("c) Komme ich dir vertraut vor? Kennst du mich?"+ANSI_RESET);

                                                String MaedchenFragenTeilZwei = Eingabe.nextLine();
                        while (!MaedchenFragenTeilZwei.equals("a") && !MaedchenFragenTeilZwei.equals("b")&& !MaedchenFragenTeilZwei.equals("c")){
                            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                            MaedchenFragenTeilZwei = Eingabe.nextLine();
                        }

                                                switch (MaedchenFragenTeilZwei){

                                                    case "a" -> {

                                                        System.out.println(ANSI_PURPLE+"Du kannst deine Herzen verwenden, um andere zu heilen, indem du 'h' eintippst.");
                                                        System.out.println("Als Magier kannst du, ebenfalls das Mana verwendet werden, indem du 'ma' eintippst !"+ANSI_RESET);

                                                        String MaedchenHeilen = Eingabe.nextLine();

                                                        if (MaedchenHeilen.equals("h")){
                                                            AusgewaehlteCharakter.Herze--;
                                                            System.out.println(ANSI_RED+"Deine übriggebliebenen Herze: "+AusgewaehlteCharakter.Herze+ANSI_RESET);
                                                            VoidStoryMitMaedchen();
                                                        }


                                                        if (MaedchenHeilen.equals("ma")&&AusgewaehlteCharakter==Gandalf){
                                                            Gandalf.Mana--;
                                                            System.out.println(ANSI_BLUE+"Deine übriggebliebenes Mana: "+Gandalf.Mana+ANSI_RESET);
                                                            VoidStoryMitMaedchen();
                                                        }
                                                    }

                                                    case "b" ->{
                                                        System.out.println(ANSI_BLUE+"Danke sehr Sir. Ich kenne aber noch nichtmal ihren Namen?"+ANSI_RESET);
                                                        System.out.println(ANSI_CYAN+"Es tut mir leid, ich habe keine Ahnung wie ich heiße oder wer ich bin");
                                                        System.out.println("Wir sollten aber jetzt erstmal versuchen von hier zu verschwinden bevor andere Wesen kommen!"+ANSI_RESET);
                                                        VoidStoryMitMaedchen();
                                                    }

                                                    case "c" -> {
                                                        System.out.println(ANSI_BLUE+"Es tut mir leid. Ich kenne dich nicht und ich weiß nicht einmal wo wir sind"+ANSI_RESET);
                                                        System.out.println(ANSI_CYAN+"Ich weiß selber weder wo wir sind noch wer ich bin. Aber was ich weiß ist, dass wir so schnell wie möglich");
                                                        System.out.println("hier verschwinden sollten!"+ANSI_RESET);
                                                        VoidStoryMitMaedchen();

                                                    }
                                                }

                    }
                    case "d" ->{
                                                        System.out.println(ANSI_BLUE+"Mein Bein tut weh ich habe mich geschnitten beim hinfallen"+ANSI_RESET);
                                                        System.out.println(ANSI_PURPLE+"Du kannst deine Herzen verwenden, um andere zu heilen, indem du 'h' eintippst.");
                                                        System.out.println("Als Magier kannst du, ebenfalls das Mana verwendet werden, indem du 'ma' eintippst !"+ANSI_RESET);

                                                        String MaedchenHeilen = Eingabe.nextLine();
                        while (!MaedchenHeilen.equals("h") && !MaedchenHeilen.equals("ma") ){
                            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
                            MaedchenHeilen = Eingabe.nextLine();
                        }

                                                        if (MaedchenHeilen.equals("h")){
                                                            AusgewaehlteCharakter.Herze--;
                                                            System.out.println(ANSI_RED+"Deine übriggebliebenen Herze: "+AusgewaehlteCharakter.Herze+ANSI_RESET);
                                                            VoidStoryMitMaedchen();
                                                        }

                                                        if (MaedchenHeilen.equals("ma")&&AusgewaehlteCharakter==Gandalf){
                                                            Gandalf.Mana--;
                                                            System.out.println(ANSI_BLUE+"Deine übriggebliebenes Mana: "+Gandalf.Mana+ANSI_RESET);
                                                            VoidStoryMitMaedchen();
                                                        }
                    }

                }
    }
    //Void Story fortsetzen
    public void VoidStoryMitMaedchen(){
        System.out.println(ANSI_PURPLE+"5 Stunden vergingen seit der Begennung von Kai'sa. Auf dem Weg wurde nur allerlei Gegenstände, unterandrem eine Waffe und Lebensmittel. ");
        System.out.println("Nach Stundenlanger Suche nach Zivilisation, stehst du wieder vor einer Entscheidung. Es ist eine Hölle mit einem Duft von Zimt der Verlockend ist.");
        System.out.println("Jedoch ist auf dem selben Weg ein Turm der auf der Spitze ein helles gelbes Licht. Ähnlich wie, dass als du aufgewacht bist."+ANSI_RESET);
        System.out.println(ANSI_CYAN+"a) Die Hölle betretten");
        System.out.println("b) Den Turm betretten"+ANSI_RESET);
        String EntscheideFuerDieHoelleOderTurm = Eingabe.nextLine();
        while (!EntscheideFuerDieHoelleOderTurm.equals("a") && !EntscheideFuerDieHoelleOderTurm.equals("b")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            EntscheideFuerDieHoelleOderTurm = Eingabe.nextLine();
        }
        switch (EntscheideFuerDieHoelleOderTurm){
            case "a" -> VoidStoryMitMaedchenInDerHoelle();
            case "b" -> VoidStoryMitMaedchenInDemTurm();

        }
    }



    //Höllen Story
    public void VoidStoryMitMaedchenInDerHoelle(){
        System.out.println(ANSI_PURPLE+"Je tiefer man in die Hölle ging desto stärker wurde der Zimt geruch. Zur selben Zeit klammerte sich Kai'sa um deinen rechten Arm.");
        System.out.println("Das Gefühl beobachtet zu werden wurde mit jedem Schritt den man fortsetze immer stärker. Jedoch war der Drang herauszufinden woher der Duft kam überlegen.");
        System.out.println("Auf dem Weg Springt, das Lila farbige, dass weglaufen ist hervor. Es ist immernoch Stark verletzt von dem Kampf und nicht mehr in der Lage sich zu verteidigen"+ANSI_RESET);
        System.out.println(ANSI_CYAN+"a) Das Wesen Töten");
        System.out.println("b) Es Verletzt lassen und vorbei gehen");
        System.out.println("h) Es heilen");
        String HoelleMitMaedchenErsteEntscheidung = Eingabe.nextLine();
        while (!HoelleMitMaedchenErsteEntscheidung.equals("a") && !HoelleMitMaedchenErsteEntscheidung.equals("b")&& !HoelleMitMaedchenErsteEntscheidung.equals("h")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            HoelleMitMaedchenErsteEntscheidung = Eingabe.nextLine();
        }
        switch (HoelleMitMaedchenErsteEntscheidung){
            case "a" -> VoidStoryMitMaedchenWesenToeten();
            case "b" -> HoelleDenTrankWegSchmeißen();
            case "h" -> HoelleWesenRetten();
        }
    }

    public void VoidStoryMitMaedchenWesenToeten(){
        System.out.println(ANSI_PURPLE+"Das Wesen war so schwach, dass es nur einen Schlag benötigt hat um zu sterben. Jedoch hatte es einen Gegenstand im Mund.");
        System.out.println("Eine Flasche mit roter Flüßigkeit, die einen süßen Duft von sich gibt. Sie wurde aber beschädigt, dadurch, dass das Wesen während des Sterbens");
        System.out.println("drauf gebissen hat.");
        System.out.println(ANSI_CYAN+"a) Den Trank trinken");
        System.out.println("b) Das Mädchen Trinken lassen");
        System.out.println("c) Den Trank wegschmeißen"+ANSI_RESET);
        String HoelleMitMaedchenWesenTotGetrank =  Eingabe.nextLine();
        while (!HoelleMitMaedchenWesenTotGetrank.equals("a") && !HoelleMitMaedchenWesenTotGetrank.equals("b")&& !HoelleMitMaedchenWesenTotGetrank.equals("c")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            HoelleMitMaedchenWesenTotGetrank = Eingabe.nextLine();
        }
        switch (HoelleMitMaedchenWesenTotGetrank){
            case "a" -> HoelleTrankTrinkenSpieler();
            case "b" -> HoelleTrabkDasMaedchenTrinkenLassen();
            case "c" -> HoelleDenTrankWegSchmeißen();

        }
    }
    public void HoelleTrankTrinkenSpieler(){
        System.out.println(ANSI_PURPLE+"Der Trank konnte zwei Herzen wieder auffüllen");
        AusgewaehlteCharakter.Herze=AusgewaehlteCharakter.Herze+2;
        System.out.println(ANSI_PURPLE+"Deine Übriggeblibene Herze "+ANSI_RESET+ANSI_RED+AusgewaehlteCharakter.Herze+ANSI_RESET);
        HoelleDenTrankWegSchmeißen();
    }
    public void HoelleTrabkDasMaedchenTrinkenLassen(){
        System.out.println(ANSI_PURPLE+"Kai'sa hat sich komplett wieder geheilt. Ihre Wunde hat sich in Sekunden geheilt"+ANSI_RESET);
        HoelleDenTrankWegSchmeißen();
    }
    public void HoelleDenTrankWegSchmeißen(){
        System.out.println(ANSI_PURPLE+"Ein Gelbes Licht Sorgte dafür, dass sich Kai'sa erschreckt hat. Es ist das selbe Portal wie als du aufgewacht bist.");
        System.out.println("Es ist immernoch nicht klar wer du bist, woher du kommst, genau so wie, die andere Seite des Portals. Kai'sa wird dahin gehen wo du gehst."+ANSI_RESET);
        System.out.println(ANSI_CYAN+"p) Das Portal betretten");
        System.out.println("z) zum Türm zurück gehen");
        String HoelleEndeProtalEntscheidung = Eingabe.nextLine();
        while (!HoelleEndeProtalEntscheidung.equals("p") && !HoelleEndeProtalEntscheidung.equals("z")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            HoelleEndeProtalEntscheidung = Eingabe.nextLine();
        }
        switch (HoelleEndeProtalEntscheidung){
            case "p" -> Targonbetreten();
            case "z" -> VoidStoryMitMaedchenInDemTurm();
        }

    }
    public void HoelleWesenRetten(){
        AusgewaehlteCharakter.Herze--;
        System.out.println(ANSI_PURPLE+"Deine übriggebliebenen Herze "+ANSI_RESET+ANSI_RED+AusgewaehlteCharakter.Herze+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Das Wesen ist überraschend nett nachdem es gerettet worden ist. Es Fängt an sich zu bendanken, indem es deine und Kai'sa wunden Heilt."+ANSI_RESET);
        AusgewaehlteCharakter.Herze=AusgewaehlteCharakter.Herze+4;
        System.out.println(ANSI_PURPLE+"Deine übriggebliebenen Herze "+ANSI_RESET+ANSI_RED+AusgewaehlteCharakter.Herze+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Das Wesen hat sich dazu entschieden dein Begleiter für deine Reise zu werden du kannst es bennenn: "+ANSI_RESET);
        String VoidWesenName = Eingabe.nextLine();

        System.out.println(ANSI_PURPLE+"Dein Begleiter heißt "+VoidWesenName+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"                               \\");
                    System.out.println("                 .___             `.");
                    System.out.println("    ___              `~\\           |               \\\\");
                    System.out.println("  o~   `.               |         /'                |\\");
                    System.out.println(".----._ `|             ,'       /'              _./'\\");
                    System.out.println("`o     `\\|___       __,|----'~~~~T-----,__  _,'~\\");
                    System.out.println("      /~~o   `~>-/|~ '   ' ,   '      '   ~~\\_\\");
                    System.out.println("     |_      <~   |   ' ,   ' '   '  ' , '     \\\\");
                    System.out.println("       `-...-'~\\./' '     '     '   '   '  , '  >\\");
                    System.out.println("                 `-, __'  ,  '  '  , ' ,   '_,'-'\\");
                    System.out.println("                   /'   `~~~~~~~|`--------~~\\\\");
                    System.out.println("                 /'            ,'            `.\\");
                    System.out.println("          ~~`---'             /               |\\");
                    System.out.println("                           ,-'              _/'\\");
                    HoelleDenTrankWegSchmeißen();
    }

    //Im Turm andere Spiel Area
    public void VoidStoryMitMaedchenInDemTurm(){
        System.out.println(ANSI_PURPLE+"Als der Turm betretten worden ist gab es, eine Treppe mit 4 Etagen und den direkten Weg zur Spitze wo das Licht herkam."+ANSI_RESET);
        VoidTurmEtageEntscheidung();
    }
    public void VoidTurmEtageEntscheidung(){
        System.out.println(ANSI_CYAN+"e) Um die erste Etage zu durchsuchen");
        System.out.println("1) Um auf die erste Etage zu gehen");
        System.out.println("2) Um auf die zweite Etage zu gehen");
        System.out.println("s) Um auf die Spitze zu gehen"+ANSI_RESET);
        String TurmHochGehenDieTreppen = Eingabe.nextLine();
        while (!TurmHochGehenDieTreppen.equals("e") && !TurmHochGehenDieTreppen.equals("1")&& !TurmHochGehenDieTreppen.equals("2")&& !TurmHochGehenDieTreppen.equals("s")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            TurmHochGehenDieTreppen = Eingabe.nextLine();
        }
        switch (TurmHochGehenDieTreppen){
            case "e" -> VoidStoryTurmErdgeschoss();
            case "1", "2" -> ZweiterKampf();
            case "s" -> VoidStoryTurmSpitze();
        }
    }
    public void VoidStoryTurmErdgeschoss(){
        System.out.println(ANSI_PURPLE+"Im Erdgeschoß waren Wertlose Gegenstände, unteranderm ein Kaputtes Bett mit einer verschimmelten Maratze, ein Kaputtes Bücherregal");
        System.out.println("Bücher die halb offen auf den Boden lagen, Vergammeltes essen das halb aufgegessen auf den Tisch stand, so als ob jeamand ganz schnell abgehaueb ist.");
        System.out.println("Eines der Bücher hatte einen gelben Kristal in der Mitte. Mit der Überschrift 'T'."+ANSI_RESET);
        System.out.println(ANSI_CYAN+"a) Das Buch öffnen");
        System.out.println("b) Das Buch Wegschmeißen"+ANSI_RESET);
        String DasBuchLesenOderNicht = Eingabe.nextLine();
        switch (DasBuchLesenOderNicht){
             case "a" -> TaragonGeschichteDasBuch();

        }
    }
    public void VoidStoryTurmErsteEtage(){
        System.out.println(ANSI_PURPLE+"Der Gegner hatte keinerlei Informationen über die Welt"+ANSI_RESET);
        VoidTurmEtageEntscheidung();


    }
    public void VoidStoryTurmSpitze(){
        TurmSpitzeWahl();
    }

    //Taragon Buch
    public void TaragonGeschichteDasBuch(){
        System.out.println(ANSI_YELLOW+"Der Targon ist der mächtigste Gipfel in Runeterra, ein imposanter Koloss aus sonnenbeschienenem Fels.");
        System.out.println("Er steht inmitten einer Gebirgskette, die in ihrer Größe einzigartig auf dieser Welt ist. Weitab von jeder Zivilisation");
        System.out.println("elegen ist der Targon fast unmöglich zu erreichen. Nur durch äußerste Entschlossenheit gelangen Reisende hierher.");
        System.out.println("Um den Targon ranken sich viele Legenden und wie jeder sagenumwobene Ort zieht er Träumer, Wahnsinnige und verwegene Abenteurer an.");
        System.out.println("Einige mutige Seelen versuchen, den unmöglichen Berg zu erklimmen – vielleicht auf der Suche nach Weisheit oder Erleuchtung,");
        System.out.println("vielleicht im Streben nach Ruhm oder aus dem tiefsten Seelenwunsch heraus,seinen Gipfel zu sehen. Der Aufstieg ist fast ein Ding der Unmöglichkeit");
        System.out.println("nd selbst die wenigen Glücklichen, die irgendwie lebend am Gipfel ankommen, sprechen niemals über das, was sie zu Gesicht bekommen haben. Einige kehren");
        System.out.println("mit leerem und gehetztem Blick zurück, andere haben sich bis zur Unkenntlichkeit verändert und wurden von einem mächtigen,");
        System.out.println("überirdischen Aspekt für ein Schicksal erwählt, das die wenigsten Sterblichen begreifen können.");
        VoidTurmEtageEntscheidung();
    }


    public void TurmSpitzeWahl(){
        System.out.println(ANSI_PURPLE+"Auf der Spitze des Turmes war ein Gelb leuchtendes Portal, dass sich genau wie das Portal aussah wie am Anfang wo du aufgewacht bist."+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Was machst du?"+ANSI_RESET);
        System.out.println(ANSI_CYAN+"a) Portal betreten");
        System.out.println("b) Zurück zur Hölle");
        String PortalOderHoelle = Eingabe.nextLine();
        while (!PortalOderHoelle.equals("a") && !PortalOderHoelle.equals("b")){
            System.out.println(ANSI_RED+"Kein Eingabe die Angenommen werden kann!"+ANSI_RESET);
            PortalOderHoelle = Eingabe.nextLine();
        }
        switch (PortalOderHoelle){
            case "a" -> VoidStoryMitMaedchenInDerHoelle();
            case "b" -> Targonbetreten();
        }
    }
    //Passiert wenn man das Portal betritt
    public void Targonbetreten(){
        System.out.println(ANSI_YELLOW+"Nachdem du, dass Portal betretten hast ist warst du in Ruinen.");
        System.out.println("Atreus wurde an den unwirtlichen Hängen des Targon geboren und nach einem Stern in der Konstellation des Krieges benannt, die man auch Pantheon nannte.\n" +
                "\n" +
                "Von jungen Jahren an wusste er, dass er für die Schlacht bestimmt war. Wie viele andere aus seinem Stamm arbeitete er darauf hin, sich den Ra’Horak anzuschließen, dem Kämpferorden der Rakkor. Obwohl er nie der stärkste oder talentierteste Krieger war, zeigte Atreus Durchhaltevermögen und stand blutverschmiert und mit Wunden übersät nach jeder Runde wieder auf. Im Laufe der Zeit entwickelte sich eine heftige Rivalität zwischen ihm und einem anderen Rekruten mit Namen Pylas – doch ganz gleich, wie oft Atreus auf den felsigen Boden geschickt wurde, er stand immer wieder auf. Pylas beeindruckte diese unnachgiebige Ausdauer und das Blut, das sie im Trainingskreis vergossen, machte sie zu wahren Brüdern.\n" +
                "\n" +
                "Atreus und Pylas waren unter den Rakkor, die auf die Invasion der Barbaren stießen und den Hinterhalt überlebten, dem der Rest ihrer Patrouille zum Opfer fiel. Als der Aspekt der Sonne sich weigerte, die Eindringlinge zu zerstören, schworen Atreus und Pylas, den Gipfel des Targon zu erklimmen und die Macht der Aspekte selbst in sich aufzunehmen.\n" +
                "\n" +
                "Wie so viele vor ihnen unterschätzten sie, wie beschwerlich der Aufstieg sein würde, und Pylas tat seinen letzten zitternden Atemzug, als sie den Gipfel schließlich erreichten. Nur Atreus war noch übrig, als sich der Himmel öffnete und ein göttlicher Aspekt in ihn fuhr, der ihm die Kraft verlieh, Rache zu üben.\n" +
                "\n" +
                "Doch es war kein Mann, der anschließend zu den Rakkor zurückkehrte und dessen Speer und Schild vor himmlischer Macht schimmerte. Es war Pantheon, der Aspekt des Krieges, selbst. Er hatte Atreus, einen Krieger, der sein Leben lang nur Niederlagen erfahren hatte, für unwürdig befunden und die Kontrolle über seinen Körper übernommen, um seine eigenen Ziele zu verfolgen – eine Aufgabe, die seiner Meinung nach über die Fähigkeiten von Sterblichen hinausging.\n" +
                "\n" +
                "Atreus war in die hintersten Ecken seines eigenen Geistes verbannt worden und nahm nur vage Visionen wahr, während der Aspekt die Welt nach den Düsteren durchkämmte, lebende Waffen, die in einem vergangenen Zeitalter geschaffen worden waren.\n" +
                "\n" +
                "Schließlich wurde Pantheon nicht weit vom Targon von einem Düsteren namens Aatrox, der den Gipfel des Berges erreichen wollte, zum Kampf herausgefordert. Ihr Duell tobte über den Himmel und fegte durch die Armeen der Sterblichen unter ihnen …, bis das Unmögliche geschah. Die Götterschlächter-Klinge des Düsteren durchbohrte Pantheons Brust und der Schlag schnitt die Konstellation des Krieges vom Himmel.\n" +
                "\n" +
                "Doch als der Aspekt schwand, erwachte Atreus – der Mann, den er als zu schwach befunden hatte – erneut. Aatrox’ Klinge hatte ihn aufgespießt und die Waffen des Aspektes verloren an Kraft, doch er holte mühevoll Luft und spuckte dem Düsteren ins Gesicht. Aatrox zog eine Grimasse und überließ Atreus dem Tode.\n" +
                "\n" +
                "Stunden später, als sich die Krähen sammelten, stand Atreus unter Schmerzen auf und hinterließ auf seinem stolpernden Weg zurück zu den Rakkor eine tiefrote Blutspur. Nach einem Leben voller Niederlagen waren sein Überlebenswille und sein Zorn über den Verrat stark genug, um dem Tod zu entkommen, der den Krieg selbst ereilt hatte.\n" +
                "\n" +
                "Atreus kam auf Pylas’ Gehöft wieder zu Kräften, wo ihn Iula, die Witwe seines besten Freundes, gesund pflegte. Dort begriff Atreus, dass er sein Leben lang zu den Sternen aufgeblickt hatte, ohne je darüber nachzudenken, was sich dahinter befand. Anders als die Götter kämpften die Sterblichen, weil sie mussten, da der Tod sie erwartete. Diese Widerstandskraft fand er in allen Lebewesen wieder, die sich endlosen Bedrohungen gegenübersahen.\n" +
                "\n" +
                "Tatsächlich bedrohten die einfallenden Barbaren nun die nördlichen Siedlungen der Rakkor, darunter auch Iulas Hof. Obwohl er noch Monate lang keinen Speer halten konnte, war Atreus fest entschlossen, diese Geißel selbst auszumerzen, und machte sich mit den stumpfen Waffen des Aspektes auf den Weg.\n" +
                "\n" +
                "Doch als er ankam, wurden seine Todfeinde bereits belagert. Er erkannte an den Schreien und dem überwältigenden Blutgeruch … dass sie Aatrox gegenüberstanden.\n" +
                "\n" +
                "Atreus wurde klar, dass Aatrox die Barbaren zum Targon getrieben hatte. Obwohl er sie als Feinde betrachtete, waren sie wie die Rakkor – Sterbliche, die unter den Konflikten zwischen höheren Mächten litten. Atreus verspürte kalten Zorn auf die Düsteren und die Aspekte. Sie waren alle gleich. Sie waren das Problem.\n" +
                "\n" +
                "Atreus ging zwischen die Barbaren und Aatrox. Der Düstere erkannte den in Mitleidenschaft gezogenen Schild und den Speer des gefallenen Aspektes und verhöhnte ihn – wie konnte Atreus jetzt, ohne Pantheons Kräfte, hoffen, Aatrox zu besiegen? Obgleich Aatrox’ Hiebe ihn in die Knie zwangen, entzündete Atreus’ eigener Wille den Speer des Aspektes, als er die Schreie der Menschen um ihn herum vernahm … und mit einem mächtigen Sprung schlug er dem Düsteren den Schwertarm ab.\n" +
                "\n" +
                "Klinge und Düsterer gingen beide zu Boden. Nur Atreus war noch auf den Beinen und sah, wie der Stern, dem er den Namen verdankte, oben am Himmel wieder zum Leben erwachte.\n" +
                "\n" +
                "Obwohl er sich oft nach Iulas Hof zurücksehnt, schwor Atreus an diesem Tag, sich gegen Aspekte, Aufgestiegene, Dämonen und jegliche andere Wesen zu stellen, deren Macht so groß ist, dass sie nur zur Zerstörung dient. Er hat seinen eigenen Namen aufgegeben, um ein neuer Pantheon zu werden – in den Waffen des Aspektes fließt nun ein Wille, der nur im Angesicht des Todes existieren kann.\n" +
                "\n" +
                "Da der göttliche Pantheon fort ist, muss der Krieg in einem Menschen wiedergeboren werden."+ANSI_RESET);


    }


    public void ErsterKampfUmDasMaedchen(){
        //Array aufrufen und ausgeben das ein Gegner gekommen ist
        System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
        int enemyhealth = rand.nextInt(Goblin.Leben);
        String enemy = Goblin.enemies[rand.nextInt(Goblin.enemies.length)];
        System.out.println(ANSI_RED+"\t# "+ enemy+"  Ist der Gegner! #\n"+ANSI_RESET);
        //Eine weitere Scleife um die Gegner zu bkämpfen bis Sie tot sind
        while (enemyhealth > 0){
            System.out.println(ANSI_PURPLE+"\tDeine Herzen: "+ AusgewaehlteCharakter.Herze);
            System.out.println("\t"+ enemy+" HP: "+enemyhealth);
            System.out.println("\n\tWas tust du?"+ANSI_RESET);
            System.out.println(ANSI_CYAN+"\t1. Angreifen");
            System.out.println("\t2. Heil trank trinken"+ANSI_RESET);
            String KampfEntscheidung = Eingabe.nextLine();
            if (KampfEntscheidung.equals("1")){
                int SchadenzuFuegen = AusgewaehlteCharakter.schaden;
                int SchadenGenommen = rand.nextInt(Goblin.Schaden);

                enemyhealth -= SchadenzuFuegen;
                AusgewaehlteCharakter.Herze -=SchadenGenommen;

                System.out.println(ANSI_RED+"\t> Du verursachst den "+enemy+" einen Schaden von "+SchadenzuFuegen);
                System.out.println("\t> Den Schaden den du erleidest "+ SchadenGenommen+" vom Gegner!"+ANSI_RESET);

            if (AusgewaehlteCharakter.Herze<1){
                System.out.println(ANSI_RED+"Du hast keine Herzen mehr du bist tot"+ANSI_RESET);
                System.exit(0);
            }
            }
            else if (KampfEntscheidung.equals("2")){
                if (AusgewaehlteCharakter.numHealthPots>0){
                    AusgewaehlteCharakter.Herze += AusgewaehlteCharakter.healtjPotionHealZahl;
                    AusgewaehlteCharakter.numHealthPots--;
                    System.out.println(ANSI_RED+"\t> Du trinkst einen Heil trank der dich um  "+ AusgewaehlteCharakter.healtjPotionHealZahl+"Herze heilt. "+
                                "\n\t> Du besitz jetzt "+ AusgewaehlteCharakter.Herze+" HP."+
                                "\n\t> Du hast "+ AusgewaehlteCharakter.numHealthPots+" Heiltränke."+ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_RED+"\t> Du besitz keine Heiltränke mehr!"+ANSI_RESET);
                }
            }
            else {
                System.out.println(ANSI_RED+"\tKeine Gültige Eingabe"+ANSI_RESET);
            }
        }
        System.out.println(ANSI_PURPLE+"----------------------------------------------------");
        System.out.println(ANSI_GREEN+" # "+enemy+" wurde besiegt! #");
        System.out.println(" # Du hast "+ AusgewaehlteCharakter.Herze+ "HP übrig. #"+ANSI_RESET);
        if (rand.nextInt(100) < AusgewaehlteCharakter.healthPotionDropChance){
            AusgewaehlteCharakter.numHealthPots++;
            System.out.println(ANSI_GREEN+"# Dein Gegner "+ enemy+ " hat ein Heiltrank fallengelassen! #");
            System.out.println(" # Du hast "+AusgewaehlteCharakter.numHealthPots+" Heiltränke. #"+ANSI_RESET);
        }
        //Das Spiel mit Story fortfahren
        System.out.println(ANSI_PURPLE+"----------------------------------------------------");
        VoidersterPart();



    }

    public void ZweiterKampf(){
        //Array aufrufen und ausgeben das ein Gegner gekommen ist
        System.out.println(ANSI_PURPLE+"----------------------------------------------------"+ANSI_RESET);
        int enemyhealth = rand.nextInt(Goblin.Leben);
        String enemy = Goblin.enemies[rand.nextInt(Goblin.enemies.length)];
        System.out.println(ANSI_RED+"\t# "+ enemy+"  Ist der Gegner! #\n"+ANSI_RESET);
        //Eine weitere Scleife um die Gegner zu bkämpfen bis Sie tot sind
        while (enemyhealth > 0){
            System.out.println(ANSI_PURPLE+"\tDeine Herzen: "+ AusgewaehlteCharakter.Herze);
            System.out.println("\t"+ enemy+" HP: "+enemyhealth);
            System.out.println("\n\tWas tust du?"+ANSI_RESET);
            System.out.println(ANSI_CYAN+"\t1. Angreifen");
            System.out.println("\t2. Heil trank trinken"+ANSI_RESET);
            String KampfEntscheidung = Eingabe.nextLine();
            if (KampfEntscheidung.equals("1")){
                int SchadenzuFuegen = AusgewaehlteCharakter.schaden;
                int SchadenGenommen = rand.nextInt(Goblin.Schaden);

                enemyhealth -= SchadenzuFuegen;
                AusgewaehlteCharakter.Herze -=SchadenGenommen;

                System.out.println(ANSI_RED+"\t> Du verursachst den "+enemy+" einen Schaden von "+SchadenzuFuegen);
                System.out.println("\t> Den Schaden den du erleidest "+ SchadenGenommen+" vom Gegner!"+ANSI_RESET);

                if (AusgewaehlteCharakter.Herze<1){
                    System.out.println(ANSI_RED+"Du hast keine Herzen mehr du bist tot"+ANSI_RESET);
                    System.exit(0);
                }
            }
            else if (KampfEntscheidung.equals("2")){
                if (AusgewaehlteCharakter.numHealthPots>0){
                    AusgewaehlteCharakter.Herze += AusgewaehlteCharakter.healtjPotionHealZahl;
                    AusgewaehlteCharakter.numHealthPots--;
                    System.out.println(ANSI_RED+"\t> Du trinkst einen Heil trank der dich um  "+ AusgewaehlteCharakter.healtjPotionHealZahl+"Herze heilt. "+
                            "\n\t> Du besitz jetzt "+ AusgewaehlteCharakter.Herze+" HP."+
                            "\n\t> Du hast "+ AusgewaehlteCharakter.numHealthPots+" Heiltränke."+ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_RED+"\t> Du besitz keine Heiltränke mehr!"+ANSI_RESET);
                }
            }
            else {
                System.out.println(ANSI_RED+"\tKeine Gültige Eingabe"+ANSI_RESET);
            }
        }
        System.out.println(ANSI_PURPLE+"----------------------------------------------------");
        System.out.println(ANSI_GREEN+" # "+enemy+" wurde besiegt! #");
        System.out.println(" # Du hast "+ AusgewaehlteCharakter.Herze+ "HP übrig. #"+ANSI_RESET);
        if (rand.nextInt(100) < AusgewaehlteCharakter.healthPotionDropChance){
            AusgewaehlteCharakter.numHealthPots++;
            System.out.println(ANSI_GREEN+"# Dein Gegner "+ enemy+ " hat ein Heiltrank fallengelassen! #");
            System.out.println(" # Du hast "+AusgewaehlteCharakter.numHealthPots+" Heiltränke. #"+ANSI_RESET);
        }
        //Das Spiel mit Story fortfahren
        System.out.println(ANSI_PURPLE+"----------------------------------------------------");
            VoidStoryTurmErsteEtage();



    }

}
