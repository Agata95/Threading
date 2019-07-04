package com.javagda25.Threading.homework.ex2;

import lombok.Data;

@Data

public class ZadanieSilnia implements Runnable {
    private int liczba;
    private int wynik;

    public ZadanieSilnia(int liczba) {
        this.liczba = liczba;
    }

    @Override
    public void run() {
        wynik = recursiveFactorial(liczba);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Zakończyłem obliczenia.");
    }

    private int recursiveFactorial(int number) {
        if (number > 1) {
            return recursiveFactorial(number - 1) * number;
        } else {
            return 1;
        }
    }
}
