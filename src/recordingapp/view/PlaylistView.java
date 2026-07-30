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

import recordingapp.model.Playlist;

import java.util.List;
import java.util.Scanner;

public class PlaylistView {

    private Scanner scanner =
            new Scanner(System.in);

    public int showMenu() {

        System.out.println();
        System.out.println(
                "===== PLAYLIST MANAGEMENT ====="
        );

        System.out.println("1. Add Playlist");
        System.out.println("2. View Playlists");
        System.out.println("3. Update Playlist");
        System.out.println("4. Delete Playlist");
        System.out.println("0. Back");

        System.out.print("Enter choice: ");

        return scanner.nextInt();
    }

    public Playlist getPlaylistInput() {

        scanner.nextLine();

        System.out.print("Playlist Name: ");

        String name =
                scanner.nextLine();

        System.out.print("User ID: ");

        int userId =
                scanner.nextInt();

        return new Playlist(
                0,
                name,
                userId
        );
    }

    public Playlist getPlaylistUpdateInput() {

        System.out.print("Playlist ID: ");

        int id =
                scanner.nextInt();

        scanner.nextLine();

        System.out.print("New Playlist Name: ");

        String name =
                scanner.nextLine();

        System.out.print("New User ID: ");

        int userId =
                scanner.nextInt();

        return new Playlist(
                id,
                name,
                userId
        );
    }

    public int getPlaylistId() {

        System.out.print(
                "Enter Playlist ID: "
        );

        return scanner.nextInt();
    }

    public void displayPlaylists(
            List<Playlist> playlists) {

        System.out.println();
        System.out.println(
                "===== PLAYLISTS ====="
        );

        for (Playlist playlist :
                playlists) {

            System.out.println(
                    playlist.getPlaylistId()
                    + " | "
                    + playlist.getPlaylistName()
                    + " | User ID: "
                    + playlist.getUserId()
            );
        }
    }
}