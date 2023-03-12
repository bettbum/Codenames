package com.example.codenames.Model;

public class Game {
    private String mapID;
    private Boolean isStarted;
    private Team teamRed;
    private Team teamBlue;
    private Team winner;

    public String getMapID() {
        return mapID;
    }

    public void setMapID(String mapID) {
        this.mapID = mapID;
    }

    public Boolean getStarted() {
        return isStarted;
    }

    public void setStarted(Boolean started) {
        isStarted = started;
    }

    public Team getTeamRed() {
        return teamRed;
    }

    public void setTeamRed(Team teamRed) {
        this.teamRed = teamRed;
    }

    public Team getTeamBlue() {
        return teamBlue;
    }

    public void setTeamBlue(Team teamBlue) {
        this.teamBlue = teamBlue;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public Game(String mapID, Boolean isStarted, Team teamRed, Team teamBlue, Team winner) {
        this.mapID = mapID;
        this.isStarted = isStarted;
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
        this.winner = winner;
    }
}
