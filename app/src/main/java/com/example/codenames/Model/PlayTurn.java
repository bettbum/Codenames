package com.example.codenames.Model;

public class PlayTurn {
    private int turnID;

    private Player operative;
    private Player spymaster;
    private MapPlayer map;
    private int numOfGuess;
    private String clue;

    public int getTurnID() {
        return turnID;
    }

    public void setTurnID(int turnID) {
        this.turnID = turnID;
    }

    private Word[] wordsGuess;
//    private int turnTiming;

    public Player getOperative() {
        return operative;
    }

    public void setOperative(Player operative) {
        this.operative = operative;
    }

    public Player getSpymaster() {
        return spymaster;
    }

    public void setSpymaster(Player spymaster) {
        this.spymaster = spymaster;
    }

    public MapPlayer getMap() {
        return map;
    }

    public void setMap(MapPlayer map) {
        this.map = map;
    }

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public void setNumOfGuess(int numOfGuess) {
        this.numOfGuess = numOfGuess;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public Word[] getWordsGuess() {
        return wordsGuess;
    }

    public void setWordsGuess(Word[] wordsGuess) {
        this.wordsGuess = wordsGuess;
    }

    public PlayTurn(Player operative, MapPlayer map, int numOfGuess, String clue, Word[] wordsGuess) {
        this.operative = operative;
        this.map = map;
        this.numOfGuess = numOfGuess;
        this.clue = clue;
        this.wordsGuess = wordsGuess;
    }
}

