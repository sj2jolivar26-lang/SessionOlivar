package recordingapp.repository;

import recordingapp.database.DatabaseConnection;
import recordingapp.model.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    // CREATE
    public void addAlbum(Album album) {

        String sql =
                "INSERT INTO albums " +
                "(album_title, release_year, artist_id) " +
                "VALUES (?, ?, ?)";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, album.getAlbumTitle());
            stmt.setInt(2, album.getReleaseYear());
            stmt.setInt(3, album.getArtistId());

            stmt.executeUpdate();

            System.out.println("Album added successfully!");

        } catch (SQLException e) {

            System.out.println(
                    "Error adding album: "
                    + e.getMessage()
            );
        }
    }

    // READ
    public List<Album> getAllAlbums() {

        List<Album> albums = new ArrayList<>();

        String sql = "SELECT * FROM albums";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            while (rs.next()) {

                Album album = new Album();

                album.setAlbumId(
                        rs.getInt("album_id")
                );

                album.setAlbumTitle(
                        rs.getString("album_title")
                );

                album.setReleaseYear(
                        rs.getInt("release_year")
                );

                album.setArtistId(
                        rs.getInt("artist_id")
                );

                albums.add(album);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving albums: "
                    + e.getMessage()
            );
        }

        return albums;
    }

    // UPDATE
    public void updateAlbum(Album album) {

        String sql =
                "UPDATE albums SET " +
                "album_title = ?, " +
                "release_year = ?, " +
                "artist_id = ? " +
                "WHERE album_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, album.getAlbumTitle());
            stmt.setInt(2, album.getReleaseYear());
            stmt.setInt(3, album.getArtistId());
            stmt.setInt(4, album.getAlbumId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Album updated successfully!"
                );
            } else {
                System.out.println(
                        "Album ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating album: "
                    + e.getMessage()
            );
        }
    }

    // DELETE
    public void deleteAlbum(int albumId) {

        String sql =
                "DELETE FROM albums WHERE album_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setInt(1, albumId);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Album deleted successfully!"
                );
            } else {
                System.out.println(
                        "Album ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting album: "
                    + e.getMessage()
            );
        }
    }
}