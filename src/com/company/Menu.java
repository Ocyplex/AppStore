package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    Firma firma = new Firma();
    Scanner scan = new Scanner(System.in);
    int day = 1;

    public String[] menuGlowny = {"0.Firma","1.Pracowniki","2.Projekty","3.Czynosci"};
    public String[] workerMenuArray = {"0.Pokaz liste pracownikow","1.Szukaj nowych pracownikow"};
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

            case(1):
                System.out.println("Lista dostepnych pracownikow:");
                for(int i = 0;i<firma.listaWolnychPracownikow.size();i++)
                {
                    System.out.println(i+"."+firma.listaWolnychPracownikow.get(i).name+" "+firma.listaWolnychPracownikow.get(i).lastName+" "+firma.listaWolnychPracownikow.get(i).stanowisko+" "+firma.listaWolnychPracownikow.get(i).salary);
                }

        }

    }
    public void projectMenu()
    {

    }
    public void doMenu()
    {

    }

}
