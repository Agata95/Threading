package com.javagda25.Threading.banking_race;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank {
//    ExecutorService serwer = Executors.newSingleThreadExecutor();
    ExecutorService serwer = Executors.newFixedThreadPool(5);
    KontoBankowe konto = new KontoBankowe();

    public void dodajZleceniePrzelewu(double kwota, KierunekPrzelewu kierunek) {
        Zlecenie zlecenie = new Zlecenie(konto, kwota, kierunek);
        serwer.submit(zlecenie);
    }

    public void sprawdzStanKonta() {
        System.out.println(konto.getStanKonta());
    }
}
