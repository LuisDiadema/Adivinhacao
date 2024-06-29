package org.adivinhacao.DAO;

import org.adivinhacao.entity.user;
import org.adivinhacao.conection.conection;

import java.lang.String;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class UserDAO {

    public void registeringUser(user ranked) {

        Scanner sc = new Scanner(System.in);

        Random number = new Random();
        int secret = number.nextInt(100);

        System.out.println("Create your nick name:");
        String nicks = sc.nextLine();

        System.out.println("\nChoose the mode | Easy - [1] | Normal - [2] | Hard - [3]\n");

        String nivel = sc.nextLine();
        int levels = 5;
        levels = Integer.parseInt(nivel);

        //This variable count how chances the user have.
        int fix = 15;

        System.out.println("Choose a number from the 0 of 100\n");

        switch (levels) {
            case 1:
                levels = 15;
                fix = 14;
                System.out.println("You choose the Easy mode");
                System.out.println("You have 15 chances to get it right\n");
                break;
            case 2:
                levels = 10;
                fix = 9;
                System.out.println("You choose the Normal mode");
                System.out.println("You have 10 chances to get it right\n");
                break;
            case 3:
                levels = 5;
                fix = 4;
                System.out.println("You choose the Hard mode");
                System.out.println("You have 5 chances to get it right\n");
                break;
        }

        int i = 1;
        while (i <= levels) {
            String attempt = sc.nextLine();
            int kick = Integer.parseInt(attempt);

            boolean right = kick == secret;
            boolean smaller = kick < secret;
            boolean bigger = kick > secret;

            if (kick <= 0) {
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
            }
            if (smaller) {
                System.out.println("\nGuess is smaller than the secret number");
                System.out.println("You have a " + fix + " chance");
                System.out.println("\nTry again");
                i++;
                fix--;
            } if (bigger) {
                System.out.println("\nGuess is greater than the secret number");
                System.out.println("You have a " + fix + " chance");
                System.out.println("\nTry again");
                i++;
                fix--;
            }
        }

        double points = 1000;
        double score = points * 2 / 3;
        System.out.println("Your score is " + score + "\n\n");


        System.out.println("\n─█───█▀▀█─█▀▀─█▀▀─█▀▀─█▀▀█\n" +
                "─█───█──█─▀▀█─▀▀█─█▀▀─█▄▄▀\n" +
                "─▀▀▀─▀▀▀▀─▀▀▀─▀▀▀─▀▀▀─▀─▀▀");

        String sql = "INSERT INTO RANKED (NICK, SCORE) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conection.getConection().prepareStatement(sql);

            ps.setString(1, user.getNick(nicks));
            ps.setDouble(2, user.getScore(score));

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
