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

import recordingapp.model.Song;
import recordingapp.service.SongService;
import recordingapp.view.SongView;

public class SongController {

    private SongService service;
    private SongView view;

    public SongController() {

        service = new SongService();
        view = new SongView();
    }

    public void start() {

        int choice;

        do {

            choice = view.showMenu();

            switch (choice) {

                case 1:
                    addSong();
                    break;

                case 2:
                    viewSongs();
                    break;

                case 3:
                    updateSong();
                    break;

                case 4:
                    deleteSong();
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

    private void addSong() {

        Song song =
                view.getSongInput();

        service.addSong(song);
    }

    private void viewSongs() {

        view.displaySongs(
                service.getAllSongs()
        );
    }

    private void updateSong() {

        Song song =
                view.getSongUpdateInput();

        service.updateSong(song);
    }

    private void deleteSong() {

        int id = view.getSongId();

        service.deleteSong(id);
    }
}