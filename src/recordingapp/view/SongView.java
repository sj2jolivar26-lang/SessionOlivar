/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.view;

import recordingapp.model.Song;

import java.util.List;
import java.util.Scanner;

public class SongView {

    private Scanner scanner =
            new Scanner(System.in);

    public int showMenu() {

        System.out.println();
        System.out.println(
                "===== SONG MANAGEMENT ====="
        );

        System.out.println("1. Add Song");
        System.out.println("2. View Songs");
        System.out.println("3. Update Song");
        System.out.println("4. Delete Song");
        System.out.println("0. Back");

        System.out.print("Enter choice: ");

        return scanner.nextInt();
    }

    public Song getSongInput() {

        scanner.nextLine();

        System.out.print("Song Title: ");
        String title = scanner.nextLine();

        System.out.print("Duration: ");
        String duration = scanner.nextLine();

        System.out.print("Album ID: ");
        int albumId = scanner.nextInt();

        System.out.print("Artist ID: ");
        int artistId = scanner.nextInt();

        return new Song(
                0,
                title,
                duration,
                albumId,
                artistId
        );
    }

    public Song getSongUpdateInput() {

        System.out.print("Song ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("New Song Title: ");
        String title = scanner.nextLine();

        System.out.print("New Duration: ");
        String duration = scanner.nextLine();

        System.out.print("New Album ID: ");
        int albumId = scanner.nextInt();

        System.out.print("New Artist ID: ");
        int artistId = scanner.nextInt();

        return new Song(
                id,
                title,
                duration,
                albumId,
                artistId
        );
    }

    public int getSongId() {

        System.out.print("Enter Song ID: ");

        return scanner.nextInt();
    }

    public void displaySongs(List<Song> songs) {

        System.out.println();
        System.out.println("===== SONGS =====");

        for (Song song : songs) {

            System.out.println(
                    song.getSongId()
                    + " | "
                    + song.getSongTitle()
                    + " | "
                    + song.getDuration()
                    + " | Album ID: "
                    + song.getAlbumId()
                    + " | Artist ID: "
                    + song.getArtistId()
            );
        }
    }
}