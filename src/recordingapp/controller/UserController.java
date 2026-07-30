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

import recordingapp.model.User;

import java.util.Scanner;

import recordingapp.model.Song;
import recordingapp.service.SongService;

import java.util.List;

public class UserController {

    private Scanner scanner;
    private User loggedInUser;

    private SongController songController;
    private PlaylistController playlistController;
    private PlaylistSongController
            playlistSongController;

    public UserController(
            Scanner scanner,
            User user) {

        this.scanner = scanner;
        this.loggedInUser = user;

        songController =
                new SongController();

        playlistController =
                new PlaylistController();

        playlistSongController =
                new PlaylistSongController();
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "           USER DASHBOARD"
            );

            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "Welcome, "
                    + loggedInUser.getUsername()
            );

            System.out.println();

            System.out.println(
                    "1. Browse Songs"
            );

            System.out.println(
                    "2. Search Songs"
            );

            System.out.println(
                    "3. Create Playlist"
            );

            System.out.println(
                    "4. View Playlists"
            );

            System.out.println(
                    "5. Edit Playlist"
            );

            System.out.println(
                    "6. Delete Playlist"
            );

            System.out.println(
                    "7. Manage Playlist Songs"
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

                    browseSongs();

                    break;

                case "2":

                    searchSongs();

                    break;

                case "3":

                    createPlaylist();

                    break;

                case "4":

                    viewPlaylists();

                    break;

                case "5":

                    editPlaylist();

                    break;

                case "6":

                    deletePlaylist();

                    break;

                case "7":

                    playlistSongs();

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

    private void browseSongs() {

        System.out.println();
        System.out.println(
                "===== AVAILABLE SONGS ====="
        );

        songController.start();
    }

    private void searchSongs() {

    System.out.println();
    System.out.println(
            "===== SONG SEARCH ====="
    );

    System.out.print(
            "Enter song title: "
    );

    String keyword =
            scanner.nextLine();

    SongService service =
            new SongService();

    List<Song> results =
            service.searchSongs(
                    keyword
            );

    if (results.isEmpty()) {

        System.out.println(
                "No songs found."
        );

    } else {

        System.out.println();
        System.out.println(
                "===== SEARCH RESULTS ====="
        );

        for (Song song : results) {

            System.out.println(
                    song.getSongId()
                    + " | "
                    + song.getSongTitle()
                    + " | "
                    + song.getDuration()
            );
        }
    }
}

    private void createPlaylist() {

        System.out.println();
        System.out.println(
                "===== CREATE PLAYLIST ====="
        );

        System.out.print(
                "Playlist Name: "
        );

        String name =
                scanner.nextLine();

        System.out.println(
                "Playlist '"
                + name
                + "' created."
        );

        // Playlist creation
        // should use loggedInUser.getUserId()
    }

    private void viewPlaylists() {

        System.out.println();
        System.out.println(
                "===== MY PLAYLISTS ====="
        );

        playlistController.start();
    }

    private void editPlaylist() {

        System.out.println();
        System.out.println(
                "===== EDIT PLAYLIST ====="
        );

        playlistController.start();
    }

    private void deletePlaylist() {

        System.out.println();
        System.out.println(
                "===== DELETE PLAYLIST ====="
        );

        playlistController.start();
    }

    private void playlistSongs() {

        System.out.println();
        System.out.println(
                "===== PLAYLIST SONGS ====="
        );

        playlistSongController.start();
    }
}