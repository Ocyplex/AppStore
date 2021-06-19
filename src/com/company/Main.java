package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int j = 0;
        Skill sekill = new Skill();
        for(int i = 0;i < Arrays.stream(sekill.skilllist).count() ;i++)
        {
            System.out.println(sekill.skilllist[i]);
        }

        Worker worker = new Worker("Edzio","Dawny","programista",5000.0,3);


        Project project = new Project("WSBJAVA",2);
        project.technologie[0]="front-end";
        project.technologie[1]="mobile";

        worker.wypiszSkille();
        project.wypiszTechnologie();
        worker.przydzielProject(project);
    }
}
