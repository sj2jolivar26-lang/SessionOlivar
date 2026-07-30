/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.controller;

import recordingapp.model.Album;
import recordingapp.service.AlbumService;
import recordingapp.view.AlbumView;

public class AlbumController {

    private AlbumService service;
    private AlbumView view;

    public AlbumController() {

        service = new AlbumService();
        view = new AlbumView();
    }

    public void start() {

        int choice;

        do {

            choice = view.showMenu();

            switch (choice) {

                case 1:
                    addAlbum();
                    break;

                case 2:
                    viewAlbums();
                    break;

                case 3:
                    updateAlbum();
                    break;

                case 4:
                    deleteAlbum();
                    break;

                case 0:
                    System.out.println(
                            "Returning to main menu..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 0);
    }

    private void addAlbum() {

        Album album =
                view.getAlbumInput();

        service.addAlbum(album);
    }

    private void viewAlbums() {

        view.displayAlbums(
                service.getAllAlbums()
        );
    }

    private void updateAlbum() {

        Album album =
                view.getAlbumUpdateInput();

        service.updateAlbum(album);
    }

    private void deleteAlbum() {

        int id = view.getAlbumId();

        service.deleteAlbum(id);
    }
}