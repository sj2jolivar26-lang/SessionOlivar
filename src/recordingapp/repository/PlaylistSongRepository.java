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
import recordingapp.model.PlaylistSong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistSongRepository {

    // CREATE
    public void addPlaylistSong(
            PlaylistSong ps) {

        String sql =
                "INSERT INTO playlist_songs " +
                "(playlist_id, song_id) " +
                "VALUES (?, ?)";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setInt(
                    1,
                    ps.getPlaylistId()
            );

            stmt.setInt(
                    2,
                    ps.getSongId()
            );

            stmt.executeUpdate();

            System.out.println(
                    "Song added to playlist!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error adding song to playlist: "
                    + e.getMessage()
            );
        }
    }

    // READ
    public List<PlaylistSong>
            getAllPlaylistSongs() {

        List<PlaylistSong> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM playlist_songs";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            while (rs.next()) {

                PlaylistSong ps =
                        new PlaylistSong();

                ps.setPlaylistId(
                        rs.getInt("playlist_id")
                );

                ps.setSongId(
                        rs.getInt("song_id")
                );

                list.add(ps);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving playlist songs: "
                    + e.getMessage()
            );
        }

        return list;
    }

    // DELETE
    public void deletePlaylistSong(
            int playlistId,
            int songId) {

        String sql =
                "DELETE FROM playlist_songs " +
                "WHERE playlist_id = ? " +
                "AND song_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setInt(1, playlistId);
            stmt.setInt(2, songId);

            int rows =
                    stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Song removed from playlist!"
                );

            } else {

                System.out.println(
                        "Playlist-song relationship not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error removing song: "
                    + e.getMessage()
            );
        }
    }
}
