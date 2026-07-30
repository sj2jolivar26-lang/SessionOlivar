/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.repository;

/**
 *
 * @author Audit
 */

import recordingapp.database.DatabaseConnection;
import recordingapp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginRepository {

    public User login(String username, String password) {

        String sql =
                "SELECT * FROM users " +
                "WHERE username = ? AND password = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id")
                );

                user.setUsername(
                        rs.getString("username")
                );

                user.setPassword(
                        rs.getString("password")
                );

                user.setAccountType(
                        rs.getString("account_type")
                );

                return user;
            }

        } catch (Exception e) {

            System.out.println(
                    "Login error: "
                    + e.getMessage()
            );
        }

        return null;
    }

    public boolean usernameExists(String username) {

        String sql =
                "SELECT user_id FROM users " +
                "WHERE username = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            ResultSet rs =
                    stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {

            System.out.println(
                    "Error checking username: "
                    + e.getMessage()
            );
        }

        return false;
    }
}
