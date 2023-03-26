package com.example.codenames.Model;

import com.example.codenames.Model.Enum.TeamType;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Game {
    private String mapID;
    private Boolean isStarted;
    private Boolean isEnded;
    private Team teamRed;
    private Team teamBlue;
    private TeamType winner;
    private ArrayList<Word> listOfWord;
    private Player currentTurn;
    private GuessWord currentGuessWord;

    public GuessWord getCurrentGuessWord() {
        return currentGuessWord;
    }

    public void setCurrentGuessWord(GuessWord currentGuessWord) {
        this.currentGuessWord = currentGuessWord;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Boolean getEnded() {
        return isEnded;
    }

    public void setEnded(Boolean ended) {
        isEnded = ended;
    }

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

    public TeamType getWinner() {
        return winner;
    }

    public void setWinner(TeamType winner) {
        this.winner = winner;
    }

    public ArrayList<Word> getListOfWord() {
        return listOfWord;
    }

    public void setListOfWord(ArrayList<Word> listOfWord) {
        this.listOfWord = listOfWord;
    }

    public Game(String mapID, Boolean isStarted, Team teamRed, Team teamBlue) {
        this.mapID = mapID;
        this.isStarted = isStarted;
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
    }
    public Game(String mapID){
        this.mapID = mapID;
    }
    public Game(){
        int randomId = (int)Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        this.mapID = String.valueOf(randomId);
        this.isStarted = false;
        this.isEnded = false;
        this.teamRed = null;
        this.teamBlue = null;
    }
}
