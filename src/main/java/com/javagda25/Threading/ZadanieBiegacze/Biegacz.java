package com.javagda25.Threading.ZadanieBiegacze;

import java.util.Random;

public class Biegacz implements Runnable {
    private String name;
    private int dystans;

    public int getDystans() {
        return dystans;
    }

    public void setDystans(int dystans) {
        this.dystans = dystans;
    }

    public Biegacz(String name) {
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            int dystansJednoPrzebiegniecie = new Random().nextInt(10) + 1;
            System.out.println(name + " przebiegł " + dystansJednoPrzebiegniecie);
            dystans += dystansJednoPrzebiegniecie;
        }
    }
}
