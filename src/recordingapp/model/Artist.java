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

public class Artist {

    private int artistId;
    private String artistName;
    private String genre;

    public Artist() {
    }

    public Artist(int artistId, String artistName, String genre) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.genre = genre;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}