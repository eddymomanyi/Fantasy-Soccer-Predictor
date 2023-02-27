package com.eddy.fantasysoccer.controller;


import com.eddy.fantasysoccer.dao.PlayerDAO;
import com.eddy.fantasysoccer.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AppController {
    @Autowired
    PlayerDAO dao;

    @RequestMapping(path="/players", method= RequestMethod.GET)
    public List<Player> getPlayers(@RequestParam(required = false) String pos, @RequestParam(defaultValue = "10") int limit){
        if(pos!=null) {
            return dao.getPlayersByPosition(pos.toUpperCase(), limit);
        }
        return dao.getPlayers();

    }


}
