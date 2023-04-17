package com.example.codenames.Model;

import com.example.codenames.Model.Enum.TeamType;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Game {
    private String mapID;
    private int bluePoints;
    private int redPoints;
    private int numberOfCardsRevealed;
    private TeamType winner;
    private ArrayList<Word> listOfWord;
    private Player currentTurn;
    private GuessWord currentGuessWord;
    private ArrayList<Player> currentPlayers;

    public int getNumberOfCardsRevealed() {
        return numberOfCardsRevealed;
    }

    public void setNumberOfCardsRevealed(int numberOfCardsRevealed) {
        this.numberOfCardsRevealed = numberOfCardsRevealed;
    }

    public ArrayList<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(ArrayList<Player> currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

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


    public String getMapID() {
        return mapID;
    }

    public void setMapID(String mapID) {
        this.mapID = mapID;
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

    public Game(String mapID, Boolean isStarted) {
        this.mapID = mapID;
    }
    public Game(String mapID){
        this.mapID = mapID;
        this.currentPlayers = new ArrayList<Player>();
        this.bluePoints = 0;
        this.redPoints = 0;
        this.numberOfCardsRevealed = 0;
    }
    public Game(){
        int randomId = (int)Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
        this.mapID = String.valueOf(randomId);
        this.bluePoints = 0;
        this.redPoints = 0;
        this.currentPlayers = new ArrayList<Player>();
        this.numberOfCardsRevealed = 0;
    }
    public int getBluePoints() {
        return bluePoints;
    }

    public void setBluePoints(int bluePoints) {
        this.bluePoints = bluePoints;
    }

    public int getRedPoints() {
        return redPoints;
    }

    public void setRedPoints(int redPoints) {
        this.redPoints = redPoints;
    }
}
