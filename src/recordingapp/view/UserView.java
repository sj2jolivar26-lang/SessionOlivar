/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.view;

/**
 *
 * @author Audit
 */

import recordingapp.model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private Scanner scanner =
            new Scanner(System.in);

    public int showMenu() {

        System.out.println();
        System.out.println(
                "===== USER MANAGEMENT ====="
        );

        System.out.println("1. Add User");
        System.out.println("2. View Users");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("0. Back");

        System.out.print("Enter choice: ");

        return scanner.nextInt();
    }

    public User getUserInput() {

        scanner.nextLine();

        System.out.print("Username: ");
        String username =
                scanner.nextLine();

        System.out.print("Password: ");
        String password =
                scanner.nextLine();

        return new User(
                0,
                username,
                password
        );
    }

    public User getUserUpdateInput() {

        System.out.print("User ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("New Username: ");
        String username =
                scanner.nextLine();

        System.out.print("New Password: ");
        String password =
                scanner.nextLine();

        return new User(
                id,
                username,
                password
        );
    }

    public int getUserId() {

        System.out.print("Enter User ID: ");

        return scanner.nextInt();
    }

    public void displayUsers(List<User> users) {

        System.out.println();
        System.out.println("===== USERS =====");

        for (User user : users) {

            System.out.println(
                    user.getUserId()
                    + " | "
                    + user.getUsername()
            );
        }
    }
}