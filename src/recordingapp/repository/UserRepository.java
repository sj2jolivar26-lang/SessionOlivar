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

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
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

    } catch (SQLException e) {

        System.out.println(
                "Error checking username: "
                + e.getMessage()
        );
    }

    return false;
}


    public void addUser(User user) {

        String sql =
                "INSERT INTO users " +
                "(username, password) VALUES (?, ?)";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();

            System.out.println(
                    "User added successfully!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error adding user: "
                    + e.getMessage()
            );
        }
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            while (rs.next()) {

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

                users.add(user);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving users: "
                    + e.getMessage()
            );
        }

        return users;
    }

    public void updateUser(User user) {

        String sql =
                "UPDATE users SET " +
                "username = ?, password = ? " +
                "WHERE user_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUserId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User updated successfully!"
                );

            } else {

                System.out.println(
                        "User ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating user: "
                    + e.getMessage()
            );
        }
    }

    public void deleteUser(int userId) {

        String sql =
                "DELETE FROM users WHERE user_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User deleted successfully!"
                );

            } else {

                System.out.println(
                        "User ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting user: "
                    + e.getMessage()
            );
        }
    }
}