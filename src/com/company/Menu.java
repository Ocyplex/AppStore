package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    Firma firma = new Firma();
    Scanner scan = new Scanner(System.in);
    int day = 1;

    public String[] menuGlowny = {"0.Firma","1.Pracowniki","2.Projekty","3.Czynosci"};
    public String[] workerMenuArray = {"0.Pokaz liste pracownikow","1.Szukaj nowych pracownikow","2.Zatrudni pracownika","3.Zwolni pracownika","4.Cofni"};
    public String[] projectMenuArray = {"0.Sprawdz status projektow","1.Szukaj nowych projektow","2.Przydziel projekt","3.Cofni"};
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
        }
    }

    public void firmaMenu()
    {

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
                System.out.print("Podaj nr pracownika ktorego chcesz zatrudnic: ");
                int d = scan.nextInt();
                if(firma.listaWolnychPracownikow.get(d)!=null)
                {
                    firma.listaPracownikow.add(firma.listaWolnychPracownikow.get(d));
                    System.out.println("Zatrudniles: " +firma.listaWolnychPracownikow.get(d).name);
                    firma.listaWolnychPracownikow.remove(d);
                }
                glownyMenu();
            case (3):
                System.out.print("Podaj nr pracownika ktorego chcesz zwolnic: ");
                int c = scan.nextInt();
                firma.listaPracownikow.remove(c);
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
        switch (s)
        {
            case(0):
            case(1):
            case(2):
                System.out.print("Jaki pracownik:");
                int d = scan.nextInt();
                if(firma.listaPracownikow.stream().count()<d)//Sprawdzic czy takie miejsce w liscie istnije
                {
                    System.out.println("Niema takiego pracownika");
                    projectMenu();
                    return;

                }
                System.out.println("Jaki projekt:");
                int f = scan.nextInt();
                if(firma.listaProjektow.stream().count()<f)
                {
                    System.out.println("Niema takiego projektu");
                    projectMenu();
                    return;
                }
                firma.listaPracownikow.get(d).przydzielProject(firma.listaProjektow.get(f));
            case(3):
                glownyMenu();
        }
    }
    public void doMenu()
    {

    }

}
