package com.example.codenames.Model;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;

public class Player {
    private int playerID;
    private TeamType teamID;
    private String name;
    private Roles role;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
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

    public Player(int playerID, String name) {
        this.playerID = playerID;
        this.teamID = null;
        this.name = name;
        this.role = null;
    }
}
