/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.model;

/**
 *
 * @author Audit
 */

import recordingapp.database.DatabaseConnection;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("   MUSIC MANAGEMENT SYSTEM");
        System.out.println("=================================");

        System.out.println();
        System.out.println("Testing database connection...");

        Connection connection =
                DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Connection test successful!");

            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error closing connection.");
            }
        }
    }
}