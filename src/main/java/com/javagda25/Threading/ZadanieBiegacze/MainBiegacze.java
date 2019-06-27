package com.javagda25.Threading.ZadanieBiegacze;

public class MainBiegacze {
    public static void main(String[] args) {
//          1. Zadaniem (przekazywanym do wątku) będzie obiekt klasy biegacz.
//          2. Wewnątrz metody run biegacz ma zawsze przesypiać 1000 ms. i losować liczbę
//              wylosowana liczba to będzie dystans, który przebiegł. Po przebiegnięciu biegacz
//              ma wypisać ile przebiegł. W biegaczu (klasie) musi się znajdować pole dystansu
//              który przebiegł. Do pola sumujemy wszystkie odcinki, które przebiegł. Pole musi mieć getter.
//          3. W metodzie main startujemy wszystkie wątki.
//          4. Metoda main powinna mieć pętle while w której co 3000 ms. wywołuje metodę gettera.
//              i pobiera przebiegnięty dystans z każdego z biegaczy.
//          5. Biegacze mają przebiec dystans do 100, losujemy im dystans po 10.
//          6. Na koniec Main'a, wątek main powinien robić Join wszystkich wątków.
//          7. Na koniec Main'a po join'ach powinien być wypisany komunikat "Koniec".

        Biegacz[] tablicaBiegaczy = new Biegacz[5];

        tablicaBiegaczy[0] = new Biegacz("Antek");
        tablicaBiegaczy[1] = new Biegacz("Rafał");
        tablicaBiegaczy[2] = new Biegacz("Zosia");
        tablicaBiegaczy[3] = new Biegacz("Magda");
        tablicaBiegaczy[4] = new Biegacz("Tomek");

        Thread[] tablicaThreadow = new Thread[5];

        for (int i = 0; i < tablicaThreadow.length; i++) {
            tablicaThreadow[i] = new Thread(tablicaBiegaczy[i]);
        }

        for (Thread thread : tablicaThreadow) {
            thread.start();
        }

        boolean czyKtosSkonczyl = false;
        while (!czyKtosSkonczyl) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Biegacze przebiegli");
            for (int i = 0; i < 5; i++) {
                System.out.print(tablicaBiegaczy[i].getDystans() + " ");
                if (tablicaBiegaczy[i].getDystans() >= 100) {
                    czyKtosSkonczyl = true;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            tablicaThreadow[i].interrupt(); // chcemy aby wywołał się wyjątek
        }

        for (int i = 0; i < 5; i++) {
            try {
                tablicaThreadow[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
