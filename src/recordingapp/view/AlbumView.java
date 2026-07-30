package recordingapp.view;

import recordingapp.model.Album;

import java.util.List;
import java.util.Scanner;

public class AlbumView {

    private Scanner scanner =
            new Scanner(System.in);

    public int showMenu() {

        System.out.println();
        System.out.println(
                "===== ALBUM MANAGEMENT ====="
        );

        System.out.println("1. Add Album");
        System.out.println("2. View Albums");
        System.out.println("3. Update Album");
        System.out.println("4. Delete Album");
        System.out.println("0. Back");

        System.out.print("Enter choice: ");

        return scanner.nextInt();
    }

    public Album getAlbumInput() {

        scanner.nextLine();

        System.out.print("Album Title: ");
        String title = scanner.nextLine();

        System.out.print("Release Year: ");
        int year = scanner.nextInt();

        System.out.print("Artist ID: ");
        int artistId = scanner.nextInt();

        return new Album(
                0,
                title,
                year,
                artistId
        );
    }

    public Album getAlbumUpdateInput() {

        System.out.print("Album ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("New Album Title: ");
        String title = scanner.nextLine();

        System.out.print("New Release Year: ");
        int year = scanner.nextInt();

        System.out.print("New Artist ID: ");
        int artistId = scanner.nextInt();

        return new Album(
                id,
                title,
                year,
                artistId
        );
    }

    public int getAlbumId() {

        System.out.print("Enter Album ID: ");

        return scanner.nextInt();
    }

    public void displayAlbums(List<Album> albums) {

        System.out.println();
        System.out.println("===== ALBUMS =====");

        for (Album album : albums) {

            System.out.println(
                    album.getAlbumId()
                    + " | "
                    + album.getAlbumTitle()
                    + " | "
                    + album.getReleaseYear()
                    + " | Artist ID: "
                    + album.getArtistId()
            );
        }
    }
}