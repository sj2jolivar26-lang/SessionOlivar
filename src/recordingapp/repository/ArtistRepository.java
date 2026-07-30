/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.repository;

import recordingapp.database.DatabaseConnection;
import recordingapp.model.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    // =========================
    // CREATE
    // =========================
    public void addArtist(Artist artist) {

        String sql = "INSERT INTO artists (artist_name, genre) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, artist.getArtistName());
            stmt.setString(2, artist.getGenre());

            stmt.executeUpdate();

            System.out.println("Artist added successfully!");

        } catch (SQLException e) {

            System.out.println("Error adding artist: " + e.getMessage());
        }
    }

    // =========================
    // READ
    // =========================
    public List<Artist> getAllArtists() {

        List<Artist> artists = new ArrayList<>();

        String sql = "SELECT * FROM artists";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Artist artist = new Artist();

                artist.setArtistId(
                        rs.getInt("artist_id")
                );

                artist.setArtistName(
                        rs.getString("artist_name")
                );

                artist.setGenre(
                        rs.getString("genre")
                );

                artists.add(artist);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving artists: "
                    + e.getMessage()
            );
        }

        return artists;
    }

    // =========================
    // UPDATE
    // =========================
    public void updateArtist(Artist artist) {

        String sql =
                "UPDATE artists " +
                "SET artist_name = ?, genre = ? " +
                "WHERE artist_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, artist.getArtistName());
            stmt.setString(2, artist.getGenre());
            stmt.setInt(3, artist.getArtistId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Artist updated successfully!"
                );

            } else {

                System.out.println(
                        "Artist ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating artist: "
                    + e.getMessage()
            );
        }
    }

    // =========================
    // DELETE
    // =========================
    public void deleteArtist(int artistId) {

        String sql =
                "DELETE FROM artists WHERE artist_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, artistId);

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Artist deleted successfully!"
                );

            } else {

                System.out.println(
                        "Artist ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting artist: "
                    + e.getMessage()
            );
        }
    }
}