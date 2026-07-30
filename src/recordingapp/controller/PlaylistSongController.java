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

import recordingapp.model.PlaylistSong;
import recordingapp.service.PlaylistSongService;
import recordingapp.view.PlaylistSongView;

public class PlaylistSongController {

    private PlaylistSongService service;
    private PlaylistSongView view;

    public PlaylistSongController() {

        service =
                new PlaylistSongService();

        view =
                new PlaylistSongView();
    }

    public void start() {

        int choice;

        do {

            choice =
                    view.showMenu();

            switch (choice) {

                case 1:

                    PlaylistSong ps =
                            view.getPlaylistSongInput();

                    service.addPlaylistSong(ps);

                    break;

                case 2:

                    view.displayPlaylistSongs(
                            service
                            .getAllPlaylistSongs()
                    );

                    break;

                case 3:

                    PlaylistSong delete =
                            view.getDeleteInput();

                    service.deletePlaylistSong(
                            delete.getPlaylistId(),
                            delete.getSongId()
                    );

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
}