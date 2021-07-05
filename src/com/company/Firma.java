package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Firma {
    public Integer cash;




    List<Worker> listaPracownikow = new ArrayList<>(10);
    List<Worker> listaWolnychPracownikow = new ArrayList<>();
    List<Project> listaProjektow = new ArrayList<>();
    List<Project> pulaDostepnychProjektow = new ArrayList();


    public void wypiszProjecty(){
        for(int i = 0; i< listaProjektow.stream().count();i++){
            System.out.println(listaProjektow.get(i).name + " dni do realizacji " + listaProjektow.get(i).czasRealizacji);
        }
    }
    public void wypiszWolneProjecty(){
        for(int i = 0; i< pulaDostepnychProjektow.stream().count();i++){
            System.out.println(pulaDostepnychProjektow.get(i).name + " czas do wykonania " + pulaDostepnychProjektow.get(i).czasRealizacji);
        }
    }

    public void zatrudniPracownika(Worker worker){
        listaPracownikow.add(worker);
    }

    public void zwolnijPracownika(Integer i)
    {
        listaPracownikow.remove(i);
    }
}
