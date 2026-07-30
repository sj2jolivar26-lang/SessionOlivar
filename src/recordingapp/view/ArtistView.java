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

import recordingapp.model.Artist;

import java.util.List;
import java.util.Scanner;

public class ArtistView {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {

        System.out.println();
        System.out.println("===== ARTIST MANAGEMENT =====");
        System.out.println("1. Add Artist");
        System.out.println("2. View Artists");
        System.out.println("3. Update Artist");
        System.out.println("4. Delete Artist");
        System.out.println("0. Back");

        System.out.print("Enter choice: ");

        return scanner.nextInt();
    }

    public Artist getArtistInput() {

        scanner.nextLine();

        System.out.print("Artist Name: ");
        String name = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        return new Artist(0, name, genre);
    }

    public Artist getArtistUpdateInput() {

        System.out.print("Artist ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("New Artist Name: ");
        String name = scanner.nextLine();

        System.out.print("New Genre: ");
        String genre = scanner.nextLine();

        return new Artist(id, name, genre);
    }

    public int getArtistId() {

        System.out.print("Enter Artist ID: ");

        return scanner.nextInt();
    }

    public void displayArtists(List<Artist> artists) {

        System.out.println();
        System.out.println("===== ARTISTS =====");

        for (Artist artist : artists) {

            System.out.println(
                    artist.getArtistId()
                    + " | "
                    + artist.getArtistName()
                    + " | "
                    + artist.getGenre()
            );
        }
    }
}