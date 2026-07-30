/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.model;

/**
 *
 * @author Audit
 */


public class PlaylistSong {

    private int playlistId;
    private int songId;

    public PlaylistSong() {
    }

    public PlaylistSong(
            int playlistId,
            int songId) {

        this.playlistId =
                playlistId;

        this.songId =
                songId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(
            int playlistId) {

        this.playlistId =
                playlistId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(
            int songId) {

        this.songId =
                songId;
    }
}