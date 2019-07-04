package com.javagda25.Threading.homework.ex2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService pula = Executors.newCachedThreadPool();
        Scanner scanner = new Scanner(System.in);
        int[] liczba = new int[5];

        liczba[0] = scanner.nextInt();
        liczba[1] = scanner.nextInt();
        liczba[2] = scanner.nextInt();
        liczba[3] = scanner.nextInt();
        liczba[4] = scanner.nextInt();

        ZadanieSilnia[] zadanieSilnia = new ZadanieSilnia[5];

        zadanieSilnia[0]= new ZadanieSilnia(liczba[0]);
        zadanieSilnia[1]= new ZadanieSilnia(liczba[1]);
        zadanieSilnia[2]= new ZadanieSilnia(liczba[2]);
        zadanieSilnia[3]= new ZadanieSilnia(liczba[3]);
        zadanieSilnia[4]= new ZadanieSilnia(liczba[4]);

        for (int i = 0; i < zadanieSilnia.length; i++) {
            pula.submit(zadanieSilnia[i]);
        }

        try {
            pula.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Nie doczekałem się zatrzymania pracy puli.");
        }

        System.out.println("Wątki zakończyły pracę, wyniki");
        for (int i = 0; i < zadanieSilnia.length; i++) {
            System.out.println("Silnia " + liczba[i] + ": " + zadanieSilnia[i].getWynik());
        }

        System.out.println("Kończę pracę.");

        pula.shutdown();

    }
}
