package com.javagda25.Threading.homework.ex3;

import java.util.Random;

public class Child implements Runnable {
    private static final String[] KRZYKI = {
            "Czy to już?",
            "Daleko jeszcze?",
            "Dojechaliśmy?",
            "Mamo kiedy już będziemy?",
            "Jest mi niedobrze!"
    };

    private boolean czyDojechalismy = false;

    @Override
    public void run() {
        do {
            int los = new Random().nextInt(5); // exclusive <0, 4> == <0, 5)

            System.out.println(KRZYKI[los]);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Error, interrupted");
                break;
            }
        } while (!czyDojechalismy);
    }

    public void dojechalismy() {
        czyDojechalismy = true;
    }
}
