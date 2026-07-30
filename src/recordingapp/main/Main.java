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

import java.util.Scanner;

import recordingapp.controller.ArtistController;
import recordingapp.controller.AlbumController;
import recordingapp.controller.SongController;
import recordingapp.controller.UserController;
import recordingapp.controller.PlaylistController;
import recordingapp.controller.PlaylistSongController;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        ArtistController artistController =
                new ArtistController();

        AlbumController albumController =
                new AlbumController();

        SongController songController =
                new SongController();

        UserController userController =
                new UserController();

        PlaylistController playlistController =
                new PlaylistController();

        PlaylistSongController
                playlistSongController =
                new PlaylistSongController();

        int choice;

        do {

            System.out.println();
            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "       MUSIC RECORDING SYSTEM"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Artist Management"
            );

            System.out.println(
                    "2. Album Management"
            );

            System.out.println(
                    "3. Song Management"
            );

            System.out.println(
                    "4. User Management"
            );

            System.out.println(
                    "5. Playlist Management"
            );

            System.out.println(
                    "6. Playlist Songs"
            );

            System.out.println(
                    "0. Exit"
            );

            System.out.print(
                    "Enter choice: "
            );

            choice =
                    scanner.nextInt();

            switch (choice) {

                case 1:

                    artistController.start();

                    break;

                case 2:

                    albumController.start();

                    break;

                case 3:

                    songController.start();

                    break;

                case 4:

                    userController.start();

                    break;

                case 5:

                    playlistController.start();

                    break;

                case 6:

                    playlistSongController.start();

                    break;

                case 0:

                    System.out.println(
                            "Thank you for using the system!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}