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
public class Album {

    private int albumId;
    private String albumTitle;
    private int releaseYear;
    private int artistId;

    public Album() {
    }

    public Album(int albumId, String albumTitle,
                 int releaseYear, int artistId) {

        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}