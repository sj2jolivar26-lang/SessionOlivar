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

public class Song {

    private int songId;
    private String songTitle;
    private String duration;
    private int albumId;
    private int artistId;

    public Song() {
    }

    public Song(
            int songId,
            String songTitle,
            String duration,
            int albumId,
            int artistId) {

        this.songId = songId;
        this.songTitle = songTitle;
        this.duration = duration;
        this.albumId = albumId;
        this.artistId = artistId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}