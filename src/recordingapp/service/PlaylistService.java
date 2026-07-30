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

import recordingapp.model.Playlist;
import recordingapp.repository.PlaylistRepository;

import java.util.List;

public class PlaylistService {

    private PlaylistRepository repository;

    public PlaylistService() {
        repository =
                new PlaylistRepository();
    }

    public void addPlaylist(
            Playlist playlist) {

        if (playlist.getPlaylistName() == null ||
            playlist.getPlaylistName()
                    .trim()
                    .isEmpty()) {

            System.out.println(
                    "Playlist name cannot be empty."
            );

            return;
        }

        repository.addPlaylist(playlist);
    }

    public List<Playlist> getAllPlaylists() {

        return repository.getAllPlaylists();
    }

    public void updatePlaylist(
            Playlist playlist) {

        repository.updatePlaylist(playlist);
    }

    public void deletePlaylist(
            int playlistId) {

        repository.deletePlaylist(
                playlistId
        );
    }
}