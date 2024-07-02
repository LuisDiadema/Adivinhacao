package org.adivinhacao.entity;

import java.lang.String;

public class user {

    private int codigo;
    private double score;
    private String nick;

    public static int getCodigo(int codigo) {
        return codigo;
    }
    public void setCodigo (int codigo) {
        this.codigo = codigo;
    }
    public static double getScore(double score) {
        return score;
    }
    public void setScore (double score) {
        this.score = score;
    }
    public static String getNick(String nick) {
        return nick;
    }
    public void setNick (String nick) {
        this.nick = nick;
    }
}
