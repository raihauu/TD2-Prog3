package org.example;

import jdk.internal.icu.text.UTF16;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private Connection getConnection() throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/mini_football_db";
        String PASSWORD = "postgres";
        String USER = "postgres";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Player> getPlayers() throws SQLException {

        List<Player> players = new ArrayList<>();

        String sql = "SELECT id, name, age, position, id_team, goal_nb FROM Player";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Integer goalNb = rs.getObject("goal_nb", Integer.class);

                UTF16 PositionEnum = null;
                Player player = new Player(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        PlayerPositionEnum.valueOf(UTF16.valueOf(Integer.parseInt(rs.getString("position")))),
                        rs.getObject("id_team", Team.class),
                        goalNb
                );

                players.add(player);
            }
        }

        return players;
    }

    public void updatePlayerGoals(Player player) throws SQLException {

        String sql = "UPDATE Player SET goal_nb = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (player.getGoalNb() == null) {
                stmt.setNull(1, Types.INTEGER);
            } else {
                stmt.setInt(1, player.getGoalNb());
            }

            stmt.setInt(2, player.getId());
            stmt.executeUpdate();
        }
    }
    }