package com.company;

import java.time.LocalDate;

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
        public Integer terminPlatnosci;
        public Boolean isFinished = false;
        public Integer dniPracy;

        public Project(String name, Integer technologieInt,Integer czasRealizacji,Double cena, Double kara){
                this.name = name;
                this.technologieInt = technologieInt;
                this.czasRealizacji = czasRealizacji;
                this.cena = cena;
                this.kara = kara;
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

        public void checkIfFinished()
        {
                if(czasRealizacji <= 0){
                        isFinished = true;
                        System.out.println("Projekt gotowy do oddania!");
                }
        }
    }




