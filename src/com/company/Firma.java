package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Firma {

    public Double cash = 10000.0;
    public Boolean ZUS = false;
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
            System.out.println( i+"."+pulaDostepnychProjektow.get(i).name + " czas do wykonania " + pulaDostepnychProjektow.get(i).czasRealizacji);
        }
        System.out.println("0.Wybierz projekt dla firmy");
        System.out.println("1.Cofnij");
    }

    public boolean zatrudniPracownika(Integer d){
        if(listaWolnychPracownikow.get(d)!=null)
        {
            listaPracownikow.add(listaWolnychPracownikow.get(d));
            System.out.println("Zatrudniles: " +listaWolnychPracownikow.get(d).name);
            listaWolnychPracownikow.remove(d);
            return true;
        }else {
            return false;
        }

    }

    public void zwolnijPracownika(Integer i)
    {
        listaPracownikow.remove(i);
        System.out.println(listaProjektow.get(i).name + " zostal zwolniony!");
    }

    public void przydzielProject(Integer a, LocalDate b)
    {
        pulaDostepnychProjektow.get(a).terminOddania = b.plusDays(pulaDostepnychProjektow.get(a).czasRealizacji);
        listaProjektow.add(pulaDostepnychProjektow.get(a));
        System.out.println("Zadarles umowe o projekt o nazwie " + pulaDostepnychProjektow.get(a).name);
        pulaDostepnychProjektow.get(a).wypiszTerminOddania();
        pulaDostepnychProjektow.remove(a);
    }

    public boolean jaPracuje(Integer a)
    {
        if(listaProjektow.get(a) == null)
        {
            System.out.println("Niema takiego projektu");
            return false;
        }else {
            listaProjektow.get(a).czasRealizacji -= 1;
            listaProjektow.get(a).checkIfFinished();
            return true;
        }
    }

    public void wypiszInformacje(LocalDate l)
    {
        System.out.println("Stan konta: " + cash + "zl");
        System.out.println("Ilosc pracownikow: " + listaPracownikow.size());
        System.out.println("Ilosc aktywnych projektow: " + listaProjektow.size());
        if (ZUS)
        {
            System.out.println("ZUS na " + l.getMonth() +" zaplacony!");
        }else{
            System.out.println("ZUS na " + l.getMonth() +" jeszcze nie jest oplacony!");
        }
    }

}
