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

        //This block of code create a random number.
        Random number = new Random();
        int secret = number.nextInt(100);

        System.out.println(secret);

        System.out.println("Create your nick name:");
        String nick = sc.nextLine();
        System.out.println("You nick is " + nick);

        //This variable count how chances the user have.
        int fix = 15;

        //This block of code selects between three game mode: easy, normal and hard.
        System.out.println("\nChoose the mode | Easy - [1] | Normal - [2] | Hard - [3]\n");
        String nivel = sc.nextLine();
        int levels = 5;
        levels = Integer.parseInt(nivel);

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

        System.out.println("Choose a number from the 0 of 100\n");

        //This block of code read of the user input and the decision of structure read and executa
        int i = 1;
        String attempt = null;
        while (i <= levels) {
            attempt = sc.nextLine();
            int kick = Integer.parseInt(attempt);

            boolean right = kick == secret;

            if (kick <= 0) {
                System.out.println("You cannot input negative number \nTry again");
                i--;
                continue;
            }
            if (right) {
                break;
            } else if (kick < secret) {
                System.out.println("\nGuess is smaller than the secret number");
                System.out.println("You have a " + fix + " chance");
                System.out.println("\nTry again");
                i++;
                fix--;
            } else {
                System.out.println("\nGuess is greater than the secret number");
                System.out.println("You have a " + fix + " chance");
                System.out.println("\nTry again");
                i++;
                fix--;
            }
        }

        //This block of code count points the user makes.
        assert attempt != null;
        int kick = Integer.parseInt(attempt);
        boolean right = kick == secret;

        //This block of code prints a win or loss message.
        if (right) {
            System.out.println("╚═( ͡° ͜ʖ ͡°)═╝\\n\" +\n" +
                    "                        \"╚═(███)═╝\\n\" +\n" +
                    "                        \"╚═(███)═╝\\n\" +\n" +
                    "                        \".╚═(███)═╝\\n\" +\n" +
                    "                        \"..╚═(███)═╝\\n\" +\n" +
                    "                        \"…╚═(███)═╝\\n\" +\n" +
                    "                        \"…╚═(███)═╝\\n\" +\n" +
                    "                        \"..╚═(███)═╝\\n\" +\n" +
                    "                        \".╚═(███)═╝\\n\" +\n" +
                    "                        \"╚═(███)═╝\\n\" +\n" +
                    "                        \".╚═(███)═╝\\n\" +\n" +
                    "                        \"..╚═(███)═╝\\n\" +\n" +
                    "                        \"…╚═(███)═╝\\n\" +\n" +
                    "                        \"…╚═(███)═╝\\n\" +\n" +
                    "                        \"…..╚(███)╝\\n\" +\n" +
                    "                        \"……╚(██)╝\\n\" +\n" +
                    "                        \"………(█)");
        } else {
            System.out.println("LOSER");
        }

        //This block of code adds the user's score.
        int score = i + 5 * 3 / 8;
        System.out.printf("Your score is " + score + "\n\n");

        //This block of code insert the data in the SQL database.
        String sql = "INSERT INTO RANKED (NICK, SCORE) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = conection.getConection().prepareStatement(sql);

            ps.setString(1, user.getNick(nick));
            ps.setDouble(2, user.getScore(score));

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
