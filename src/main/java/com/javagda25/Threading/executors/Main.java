package com.javagda25.Threading.executors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        ExecutorService pulaWatkow = Executors.newFixedThreadPool(5);
//        ExecutorService pulaWatkow = Executors.newCachedThreadPool();
//        ExecutorService pulaWatkow = Executors.newSingleThreadExecutor(); // wchodzą do kolejki po kolei (fifo)
        ScheduledExecutorService pulaWatkow = Executors.newScheduledThreadPool(5);

//        for (int i = 0; i < 10000; i++) {
//            int finalI = i;
//            pulaWatkow.submit(new Runnable() { // zakolejkuj zadanie
//                public void run() {
//                    try {
//                        Thread.sleep(new Random().nextInt(5));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(finalI);
//                }
//            });
//        }
        pulaWatkow.scheduleWithFixedDelay(new Runnable() {
                                              @Override
                                              public void run() {
                                                  System.out.println("Siema grupo!");
                                              }
                                          },
                5, // wystartuj po 5 sek
                2, // co 2 sekundy
                TimeUnit.SECONDS);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pulaWatkow.shutdownNow();
        System.out.println("Koniec");
    }
}
