/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.controller;

/**
 *
 * @author Audit
 */

import java.util.Scanner;

public class AdminController {

    private Scanner scanner;

    private ArtistController artistController;
    private AlbumController albumController;
    private SongController songController;

    public AdminController(
            Scanner scanner) {

        this.scanner = scanner;

        artistController =
                new ArtistController();

        albumController =
                new AlbumController();

        songController =
                new SongController();
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "          ADMIN DASHBOARD"
            );

            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "1. Manage Artists"
            );

            System.out.println(
                    "2. Manage Albums"
            );

            System.out.println(
                    "3. Manage Songs"
            );

            System.out.println(
                    "0. Logout"
            );

            System.out.print(
                    "Enter choice: "
            );

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    artistController.start();

                    break;

                case "2":

                    albumController.start();

                    break;

                case "3":

                    songController.start();

                    break;

                case "0":

                    running = false;

                    System.out.println(
                            "Logged out successfully."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }
}