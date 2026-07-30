/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.service;

/**
 *
 * @author Audit
 */

import recordingapp.model.Song;
import recordingapp.repository.SongRepository;

import java.util.List;

public class SongService {

    private SongRepository repository;

    public SongService() {
        repository = new SongRepository();
    }

    public void addSong(Song song) {

        if (song.getSongTitle() == null ||
            song.getSongTitle().trim().isEmpty()) {

            System.out.println(
                    "Song title cannot be empty."
            );

            return;
        }

        repository.addSong(song);
    }

    public List<Song> getAllSongs() {

        return repository.getAllSongs();
    }

    public void updateSong(Song song) {

        repository.updateSong(song);
    }

    public void deleteSong(int songId) {

        repository.deleteSong(songId);
    }
}