package com.example.codenames.Model;

public class Player {
    private String playerID;
    private String teamID;
    private String name;
    private String role;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Player(String playerID, String teamID, String name, String role) {
        this.playerID = playerID;
        this.teamID = teamID;
        this.name = name;
        this.role = role;
    }
}
