package recordingapp.service;

import recordingapp.model.Album;
import recordingapp.repository.AlbumRepository;

import java.util.List;

public class AlbumService {

    private AlbumRepository repository;

    public AlbumService() {
        repository = new AlbumRepository();
    }

    public void addAlbum(Album album) {

        if (album.getAlbumTitle() == null ||
            album.getAlbumTitle().trim().isEmpty()) {

            System.out.println(
                    "Album title cannot be empty."
            );
            return;
        }

        repository.addAlbum(album);
    }

    public List<Album> getAllAlbums() {

        return repository.getAllAlbums();
    }

    public void updateAlbum(Album album) {

        repository.updateAlbum(album);
    }

    public void deleteAlbum(int albumId) {

        repository.deleteAlbum(albumId);
    }
}