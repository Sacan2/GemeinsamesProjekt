package com.company;

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


    // Unsere Charaktere in Objekten umwandeln
    Scwertkaempfer Aragon = new Scwertkaempfer(5,1,15,true);
    Magier Gandalf = new Magier( 2,3,25,10);
    Bogenschuetze Legolas = new Bogenschuetze( 3,2,10,10);

    Spielcharakter AusgewaehlteCharakter = null;


    //Gegner erstellen für unseren Charakter
    Gegner Goblin = new Gegner(2,1);

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
            if (Aragon.Herze==0||Gandalf.Herze==0||Legolas.Herze==0){

                System.out.println("Game OVER!");
                System.out.println("Du hat keine Herzen mehr!");
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

        System.out.println(ANSI_PURPLE+"Die Leere bahnte sich mit der Entstehung des Universums ihren Weg in die Existenz und ist die Manifestation des unergründlichen Nichts,");
        System.out.println("das dahinter liegt. Sie ist eine Kraft voller unstillbarem Verlangen, die Äonen lang wartet,bis ihre Meister, die mysteriösen Wächter,");
        System.out.println("endlich den Untergang der Welt herbeiführen.Wenn ein Sterblicher von dieser Macht berührt wird,erhält er einen quälenden Einblick");
        System.out.println("in die unendlichen Unwirklichkeiten, die selbst die stärksten Geister erschüttern.Die Bewohner der Leere selbst sind Konstrukt-Kreaturen, ");
        System.out.println("oft von beschränkter Intelligenz, die einem einzigen Zweck dienen – die totale Vernichtung über Runeterra zu bringen."+ "\n");
        System.out.println("Du wachst auf mit keiner Erinnerung über dein Leben. Rechts von dir steht ein Portal.");
        System.out.println("Zur selben Zeit hörst du eine Person um Hilfe schreien der Schrei kommt von deiner Linken Seite!('r' um das Portal zu betretten und 'l' um den Schrei nachzugehen )");


        String ErsteEntscheidung = Eingabe.nextLine();
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

        if (ErsteVoidEntscheidung.equals("r")){
            if (AusgewaehlteCharakter.schaden>Goblin.Leben) {
                Goblin.Leben = 0;
            }
            VoidersterPart();
        }
        else if (ErsteVoidEntscheidung.equals("l")){
            System.out.println("Du Wurdest von einem Monster gefressen und hast es verdient!");
            AusgewaehlteCharakter.Herze=0;
        }
    }
    public void VoidersterPart(){

        System.out.println("Das Mädchen konnte gerettet werden, jedoch hat dich, dass Wesen verletzt und ist weggelaufen!!");
        AusgewaehlteCharakter.Herze--;
        System.out.println("Deine übriggebliebenen Herze: "+ANSI_RED+AusgewaehlteCharakter.Herze+ANSI_RESET);
        System.out.println(ANSI_BLUE+"Das Kleine Mädchen:");
        System.out.println("Danke, dass du mich gerettet hast."+ANSI_RESET);

        System.out.println(ANSI_CYAN+"Der Spieler/Du:");
        System.out.println("a) Wer bist du?");
        System.out.println("b) Wie bist du hierher gekommen?");
        System.out.println("c) Wo sind deine Eltern?");
        System.out.println("d) Geht es dir gut? bist du irgendwo verletzt?"+ANSI_RESET);


        String MaedchenFragenABCD = Eingabe.nextLine();
        switch (MaedchenFragenABCD) {
            case "a" -> {
                System.out.println(ANSI_BLUE+"Ich bin Kai'sa mein Dorf und meine Eltern wurden von einem Lilalicht verschlungen. ");
                System.out.println("ALs ich die Augen wieder aufgemacht hab, war ich hier und habe nach meinen Eltern gesucht");
                System.out.println("Dann hat mich dieses Monster Angegriffen und den Rest kennst du ja"+"\n");

                System.out.println(ANSI_CYAN+"a) Dein Bein ist verletzt lass es mich ansehen!");
                System.out.println("b) Du wirst allein an diesen Ort nicht überleben. Komm mit mir ich helfe dir deine Familie zu suchen ");
                System.out.println("c) Komme ich dir vertraut vor? Kennst du mich?"+ANSI_RESET);

                                            String MaedchenFragenTeilZwei = Eingabe.nextLine();
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
            case "b" -> {
                System.out.println(ANSI_BLUE+"Ich war mit meinen Eltern unterwegs und da war ein Lila Farbigeslicht, dass immer näher kam.");
                System.out.println("und naja dann war ich hier. Hast du meine Eltern gesehen oder andere Menschen? Und wer bist du Eigentlich?"+ANSI_RESET);

                System.out.println(ANSI_CYAN+"a) Dein Bein ist verletzt lass es mich ansehen!");
                System.out.println("b) Du wirst allein an diesen Ort nicht überleben. Komm mit mir ich helfe dir deine Familie zu suchen ");
                System.out.println("c) Komme ich dir vertraut vor? Kennst du mich?");
                System.out.println("d) Ich habe niemanden gesehen ich weiß nicht einmal wer ich bin!");

                                            String MaedchenFragenTeilZwei = Eingabe.nextLine();
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
                                                    case "d" -> {
                                                        System.out.println(ANSI_BLUE+"Bitte nimm mich mit lass mich nicht allein!"+ANSI_RESET);
                                                        System.out.println("Um das Mädchen mitzunehmen 'j");
                                                        System.out.println("Um das Mädchen zurückzulassen 'n");

                                                        String WirstMaedchenMitNehmen = Eingabe.nextLine();

                                                        if (WirstMaedchenMitNehmen.equals("j")){
                                                            VoidStoryMitMaedchen();
                                                        }
                                                        else if (WirstMaedchenMitNehmen.equals("n")){
                                                            VoidStoryOhneMaedchen();
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
                    default ->  System.out.println( ANSI_RED+MaedchenFragenABCD+" Das ist keine Angabe die angenommen werden kann"+ANSI_RESET);
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
        switch (EntscheideFuerDieHoelleOderTurm){
            case "a" -> VoidStoryMitMaedchenInDerHoelle();
            case "b" -> VoidStoryMitMaedchenInDemTurm();

        }
    }

    public void VoidStoryOhneMaedchen(){
        System.out.println(ANSI_PURPLE+"Story ohne das Mädchen!"+ANSI_RESET);

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
        switch (HoelleEndeProtalEntscheidung){
            case "p" -> Targonbetreten();
            case "z" -> VoidStoryMitMaedchenInDemTurm();
        }

    }
    public void HoelleWesenRetten(){
        AusgewaehlteCharakter.Herze--;
        System.out.println(ANSI_PURPLE+"Deine übriggebliebenen Herze "+ANSI_RESET+ANSI_RED+AusgewaehlteCharakter.Herze+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Das Wesen ist überraschend nett nachdem es gerettet worden ist. Fängt an sich zu bendanken, indem es deine und Kai'sa wunden Heilt"+ANSI_RESET);
        AusgewaehlteCharakter.Herze=AusgewaehlteCharakter.Herze+4;
        System.out.println(ANSI_PURPLE+"Deine übriggebliebenen Herze "+ANSI_RESET+ANSI_RED+AusgewaehlteCharakter.Herze+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"Das Wesen hat sich dazu entschieden kdein Begleiter für deine Reise zu werden du kannst es bennenn: "+ANSI_RESET);
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
        System.out.println(ANSI_PURPLE+"Im Turm");
    }


    //Passiert wenn man das Portal betritt
    public void Targonbetreten(){
        System.out.println(ANSI_YELLOW+"Der Targon ist der mächtigste Gipfel in Runeterra, ein imposanter Koloss aus sonnenbeschienenem Fels.");
        System.out.println("Er steht inmitten einer Gebirgskette, die in ihrer Größe einzigartig auf dieser Welt ist. Weitab von jeder Zivilisation");
        System.out.println("elegen ist der Targon fast unmöglich zu erreichen. Nur durch äußerste Entschlossenheit gelangen Reisende hierher.");
        System.out.println("Um den Targon ranken sich viele Legenden und wie jeder sagenumwobene Ort zieht er Träumer, Wahnsinnige und verwegene Abenteurer an.");
        System.out.println("Einige mutige Seelen versuchen, den unmöglichen Berg zu erklimmen – vielleicht auf der Suche nach Weisheit oder Erleuchtung,");
        System.out.println("vielleicht im Streben nach Ruhm oder aus dem tiefsten Seelenwunsch heraus,seinen Gipfel zu sehen. Der Aufstieg ist fast ein Ding der Unmöglichkeit");
        System.out.println("nd selbst die wenigen Glücklichen, die irgendwie lebend am Gipfel ankommen, sprechen niemals über das, was sie zu Gesicht bekommen haben. Einige kehren");
        System.out.println("mit leerem und gehetztem Blick zurück, andere haben sich bis zur Unkenntlichkeit verändert und wurden von einem mächtigen,");
        System.out.println("überirdischen Aspekt für ein Schicksal erwählt, das die wenigsten Sterblichen begreifen können.");
    }
}