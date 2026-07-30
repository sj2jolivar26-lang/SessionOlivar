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
import recordingapp.model.PlaylistSong;

import java.util.List;
import java.util.Scanner;

public class PlaylistSongView {

    private Scanner scanner =
            new Scanner(System.in);

    public int showMenu() {

        System.out.println();
        System.out.println(
                "===== PLAYLIST SONG MANAGEMENT ====="
        );

        System.out.println(
                "1. Add Song to Playlist"
        );

        System.out.println(
                "2. View Playlist Songs"
        );

        System.out.println(
                "3. Remove Song from Playlist"
        );

        System.out.println(
                "0. Back"
        );

        System.out.print(
                "Enter choice: "
        );

        return scanner.nextInt();
    }

    public PlaylistSong
            getPlaylistSongInput() {

        System.out.print(
                "Playlist ID: "
        );

        int playlistId =
                scanner.nextInt();

        System.out.print(
                "Song ID: "
        );

        int songId =
                scanner.nextInt();

        return new PlaylistSong(
                playlistId,
                songId
        );
    }

    public PlaylistSong
            getDeleteInput() {

        System.out.print(
                "Playlist ID: "
        );

        int playlistId =
                scanner.nextInt();

        System.out.print(
                "Song ID: "
        );

        int songId =
                scanner.nextInt();

        return new PlaylistSong(
                playlistId,
                songId
        );
    }

    public void displayPlaylistSongs(
            List<PlaylistSong> list) {

        System.out.println();

        System.out.println(
                "===== PLAYLIST SONGS ====="
        );

        for (PlaylistSong ps :
                list) {

            System.out.println(
                    "Playlist ID: "
                    + ps.getPlaylistId()
                    + " | Song ID: "
                    + ps.getSongId()
            );
        }
    }
}
