package org.adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int smaller;
        int bigger;
        int attemptNumber = 5;


        Random number = new Random();

        int secret = number.nextInt(100);

        System.out.println("Welcome to the Guessing Game");
        System.out.println("You have 5 chance to win");
        System.out.println("Choose a number from 0 to 100\n");

        Scanner sc = new Scanner(System.in);
        String kick = sc.nextLine();
        int attempt = Integer.parseInt(kick);

        for (int i = 0; i < attemptNumber; i++) {
            if (attempt == secret) {
                System.out.println("You winner");
            } else if (attempt < secret) {
                System.out.println("Attempt is smaller the secret number");
            } else if (attempt > secret) {
                System.out.println("Attempt is bigger teh secret number");
            } else if (attempt < 0) {
                System.out.println("Not nagative number");
            }
        }

    }
    public static void smaller () {

    }
    static void bigger () {
        while(true) {
            System.out.println("Attempt is bigger the secret number");
            System.out.println("Try again");
            bigger();
        }
    }
}