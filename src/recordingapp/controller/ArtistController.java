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

import recordingapp.model.Artist;
import recordingapp.service.ArtistService;
import recordingapp.view.ArtistView;

public class ArtistController {

    private ArtistService service;
    private ArtistView view;

    public ArtistController() {
        service = new ArtistService();
        view = new ArtistView();
    }

    public void start() {

        int choice;

        do {

            choice = view.showMenu();

            switch (choice) {

                case 1:
                    addArtist();
                    break;

                case 2:
                    viewArtists();
                    break;

                case 3:
                    updateArtist();
                    break;

                case 4:
                    deleteArtist();
                    break;

                case 0:
                    System.out.println(
                            "Returning to main menu...");
                    break;

                default:
                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 0);
    }

    private void addArtist() {

        Artist artist = view.getArtistInput();

        service.addArtist(artist);
    }

    private void viewArtists() {

        view.displayArtists(
                service.getAllArtists());
    }

    private void updateArtist() {

        Artist artist = view.getArtistUpdateInput();

        service.updateArtist(artist);
    }

    private void deleteArtist() {

        int id = view.getArtistId();

        service.deleteArtist(id);
    }
}