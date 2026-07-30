/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recordingapp.repository;

/**
 *
 * @author Audit
 */

import recordingapp.database.DatabaseConnection;
import recordingapp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    // CREATE
    public void addSong(Song song) {

        String sql =
                "INSERT INTO songs " +
                "(song_title, duration, album_id, artist_id) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, song.getSongTitle());
            stmt.setString(2, song.getDuration());
            stmt.setInt(3, song.getAlbumId());
            stmt.setInt(4, song.getArtistId());

            stmt.executeUpdate();

            System.out.println(
                    "Song added successfully!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error adding song: "
                    + e.getMessage()
            );
        }
    }

    // READ
    public List<Song> getAllSongs() {

        List<Song> songs = new ArrayList<>();

        String sql = "SELECT * FROM songs";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            while (rs.next()) {

                Song song = new Song();

                song.setSongId(
                        rs.getInt("song_id")
                );

                song.setSongTitle(
                        rs.getString("song_title")
                );

                song.setDuration(
                        rs.getString("duration")
                );

                song.setAlbumId(
                        rs.getInt("album_id")
                );

                song.setArtistId(
                        rs.getInt("artist_id")
                );

                songs.add(song);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving songs: "
                    + e.getMessage()
            );
        }

        return songs;
    }

    // UPDATE
    public void updateSong(Song song) {

        String sql =
                "UPDATE songs SET " +
                "song_title = ?, " +
                "duration = ?, " +
                "album_id = ?, " +
                "artist_id = ? " +
                "WHERE song_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, song.getSongTitle());
            stmt.setString(2, song.getDuration());
            stmt.setInt(3, song.getAlbumId());
            stmt.setInt(4, song.getArtistId());
            stmt.setInt(5, song.getSongId());

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Song updated successfully!"
                );

            } else {

                System.out.println(
                        "Song ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating song: "
                    + e.getMessage()
            );
        }
    }

    // DELETE
    public void deleteSong(int songId) {

        String sql =
                "DELETE FROM songs WHERE song_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setInt(1, songId);

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Song deleted successfully!"
                );

            } else {

                System.out.println(
                        "Song ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting song: "
                    + e.getMessage()
            );
        }
    }
}