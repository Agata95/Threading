package com.javagda25.Threading.banking_race;

//    Tworzymy klasy:
//    - KontoBankowe, które posiada pole:
//          - double stanKonta;
//    oraz metody:
//      - przelewPrzychodzacy(double kwota)
//      - przelewWychodzacy(double kwota)
//
//    - Bank, która posiada pola:
//          - ExecutorService serwer = Executors.newSingleThreadExecutor();
//          - KontoBankowe konto = new KontoBankowe();
//    oraz metody:
//          - dodajZleceniePrzelewu(double kwota, KierunekPrzelewu kierunek);
//
//          Powyższa metoda ma stworzyć nowy obiekt klasy "Zlecenie". Klasa Zlecenie
//          Implementuje interfejs Runnable. Klasa zlecenie posiada 3 pola:
//              - KontoBankowe kontoNaKtorePrzelacPieniadze;
//              - double kwota;
//              - KierunekPrzelewu kierunek
//          Wszystkie parametry przyjmuje w konstruktorze.
//
//      Zlecenie przelwu po tym jak zostanie stworzone ma być przekazywane do serwera
//      do wykonania. Zlecenie ma metodę "run" którą implementuje z interfejsu Runnable.
//      Zaimplementuj tą metodę następująco:
//          -metoda do konta bankowego które posiada jako pole dodaje lub odejmuje kwotę
//          w zależności od tego jaki jest kierunek przelewu. Jeśli kierunek jest Przychodzący,
//          to dodaje do stanu konta, jeśli jest wychodzący, to odejmuje.
//
//    w klasie bank zaimplementuj ostatnią, dodatkową metodę: "sprawdzStanKonta" która wypisuje
//    ile pieniędzy zostało na koncie.

import sun.awt.windows.ThemeReader;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 0; i < 3000; i++) {
            if (i % 2 == 0) {
                bank.dodajZleceniePrzelewu(5, KierunekPrzelewu.PRZYCHODZACY);
            } else {
                bank.dodajZleceniePrzelewu(5, KierunekPrzelewu.WYCHODZACY);
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.sprawdzStanKonta();
    }

}
