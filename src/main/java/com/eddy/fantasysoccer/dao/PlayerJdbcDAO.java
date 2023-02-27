package com.eddy.fantasysoccer.dao;

import com.eddy.fantasysoccer.model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerJdbcDAO implements PlayerDAO{
    private JdbcTemplate jdbcTemplate;

    public PlayerJdbcDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Player> getPlayers() {
        String sql = "SELECT a.player_name, team, \"nonpenalty_xG\", \"xA\",pos.position, \n" +
                "(\"nonpenalty_xG\"*points_per_goal)+(\"xA\"*points_per_assist)+2 as total_points\n" +
                "FROM advanced_stats a JOIN player_positions p ON a.player_name = p.player_name JOIN points_per_position pos ON p.fpl_position=pos.position\n" +
                "ORDER BY total_points DESC;";
        List<Player> players = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()){
            Player player = mapRowToPlayer(result);
            players.add(player);
        }
        return players;
    }

    @Override
    public List<Player> getPlayersByPosition(String position, int numOfPlayers) {
        String sql = "SELECT a.player_name, team, \"nonpenalty_xG\", \"xA\",pos.position, \n" +
                "(\"nonpenalty_xG\"*points_per_goal)+(\"xA\"*points_per_assist)+2 as total_points\n" +
                "FROM advanced_stats a JOIN player_positions p ON a.player_name = p.player_name JOIN points_per_position pos ON p.fpl_position=pos.position\n" +
                "WHERE pos.position=?\n" +
                "ORDER BY total_points DESC\n"+
                "LIMIT ?";
        List<Player> players = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, position, numOfPlayers);

        while(result.next()){
            Player player = mapRowToPlayer(result);
            players.add(player);
        }
        System.out.println(players.size());
        return players;
    }

    private static Player mapRowToPlayer(SqlRowSet result){
        Player player = new Player();
        player.setName(result.getString("player_name"));
        player.setTeam(result.getString("team"));
        player.setxG(result.getDouble("nonpenalty_xG"));
        player.setxA(result.getDouble("xA"));
        player.setTotalPoints(result.getDouble("total_points"));
        player.setPosition(result.getString("position"));

        return player;
    }

    @Override
    public Player getPlayer(String name) {
        return null;
    }
}
