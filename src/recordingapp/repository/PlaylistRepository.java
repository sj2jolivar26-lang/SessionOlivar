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
import recordingapp.model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {

    public void addPlaylist(Playlist playlist) {

        String sql =
                "INSERT INTO playlists " +
                "(playlist_name, user_id) VALUES (?, ?)";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(
                    1,
                    playlist.getPlaylistName()
            );

            stmt.setInt(
                    2,
                    playlist.getUserId()
            );

            stmt.executeUpdate();

            System.out.println(
                    "Playlist added successfully!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error adding playlist: "
                    + e.getMessage()
            );
        }
    }

    public List<Playlist> getAllPlaylists() {

        List<Playlist> playlists =
                new ArrayList<>();

        String sql =
                "SELECT * FROM playlists";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            while (rs.next()) {

                Playlist playlist =
                        new Playlist();

                playlist.setPlaylistId(
                        rs.getInt("playlist_id")
                );

                playlist.setPlaylistName(
                        rs.getString("playlist_name")
                );

                playlist.setUserId(
                        rs.getInt("user_id")
                );

                playlists.add(playlist);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error retrieving playlists: "
                    + e.getMessage()
            );
        }

        return playlists;
    }

    public void updatePlaylist(
            Playlist playlist) {

        String sql =
                "UPDATE playlists SET " +
                "playlist_name = ?, " +
                "user_id = ? " +
                "WHERE playlist_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(
                    1,
                    playlist.getPlaylistName()
            );

            stmt.setInt(
                    2,
                    playlist.getUserId()
            );

            stmt.setInt(
                    3,
                    playlist.getPlaylistId()
            );

            int rows =
                    stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Playlist updated successfully!"
                );

            } else {

                System.out.println(
                        "Playlist ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating playlist: "
                    + e.getMessage()
            );
        }
    }

    public void deletePlaylist(int playlistId) {

        String sql =
                "DELETE FROM playlists " +
                "WHERE playlist_id = ?";

        try (Connection conn =
                     DatabaseConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setInt(1, playlistId);

            int rows =
                    stmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Playlist deleted successfully!"
                );

            } else {

                System.out.println(
                        "Playlist ID not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting playlist: "
                    + e.getMessage()
            );
        }
    }
}