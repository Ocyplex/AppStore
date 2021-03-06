package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;


public class Menu {


    Firma firma = new Firma();
    Scanner scan = new Scanner(System.in);
    LocalDate czas = LocalDate.of(2020,1,1);


    public String[] menuGlowny = {"0.Firma","1.Pracownicy","2.Projekty","3.Czynnosci"};
    public String[] workerMenuArray = {"0.Pokaz liste pracownikow","1.Szukaj nowych pracownikow","2.Zatrudnij pracownika","3.Zwolnij pracownika","4.Cofnij"};
    public String[] projectMenuArray = {"0.Sprawdz status projektow","1.Szukaj nowych projektow","2.Przydziel projekt","3.Cofnij"};
    public String[] wybierzProjectArray = {"0.Wybierz projekt","1.Cofnij"};
    public String[] doMenuArray = {"0.Pracuj nad projektem","1.Sprawy urzedowe","2.Szukaj projektow","3.Oddaj gotowy projekt","4.Cofnij"};
    public DataBase db;



    Menu(DataBase db){
        this.db = db;
    }

    public void glownyMenu()
    {
    for(int i = 0; i< Arrays.stream(menuGlowny).count(); i++)
    {
        System.out.println(menuGlowny[i]);
    }
        int s = scan.nextInt();
        System.out.println("Wybrales "+ menuGlowny[s]);
        switch (s){
            case (0):
                firmaMenu();
            case(1):
                workerMenu();
            case(2):
                projectMenu();
            case(3):
                doMenu();
            default:
                glownyMenu();
        }
    }

    public void firmaMenu()
    {
        firma.wypiszInformacje(czas);
        glownyMenu();
    }
    public void workerMenu()
    {
        for(int i = 0; i< Arrays.stream(workerMenuArray).count(); i++)
        {
            System.out.println(workerMenuArray[i]);
        }
        int s = scan.nextInt();
        switch (s){
            case(0):
                System.out.println("Lista twoich pracownikow:");
                for(int i = 0;i<firma.listaPracownikow.size();i++){
                    System.out.print(i+".");
                    firma.listaPracownikow.get(i).wypiszInformacjeOPracowniku();
                    workerMenu();
                }
            case(1):
                System.out.println("Lista dostepnych pracownikow:");
                for(int i = 0;i<firma.listaWolnychPracownikow.size();i++)
                {
                    System.out.print(i+".");
                    firma.listaWolnychPracownikow.get(i).wypiszInformacjeOPracowniku();
                }
                workerMenu();
            case(2):
                System.out.print("Podaj nr pracownika, ktorego chcesz zatrudnic: ");
                int d = scan.nextInt();
                if(firma.zatrudniPracownika(d)) {
                    endTurn();
                }
                glownyMenu();
            case (3):
                System.out.print("Podaj nr pracownika, ktorego chcesz zwolnic: ");
                int c = scan.nextInt();
                firma.zwolnijPracownika(c);
                glownyMenu();
            case(4):
                glownyMenu();
        }

    }
    public void projectMenu()
    {
        for(int i = 0; i< Arrays.stream(projectMenuArray).count(); i++)
        {
            System.out.println(projectMenuArray[i]);
        }
        int s = scan.nextInt();
        switch (s) {
            case (0):
                firma.wypiszProjecty();
                projectMenu();
            case (1):
                firma.wypiszWolneProjecty();
                int c = scan.nextInt();
                switch (c) {
                    case (0):
                        System.out.println("Wybierz projekt");
                        int d = scan.nextInt();
                        firma.przydzielProject(d, czas);
                        glownyMenu();
                    case (1):
                        projectMenu();
                }
            case(2):
                System.out.print("Jaki pracownik:");
                int d = scan.nextInt();
                if(firma.listaPracownikow.stream().count()<d)//Sprawdzic czy takie miejsce w liscie istnije
                {
                    System.out.println("Nie ma takiego pracownika");
                    projectMenu();
                }
                System.out.println("Jaki projekt:");
                int f = scan.nextInt();
                if(firma.listaProjektow.stream().count()<f)
                {
                    System.out.println("Nie ma takiego projektu");
                    projectMenu();
                }
                firma.listaPracownikow.get(d).przydzielProject(firma.listaProjektow.get(f));
            case(3):
                glownyMenu();
        }
    }
    public void doMenu()
    {
        for(int i = 0; i< Arrays.stream(doMenuArray).count(); i++)
        {
            System.out.println(doMenuArray[i]);
        }
        int s = scan.nextInt();
        switch (s)
        {
            case (0):
                    firma.jaPracuje(this);
            case(1):
                if(!firma.ZUS){
                    if(firma.zusTime>0){
                        System.out.println("Robiles sprawy urzedowe");
                        firma.zusTime--;
                        firma.checkZUS();
                        endTurn();
                    }
                }else {
                    System.out.println("ZUS juz zalatwiony na " + czas.getMonth());
                    glownyMenu();
                }
            case(2):
                firma.jaSzukamProjektow(db);
                endTurn();
            case(3):
                firma.oddajGotowyProjekt(czas,this);
            case(4):
                glownyMenu();

        }
    }

    public void endTurn()//Konczenie tury
    {
        System.out.println("Zakonczyles dzien!");
        czas = czas.plusDays(1);//dodac jeden dzien
        for(Worker worker: firma.listaPracownikow)
        {
            worker.pracuj(firma,db);
        }
        firma.szukajGotowychProjektow();
        System.out.println(czas.getDayOfMonth() + " " + czas.getMonth() + " " + czas.getYear());
        if(firma.checkIfLose())
        {
            System.out.print("Przegrales!");
        }else {
            glownyMenu();
        }
    }

}
