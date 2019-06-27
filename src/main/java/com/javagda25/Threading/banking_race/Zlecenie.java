package com.javagda25.Threading.banking_race;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Zlecenie implements Runnable {
    KontoBankowe kontoNaKtorePrzelacPieniadze;
    private double kwota;
    KierunekPrzelewu kierunek;

    public Zlecenie(KontoBankowe kontoNaKtorePrzelacPieniadze, double kwota, KierunekPrzelewu kierunek) {
        this.kontoNaKtorePrzelacPieniadze = kontoNaKtorePrzelacPieniadze;
        this.kwota = kwota;
        this.kierunek = kierunek;
    }

    public void run() {
        if (kierunek == KierunekPrzelewu.PRZYCHODZACY) {
            kontoNaKtorePrzelacPieniadze.przelewPrzychodzacy(kwota);
        } else if (kierunek == KierunekPrzelewu.WYCHODZACY) {
            kontoNaKtorePrzelacPieniadze.przelewWychodzacy(kwota);
        }
    }
}
