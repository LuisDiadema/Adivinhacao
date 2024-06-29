package org.adivinhacao;

import org.adivinhacao.DAO.UserDAO;
import org.adivinhacao.entity.user;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome the Guessing Game\n");

        user u = new user();
        new UserDAO().registeringUser(u);

    }
}