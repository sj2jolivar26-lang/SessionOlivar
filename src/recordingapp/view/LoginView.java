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

import java.util.Scanner;

public class LoginView {

    private Scanner scanner;

    public LoginView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUsername() {

        System.out.print("Username: ");

        return scanner.nextLine();
    }

    public String getPassword() {

        System.out.print("Password: ");

        return scanner.nextLine();
    }

    public void showLoginSuccess() {

        System.out.println();
        System.out.println(
                "Login successful!"
        );
    }

    public void showLoginFailed() {

        System.out.println();
        System.out.println(
                "Invalid username or password."
        );
    }
}