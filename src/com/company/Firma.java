package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Firma {
    public Integer cash;




    List<Worker> listaPracownikow = new ArrayList<>(10);
    List<Worker> listaWolnychPracownikow = new ArrayList<>();
    List<Project> listaProjektow = new ArrayList<>();


   // public void wypiszProjecty(){
   //     for(int i = 0; i< Arrays.stream(pulaDostepnychProjektow).count();i++){
   //         System.out.println(pulaDostepnychProjektow[i]);
   //     }
   // }

    public void zatrudniPracownika(Worker worker){
        listaPracownikow.add(worker);
    }

    public void zwolnijPracownika(Integer i)
    {
        listaPracownikow.remove(i);
    }
}
