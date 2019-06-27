package com.javagda25.Threading.banking_race;

public class KontoBankowe {
    private double stanKonta;
    // synchronizowanie metod, aby wątki poczekały w kolejce na swoją kolej
    // aby nie nachodziły na siebie w momencie dodawania/odejmowania pieniędzy z konta
    private final Object lock = new Object();

    public double getStanKonta() {
        return stanKonta;
    }

    public void przelewPrzychodzacy(double kwota) {
        synchronized (lock) {
            stanKonta += kwota;
        }
    }

    public void przelewWychodzacy(double kwota) {
        synchronized (lock) {
            stanKonta -= kwota;
        }
    }
}
