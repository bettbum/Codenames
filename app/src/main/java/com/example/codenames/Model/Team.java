package com.example.codenames.Model;

import android.graphics.Color;

import com.example.codenames.Model.Enum.TeamType;

public class Team {
    private TeamType teamID;
    private String operative;
    private String spymaster;
    private Color color;

    public TeamType getTeamID() {
        return teamID;
    }

    public void setTeamID(TeamType teamID) {
        this.teamID = teamID;
    }

    public String getOperative() {
        return operative;
    }

    public void setOperative(String operative) {
        this.operative = operative;
    }

    public String getSpymaster() {
        return spymaster;
    }

    public void setSpymaster(String spymaster) {
        this.spymaster = spymaster;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Team(TeamType teamID, String operative, String spymaster, Color color) {
        this.teamID = teamID;
        this.operative = operative;
        this.spymaster = spymaster;
        this.color = color;
    }
}
