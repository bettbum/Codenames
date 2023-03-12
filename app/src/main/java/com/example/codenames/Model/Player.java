package com.example.codenames.Model;

public class Player {
    private PlayerType playerID;
    private TeamType teamID;
    private String name;
    private Roles role;

    public PlayerType getPlayerID() {
        return playerID;
    }

    public void setPlayerID(PlayerType playerID) {
        this.playerID = playerID;
    }

    public TeamType getTeamID() {
        return teamID;
    }

    public void setTeamID(TeamType teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Player(PlayerType playerID, TeamType teamID, String name, Roles role) {
        this.playerID = playerID;
        this.teamID = teamID;
        this.name = name;
        this.role = role;
    }
}
