package org.adivinhacao;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random number = new Random();
        int secret = number.nextInt(100);

        System.out.println(secret);

        System.out.println("Welcome to the Guessing Game");
        System.out.println("Choose the mode | Easy - [1] Normal - [2] Hard - [3]\n");

        String nivel = sc.nextLine();
        int levels = 5;
        levels = Integer.parseInt(nivel);

        //This variable count how chances the user have.
        int fix = 15;

        System.out.println("Choose de number from the 0 of 100\n");

        switch (levels) {
            case 1:
                levels = 5;
                fix = 5;
                System.out.println("You choose the Easy mode");
                System.out.println("You have 5 chances to get it right\n");
                break;
            case 2:
                levels = 10;
                fix = 10;
                System.out.println("You choose the Normal mode");
                System.out.println("You have 10 chances to get it right\n");
                break;
            case 3:
                levels = 15;
                fix = 15;
                System.out.println("You choose the Hard mode");
                System.out.println("You have 15 chances to get it right\n");
                break;
        }
        int i = 5;
        while (i <= levels) {
            String attempt = sc.nextLine();
            int kick = Integer.parseInt(attempt);

            boolean right = kick == secret;
            boolean smaller = kick < secret;
            boolean bigger = kick > secret;

            if (kick <= 0){
                System.out.println("You cannot input negative number \nTry again");
                i--;
                continue;
            }

            if (right) {
                System.out.println("╚═( ͡° ͜ʖ ͡°)═╝\n" +
                        "╚═(███)═╝\n" +
                        "╚═(███)═╝\n" +
                        ".╚═(███)═╝\n" +
                        "..╚═(███)═╝\n" +
                        "…╚═(███)═╝\n" +
                        "…╚═(███)═╝\n" +
                        "..╚═(███)═╝\n" +
                        ".╚═(███)═╝\n" +
                        "╚═(███)═╝\n" +
                        ".╚═(███)═╝\n" +
                        "..╚═(███)═╝\n" +
                        "…╚═(███)═╝\n" +
                        "…╚═(███)═╝\n" +
                        "…..╚(███)╝\n" +
                        "……╚(██)╝\n" +
                        "………(█)");
                break;
            } else if (smaller) {
                System.out.println("\nGuess is smaller than the secret number \nTry Again");
                System.out.println("You have a " + fix + " chance");
                i++;
                fix--;
            } else if (bigger){
                System.out.println("\nGuess is greater than the secret number \nTry again");
                System.out.println("You have a " + fix + " chance");
                i++;
                fix--;
            } else {

            }
        }
    }
}