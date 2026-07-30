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


import recordingapp.model.Playlist;
import recordingapp.service.PlaylistService;
import recordingapp.view.PlaylistView;

public class PlaylistController {

    private PlaylistService service;
    private PlaylistView view;

    public PlaylistController() {

        service =
                new PlaylistService();

        view =
                new PlaylistView();
    }

    public void start() {

        int choice;

        do {

            choice =
                    view.showMenu();

            switch (choice) {

                case 1:
                    addPlaylist();
                    break;

                case 2:
                    viewPlaylists();
                    break;

                case 3:
                    updatePlaylist();
                    break;

                case 4:
                    deletePlaylist();
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

    private void addPlaylist() {

        Playlist playlist =
                view.getPlaylistInput();

        service.addPlaylist(
                playlist
        );
    }

    private void viewPlaylists() {

        view.displayPlaylists(
                service.getAllPlaylists()
        );
    }

    private void updatePlaylist() {

        Playlist playlist =
                view.getPlaylistUpdateInput();

        service.updatePlaylist(
                playlist
        );
    }

    private void deletePlaylist() {

        int id =
                view.getPlaylistId();

        service.deletePlaylist(id);
    }
}