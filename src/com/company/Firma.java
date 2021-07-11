package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Firma {

    public Double cash = 10000.0;
    public Boolean ZUS = false;
    public Integer zusTime = 2;
    public Integer jaSzukanieTime = 5;
    Scanner scan = new Scanner(System.in);
    List<Worker> listaPracownikow = new ArrayList<>(10);
    List<Worker> listaWolnychPracownikow = new ArrayList<>();
    List<Project> listaProjektow = new ArrayList<>();
    List<Project> pulaDostepnychProjektow = new ArrayList();
    List<Project> listaGotowychProjektow = new ArrayList<>();
    List<Project> listaOtwartychWplat = new ArrayList<>();


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

    public void jaPracuje(Menu menu)
    {
        System.out.println("Nad jakim projektem chcesz pracowac?");
        for(int i = 0;i<listaProjektow.size();i++){
            System.out.print(i + "." +listaProjektow.get(i).name + " ### ");
        }
        int d = scan.nextInt();
        if(listaProjektow.get(d) == null)
        {
            System.out.println("Niema takiego projektu");
            menu.glownyMenu();
        }else {
            listaProjektow.get(d).czasRealizacji -= 1;
            listaProjektow.get(d).checkIfFinished();
            menu.endTurn();
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

    public void checkZUS(){
        if(zusTime <= 0)
        {
            ZUS = true;
        }
    }

    public void jaSzukamProjektow(DataBase db){ //Co 5 dni dodanie projektu z DataBase Klasy
        jaSzukanieTime--;
        if(jaSzukanieTime ==0){
            pulaDostepnychProjektow.add(db.allProjectList.get(0));
            System.out.println("Znalazles projekt!");
            jaSzukanieTime = 5;
        }
    }

    public void oddajGotowyProjekt(LocalDate ld,Menu menu)
    {
        if (listaGotowychProjektow.size() > 0)
        {
            System.out.println("Jaki projekt chcesz oddac?");
            for (Project p: listaGotowychProjektow) {
                System.out.println(p.name);
            }
            int s = scan.nextInt();
            listaGotowychProjektow.get(s).projectOddanie(ld,this);
            menu.endTurn();
        }else {
            System.out.println("Niemasz gotowych projektow!");
            menu.glownyMenu();
        }
    }

    public void szukajGotowychProjektow()
    {
        for(int i = 0;i<listaProjektow.size();i++)
        {
            if(listaProjektow.get(i).isFinished)//sprawdzenie czy projekt gotowy
            {
                listaGotowychProjektow.add(listaProjektow.get(i));//wpisanie na gotowa liste
                listaProjektow.remove(i);//usuniecie z starej listy
            }
        }
        if(listaGotowychProjektow.size()>0) {
            System.out.println("Masz " + listaGotowychProjektow.size() +" projekt do oddania!");
        }
    }

    public boolean checkIfLose()
    {
        if(cash < 0)
        {
         return true;
        }else{
            return false;
        }
    }
}
