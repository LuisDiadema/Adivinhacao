package org.adivinhacao.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conection {

    private static final String url= "jdbc:mysql://localhost:3306/ranked";
    private static final String user = "root";
    private static final String password = "Gustavo@14";

    private static Connection conn;

    public static Connection getConection() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
