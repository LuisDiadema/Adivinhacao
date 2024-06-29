package org.adivinhacao.entity;

public class user {

    private static double score;
    private static String nick;

    public static double getScore(double score) {
        return score;
    }
    public void setScore (double score) {
        this.score = score;
    }
    public static String getNick (String nicks) {
        return nick;
    }
    public void setNick (String nick) {
        this.nick = nick;
    }
}
