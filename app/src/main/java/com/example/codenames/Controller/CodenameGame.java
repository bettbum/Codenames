package com.example.codenames.Controller;

import com.example.codenames.Model.Game;
import com.example.codenames.Model.GameLog;
import com.example.codenames.Model.MapPlayer;


public class CodenameGame {
    private Game game;
    private GameLog log;
    private MapPlayer map;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameLog getLog() {
        return log;
    }

    public void setLog(GameLog log) {
        this.log = log;
    }

    public MapPlayer getMap() {
        return map;
    }

    public void setMap(MapPlayer map) {
        this.map = map;
    }

    public CodenameGame(Game game, GameLog log, MapPlayer map) {
        this.game = game;
        this.log = log;
        this.map = map;
    }
}
