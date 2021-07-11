package com.company;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    List<Worker> allWorkerList = new ArrayList<>();
    List<Project> allProjectList = new ArrayList<>();

    Client client = new Client("Ramazon","skrwl");
    Client client1 = new Client("Wyszsza Szkola Bankowa","wyluzowany");
    Client client2 = new Client("Microhard","wymagajacy");

    Worker worker = new Worker("Edzio","Dawny","programista",5500.0,3);
    Worker worker1 = new Worker("Kasia","Mala","programista",7500.0,3);
    Worker worker2 = new Worker("Ferdek","Mocny","tester",1500.0,0);
    Worker worker3 = new Worker("Julia","Taka","sprzedawca",3000.0,1);
    Worker worker4 = new Worker("Pawel","Latajacy","programista",6000.0,3);
    Worker worker5 = new Worker("Kevin","Imprezujacy", "prgramista",7500.0,3);


    Project project = new Project("WSBJAVA",1,5,3000.0,500.0,client1);
    Project project1 = new Project("TowerDefence",1,5,4000.0,500.0,client1);
    Project project2 = new Project("InstaSnap",1,3,2000.0,2000.0,client1);
    Project project3 = new Project("Finder", 2,10,7000.0,300.0,client1);
    Project project4 = new Project("GogleTraps",0,20,50.000,20000.0,client1);
    Project project5 = new Project("Buber",2,10,10.000,2.000,client1);


    public void addLists(){
        System.out.print("Tutaj");
        allWorkerList.add(worker);
        allWorkerList.add(worker1);
        allWorkerList.add(worker2);
        allWorkerList.add(worker3);
        allWorkerList.add(worker4);
        allWorkerList.add(worker5);

        allProjectList.add(project);
        allProjectList.add(project1);
        allProjectList.add(project2);
        allProjectList.add(project3);
        allProjectList.add(project4);
        allProjectList.add(project5);
    }

}

