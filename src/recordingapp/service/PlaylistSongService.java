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

import recordingapp.model.PlaylistSong;
import recordingapp.repository.PlaylistSongRepository;

import java.util.List;

public class PlaylistSongService {

    private PlaylistSongRepository repository;

    public PlaylistSongService() {

        repository =
                new PlaylistSongRepository();
    }

    public void addPlaylistSong(
            PlaylistSong ps) {

        repository.addPlaylistSong(ps);
    }

    public List<PlaylistSong>
            getAllPlaylistSongs() {

        return repository.getAllPlaylistSongs();
    }

    public void deletePlaylistSong(
            int playlistId,
            int songId) {

        repository.deletePlaylistSong(
                playlistId,
                songId
        );
    }
}