package com.example.codenames.Model;

public class Team {
    private String teamID;
    private String operative;
    private String spymaster;
    private String color;

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Team(String teamID, String operative, String spymaster, String color) {
        this.teamID = teamID;
        this.operative = operative;
        this.spymaster = spymaster;
        this.color = color;
    }
}
