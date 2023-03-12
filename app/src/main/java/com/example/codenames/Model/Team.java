package com.example.codenames.Model;

import android.graphics.Color;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;

public class Team {
    private TeamType teamID;
    private Player operative;
    private Player spymaster;
    private Color color;

    public TeamType getTeamID() {
        return teamID;
    }

    public void joinTeam(TeamType teamID) {
        this.teamID = teamID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Team(TeamType teamID, Player operative, Player spymaster, Color color) {
        this.teamID = teamID;
        this.operative = operative;
        this.spymaster = spymaster;
        this.color = color;
        this.operative.setRole(Roles.operative);
        this.spymaster.setRole(Roles.spymaster);
    }
}
