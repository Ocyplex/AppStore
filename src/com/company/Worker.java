package com.company;

import java.util.Arrays;
import java.util.Random;

public class Worker {
    public String name;
    public String lastName;
    public Double salary;
    public String stanowisko;
    public String[] workerSkills = {"Empty","Empty","Empty","Empty","Empty","Empty"};
    public Integer skillNumber; //ile pracownik ma miec skillow
    int maxSkill = 6; // maxymalna randomowa liczba
    public Boolean spelniaTechnologie;
    public Project myProject;
    public Integer sprzedawcaTime = 5;

    Worker(String name,String lastName,String stanowisko, Double salary, Integer skillNumber ){
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.skillNumber = skillNumber;
        this.stanowisko = stanowisko;
        switch (this.stanowisko) {
            case "programista":
                this.workerSkills[0] = workerSkills[this.skillNumber];
                skillRandom(this.skillNumber);
            case "sprzedawca" :
            case "tester":
        }
    }

    private void skillRandom(Integer skillNumber){
        this.skillNumber = skillNumber;
        Random rand = new Random();
        Skill mySkill = new Skill();

        for(int i = 0; i < skillNumber;i++)
        {
            int random_Skill = rand.nextInt(maxSkill);
            for(int j = 0;j < skillNumber; j++)
            {
                if(workerSkills[j]==mySkill.skilllist[random_Skill])
                {
                    System.out.println(mySkill.skilllist[random_Skill]);
                    j = 0;
                    random_Skill = rand.nextInt(maxSkill);
                    break;
                }
                if (j==skillNumber-1){
                    workerSkills[i]=mySkill.skilllist[random_Skill];
                }
            }


        }

    }

    public void przydzielProject(Project project)
    {
        if(stanowisko == "programista") {
            int pasuje = 0;
            for (int i = 0; i <= project.technologieInt; i++) {
                for (int j = 0; j < Arrays.stream(workerSkills).count(); j++)
                    if (project.technologie[i] == workerSkills[j]) {
                        pasuje++;
                    }
            }
            if (pasuje == project.technologieInt) {
                myProject = project;
                System.out.println("Pracownik " + name + "zostal przydzielony project " + project.name);
            } else {
                System.out.println("Pracownik " + name + " niema odpowiedniego skilla na " + project.name);
            }
        }
    }

    public void wypiszSkille(){
        System.out.println("Skille: ");
        for(int i = 0; i< Arrays.stream(workerSkills).count() ; i++)
        {
            if(workerSkills[i]=="Empty") {

            }else{
                System.out.print(workerSkills[i] + " ");
            }
        }
        System.out.println();
    }


    public void wypiszInformacjeOPracowniku(){
        System.out.println("Imie: "+ name + " Nazwisko: " + lastName);
        System.out.println("Stanowisko: "+stanowisko+" Stawka: "+salary);
        try {
            System.out.println("przydzielony projekt: " + myProject.name);
        }catch (Exception e){
            System.out.println("niema przydzielonego projektu");
        }
        wypiszSkille();
    }

    public void pracuj(Firma firma, DataBase dataBase){
        if (Worker.this.stanowisko == "programista" && Worker.this.myProject != null)
        {
            Worker.this.myProject.czasRealizacji -= 1;
            System.out.println(name + " pracuje, do realizacji zostalo " + myProject.czasRealizacji + " dni");
            Worker.this.myProject.checkIfFinished();
        }

        if(stanowisko == "sprzedawca")//Dodawanie projektow co 5 dni
        {
            sprzedawcaTime--;
            if(sprzedawcaTime == 1)
            {
                int rn = 0;
                Random random = new Random();
                rn = random.nextInt(dataBase.allProjectList.size()+ 0);
                firma.pulaDostepnychProjektow.add(dataBase.allProjectList.get(rn));//dodanie do pul firmy
                dataBase.allProjectList.remove(rn);//Usuniecie z glownej listy
                sprzedawcaTime = 5;//nowy timer
            }
        }

        if(stanowisko == "tester")
        {
            for(int i=0;i<firma.listaProjektow.size();i++) // tester sprawdza gotowy projekty maximalnie 3
            {
                for(int j=0;j<3;j++){
                if(firma.listaProjektow.get(i).isFinished)
                {
                    firma.listaProjektow.get(i).wasTested = true;
                    j++;
                }
                }
            }
        }
    }
}
