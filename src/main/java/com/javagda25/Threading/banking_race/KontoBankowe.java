package com.javagda25.Threading.banking_race;

public class KontoBankowe {
    private double stanKonta;

    public double getStanKonta() {
        return stanKonta;
    }

    public void przelewPrzychodzacy(double kwota){
        stanKonta+=kwota;
    }

    public void przelewWychodzacy(double kwota){
        stanKonta-=kwota;
    }
}
