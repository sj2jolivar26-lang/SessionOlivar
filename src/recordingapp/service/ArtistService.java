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

import recordingapp.model.Artist;
import recordingapp.repository.ArtistRepository;

import java.util.List;

public class ArtistService {

    private ArtistRepository repository;

    public ArtistService() {
        repository = new ArtistRepository();
    }

    public void addArtist(Artist artist) {

        if (artist.getArtistName() == null ||
            artist.getArtistName().trim().isEmpty()) {

            System.out.println("Artist name cannot be empty.");
            return;
        }

        if (artist.getGenre() == null ||
            artist.getGenre().trim().isEmpty()) {

            System.out.println("Genre cannot be empty.");
            return;
        }

        repository.addArtist(artist);
    }

    public List<Artist> getAllArtists() {
        return repository.getAllArtists();
    }

    public void updateArtist(Artist artist) {
        repository.updateArtist(artist);
    }

    public void deleteArtist(int artistId) {

        if (artistId <= 0) {
            System.out.println("Invalid Artist ID.");
            return;
        }

        repository.deleteArtist(artistId);
    }
}