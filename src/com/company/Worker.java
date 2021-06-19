package com.company;

import java.util.Random;

public class Worker {
    public String name;
    public String lastName;
    public Double salary;
    public String[] workerSkills = {"Empty","Empty","Empty","Empty","Empty","Empty"};
    public Integer skillNumber; //ile pracownik ma miec skillow
    int maxSkill = 6; // maxymalna randomowa liczba

    Worker(String name,String lastName, Double salary, Integer skillNumber ){
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.skillNumber = skillNumber;
        this.workerSkills[0] = workerSkills[this.skillNumber];
        skillRandom(this.skillNumber);
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
}
