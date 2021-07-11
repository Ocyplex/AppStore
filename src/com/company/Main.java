package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DataBase db = new DataBase();
        Menu menu= new Menu(db);
        menu.db.addLists();
        //Worker worker3 = new Worker("Julia","Taka","sprzedawca",3000.0,1);
        //menu.firma.listaWolnychPracownikow.add(worker3);
        menu.firma.pulaDostepnychProjektow.add(db.project);
        menu.firma.listaWolnychPracownikow = menu.db.allWorkerList;


        menu.glownyMenu();
    }
}
