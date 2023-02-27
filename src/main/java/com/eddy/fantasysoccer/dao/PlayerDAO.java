package com.eddy.fantasysoccer.dao;

import com.eddy.fantasysoccer.model.Player;

import java.util.List;

public interface PlayerDAO {

    public List<Player> getPlayers();

   public List<Player> getPlayersByPosition(String position, int numOfPlayers);
    public Player getPlayer(String name);


}
