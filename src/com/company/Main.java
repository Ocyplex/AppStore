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

        Menu menu= new Menu();

        Worker worker = new Worker("Edzio","Dawny","programista",5500.0,3);
        Worker worker1 = new Worker("Kasia","Mala","programista",7500.0,3);
        Worker worker2 = new Worker("Ferdek","Mocny","tester",1500.0,0);
        Worker worker3 = new Worker("Julia","Taka","sprzedawca",3000.0,1);
        Worker worker4 = new Worker("Pawel","Latajacy","programista",6000.0,3);
        Project project = new Project("WSBJAVA",1,5,3000.0,500.0);
        Project project1 = new Project("TowerDefence",1,5,4000.0,500.0);
        Project project2 = new Project("InstaSnap",1,3,2000.0,2000.0);
        Project project3 = new Project("Finder", 2,10,7000.0,300.0);
        Project project4 = new Project("GogleTraps",0,20,50.000,20000.0);
        Project project5 = new Project("Buber",2,10,10.000,2.000);

        project.technologie[0]="front-end";


        worker.wypiszSkille();
        project.wypiszTechnologie();



        menu.firma.listaWolnychPracownikow.add(worker);
        menu.firma.listaWolnychPracownikow.add(worker1);
        menu.firma.listaWolnychPracownikow.add(worker2);
        menu.firma.listaWolnychPracownikow.add(worker3);
        menu.firma.pulaDostepnychProjektow.add(project);
        menu.firma.pulaDostepnychProjektow.add(project1);
        menu.firma.pulaDostepnychProjektow.add(project2);
        menu.firma.pulaDostepnychProjektow.add(project3);
        menu.firma.pulaDostepnychProjektow.add(project4);
        menu.firma.pulaDostepnychProjektow.add(project5);

        menu.glownyMenu();
    }
}
