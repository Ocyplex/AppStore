package com.company;

import java.time.LocalDate;
import java.util.Random;

public class Project {


        public String name;
        public Integer czasRealizacji;
        public Client klient;
        public String poziomZlozonosci;
        public String[] technologie = {"","",""};
        public Integer technologieInt = 0;
        public Double cena;
        public Double kara;
        public LocalDate terminOddania;
        public LocalDate terminPlatnosci;
        public Boolean isFinished = false;
        public Integer dniPracy;
        public Boolean wasTested;

        public Project(String name, Integer technologieInt,Integer czasRealizacji,Double cena, Double kara, Client klient){
                this.name = name;
                this.technologieInt = technologieInt;
                this.czasRealizacji = czasRealizacji;
                this.cena = cena;
                this.kara = kara;
                this.klient = klient;
                switch (technologieInt){
                        case(1):
                                poziomZlozonosci="latwy";
                        case(2):
                                poziomZlozonosci="sredni";
                        case(3):
                                poziomZlozonosci="zlozony";

                }

        }

        public void wypiszTechnologie(){
                System.out.println(name +" wymaga nastepujace skille:");
                for(int i = 0; i<technologieInt ;i++)
                {

                        System.out.println(technologie[i]);
                }
        }

        public void  wypiszTerminOddania(){
                System.out.println("Termin oddania to " + terminOddania.getDayOfMonth() + " " + terminOddania.getMonth() + " " + terminOddania.getYear());
        }

        public void checkIfFinished()//sprawdzenie czy projekt gotowy
        {
                if(czasRealizacji == 0){
                        isFinished = true;
                        System.out.println("Projekt gotowy do oddania!");
                }
        }

        public void projectOddanie(LocalDate ld, Firma firma)
        {
                switch (this.klient.type)
                {
                        case "wyluzowany": {
                                        if (ld.getDayOfMonth() == terminOddania.getDayOfMonth() && ld.getMonth() == terminOddania.getMonth() && isFinished == true) {
                                                Random random = new Random();
                                                int i = random.nextInt(100);
                                                if (i <= 30)// szansa na spoznione wplacenie
                                                {
                                                        System.out.println(klient.name + " opozni sie z wplata! Zaplata bedzie " + ld.getDayOfMonth() + ld.getMonth());
                                                        terminPlatnosci = ld.plusDays(7);
                                                        opoznioneWplaty(firma);
                                                } else {
                                                        firma.cash += cena;
                                                        usunProjektzGotowych(firma);
                                                        System.out.println("Otrzymales wynagrodzenie o wysokosci " + cena);
                                                        System.out.println("Stan konta firmy to " + firma.cash);
                                                }
                                        }
                        }
                        case "wymagajacy":
                                if(ld == terminOddania && isFinished)
                                {

                                }
                        case "skrwl":
                                if(ld == terminOddania && isFinished)
                                {
                                        Random random = new Random();
                                        int i = random.nextInt(100);
                                        if(i == 50)
                                        {
                                                System.out.println("Klient " + klient.name + "ulotnil sie!");
                                        }else{
                                                i = random.nextInt(100);
                                                if(i <= 30)//szansa na spoznione placenie
                                                {
                                                        opoznioneWplaty(firma);
                                                }else{
                                                        firma.cash += cena;
                                                        usunProjektzGotowych(firma);
                                                }
                                        }
                                }else
                                {

                                }
                }
        }

        public void opoznioneWplaty(Firma firma)
        {
                firma.listaOtwartychWplat.add(Project.this);
                usunProjektzGotowych(firma);
        }

        public void usunProjektzGotowych(Firma firma)
        {
                for (int i = 0; i < firma.listaGotowychProjektow.size();i++)
                if(firma.listaGotowychProjektow.get(i) == Project.this)
                {
                        firma.listaGotowychProjektow.remove(i);
                }
        }
    }




