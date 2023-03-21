package com.example.codenames.Model;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;

import java.util.UUID;

public class Player {
    private String playerID;
    private TeamType teamID;
    //private String name;
    private Roles role;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public TeamType getTeamID() {
        return teamID;
    }

    public void setTeamID(TeamType teamID) {
        this.teamID = teamID;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Player(String playerID, TeamType team, Roles role) {
        this.playerID = playerID;
        this.teamID = team;
        this.role = role;
    }
    public Player(){
        this.playerID = UUID.randomUUID().toString();
    }
}
