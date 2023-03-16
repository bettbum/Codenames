package com.example.codenames.Controller;

import com.example.codenames.Model.Game;
import com.example.codenames.Model.GameLog;


public class CodenameGame {
    private Game game;
    private GameLog log;

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

    public CodenameGame(Game game, GameLog log) {
        this.game = game;
        this.log = log;
    }
}
