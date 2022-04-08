package com.company;

import java.util.Stack;


public class Main {
    public static final Stack<Integer> score = new Stack<>();
    public static boolean isStarted = false;

    public static void main(String[] args) {
        int countOfNumbers = 1000;
        Thread racerNumberOne = new MyThreadRace(countOfNumbers);
        Thread racerNumberTwo = new MyThreadRace(countOfNumbers);
        Thread racerNumberThree = new MyThreadRace(countOfNumbers);

        racerNumberOne.start();
        racerNumberTwo.start();
        racerNumberThree.start();
        final int min = 10;
        final int max = 99;
        for (int i = 0; i < countOfNumbers; i++) {
            int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
            score.push(randomNumber);
        }
        System.out.println("The race started!");
        isStarted = true;

        try {
            racerNumberOne.join();
            racerNumberTwo.join();
            racerNumberThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The race is over!");
    }
}