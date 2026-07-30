/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.main;

/**
 *
 * @author Audit
 */


import recordingapp.controller.AdminController;
import recordingapp.controller.UserController;
import recordingapp.model.User;
import recordingapp.service.LoginService;
import recordingapp.service.UserService;
import recordingapp.view.LoginView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        LoginService loginService =
                new LoginService();

        UserService userService =
                new UserService();

        LoginView loginView =
                new LoginView(scanner);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "       MUSIC RECORDING SYSTEM"
            );

            System.out.println(
                    "======================================"
            );

            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");

            System.out.print(
                    "Enter choice: "
            );

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    User loggedIn =
                            login(
                                    loginService,
                                    loginView
                            );

                    if (loggedIn != null) {

                        if (loggedIn
                                .getAccountType()
                                .equalsIgnoreCase("ADMIN")) {

                            AdminController admin =
                                    new AdminController(
                                            scanner
                                    );

                            admin.start();

                        } else {

                            UserController user =
                                    new UserController(
                                            scanner,
                                            loggedIn
                                    );

                            user.start();
                        }
                    }

                    break;

                case "2":

                    register(
                            scanner,
                            userService
                    );

                    break;

                case "0":

                    running = false;

                    System.out.println(
                            "Thank you for using the system!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        scanner.close();
    }

    private static User login(
            LoginService service,
            LoginView view) {

        System.out.println();
        System.out.println(
                "===== LOGIN ====="
        );

        String username =
                view.getUsername();

        String password =
                view.getPassword();

        User user =
                service.login(
                        username,
                        password
                );

        if (user == null) {

            view.showLoginFailed();

        } else {

            view.showLoginSuccess();

            System.out.println(
                    "Welcome, "
                    + user.getUsername()
                    + "!"
            );
        }

        return user;
    }

    private static void register(
            Scanner scanner,
            UserService service) {

        System.out.println();
        System.out.println(
                "===== USER REGISTRATION ====="
        );

        System.out.print(
                "Username: "
        );

        String username =
                scanner.nextLine();

        System.out.print(
                "Password: "
        );

        String password =
                scanner.nextLine();

        boolean success =
                service.registerUser(
                        username,
                        password
                );

        if (success) {

            System.out.println(
                    "Registration successful!"
            );
        }
    }
}