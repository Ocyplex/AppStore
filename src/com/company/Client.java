package com.company;

public class Client {

    public  String name;
    public final String type;
    public Integer szansaNaOpoznienie;
    public Integer szansaNaUnikniecieKary;
    public Integer szansaNaNieUzyskaniePlatnosci;
    public Integer szansaUtrataKontaktu;

    Client(String name, String type){
        this.type = type;

        switch (this.type)
        {
            case "wyluzowany":
                szansaNaOpoznienie = 30;
                szansaNaUnikniecieKary = 20;
                szansaUtrataKontaktu = 0;
                szansaNaNieUzyskaniePlatnosci = 0;
            case "wymagajacy":
                szansaNaOpoznienie = 0;
                szansaNaUnikniecieKary = 0;
                szansaUtrataKontaktu = 5;
                szansaNaNieUzyskaniePlatnosci = 0;
            case "skrwl":
                szansaNaOpoznienie = 30;
                szansaNaUnikniecieKary = 0;
                szansaUtrataKontaktu = 100;
                szansaNaNieUzyskaniePlatnosci = 1;


        }
    }
}
