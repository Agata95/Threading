package com.javagda25.Threading.homework.ex3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService pula = Executors.newCachedThreadPool();

        Child[] childrens = new Child[5]; // null null null null null
        for (int i = 0; i < childrens.length; i++) {
            childrens[i] = new Child();
            pula.submit(childrens[i]); // przekaż zadanie do wykonania
        }

        int stoppedChildren = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            String linia = scanner.nextLine();
            if (linia.contains("stop")) {
                childrens[stoppedChildren++].dojechalismy();
                System.err.println("Zatrzymuje: " + (stoppedChildren - 1));
            } else {
                System.err.println("buka: " + linia);
            }
        } while ((stoppedChildren < childrens.length));

//        pula.shutdown();
        try {
            pula.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Nie doczekałem się zatrzymania pracy puli.");
        }

        System.out.println("Nareszcie.");
    }
}
