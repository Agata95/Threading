package com.javagda25.Threading.Zadanie;

public class Main {
    public static void main(String[] args) {
        Thread[] tablicaThreadow = new Thread[5];

        for (int i = 0; i < tablicaThreadow.length; i++) {
            tablicaThreadow[i] = new Thread(new Zadanie("Marian " + i));
        }

        for (Thread thread : tablicaThreadow) {
            thread.start();
        }

        // jeśli chcemy aby najpierw zrobiły się zadania z wątków, a na koniec (sout"Koniec"):
        for (Thread thread : tablicaThreadow) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Koniec");
    }
}
