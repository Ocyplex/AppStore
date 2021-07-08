package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int j = 0;
        Skill sekill = new Skill();
        for(int i = 0;i < Arrays.stream(sekill.skilllist).count() ;i++)
        {
            System.out.println(sekill.skilllist[i]);
        }

        DataBase db = new DataBase();
        Menu menu= new Menu(db);
        menu.db.addLists();
        Worker worker3 = new Worker("Julia","Taka","sprzedawca",3000.0,1);
        menu.firma.listaWolnychPracownikow.add(worker3);
        menu.firma.pulaDostepnychProjektow.add(db.project);


        menu.glownyMenu();
    }
}
