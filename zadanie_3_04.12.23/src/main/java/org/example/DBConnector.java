package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/photo_app?serverTimezone=UTC";
    static final String DB_USER = "sergey";
    static final String DB_PASSWORD = "sergey";
    public static Connection createDBConnetion(){
       Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("DB connected!");

        } catch (Exception e) {
            System.out.println("Błąd podczas połączenia z DB " + e.getMessage());
        }
        return connection;


    }

}
