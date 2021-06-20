package com.company;

public class Project {


        public String name;
        public Integer czasRealizacji;
        public Client klient;
        public String poziomZlozonosci;
        public String[] technologie = {"","",""};
        public Integer technologieInt = 0;
        public Double cena;
        public Double kara;
        public Integer terminOddania;
        public Integer terminPlatnosci;
        public Boolean isFinished = false;

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



    }






//nazwa projektu
//ilość roboczodni potrzebnych do realizacji w podziale na poszczególne technologie
//front-end
//backend
//baza danych
//mobile
//wordpress
//prestashop
//klient
//termin oddania
//wysokość kary za przekroczenie terminu
//cena jaką klient może zapłacić za realizację
//termin płatności (ile dni minie od oddania projektu do otrzymania zapłaty)
//poziom złożoności (łatwy/średni/złożony)

