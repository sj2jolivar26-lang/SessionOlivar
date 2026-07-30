/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.database;

/**
 *
 * @author Audit
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/music_db";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "";

    public static Connection getConnection() {

        try {
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connection successful!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());

            return null;
        }
    }
}