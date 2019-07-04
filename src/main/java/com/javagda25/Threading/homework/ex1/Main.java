package com.javagda25.Threading.homework.ex1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService pula = Executors.newCachedThreadPool();

        AlarmClock alarmClock = new AlarmClock();
        Scanner scanner = new Scanner(System.in);
        String linia = scanner.nextLine();

        if(linia.equalsIgnoreCase("teraz")){
            pula.submit(alarmClock);
        }

        pula.shutdown();
    }
}
