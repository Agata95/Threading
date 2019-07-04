package com.javagda25.Threading.homework.ex1;

public class AlarmClock implements Runnable {
    private final String atTheEnd = "Co teraz?";

    @Override
    public void run() {
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atTheEnd);
    }
}
