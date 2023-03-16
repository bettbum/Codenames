package com.example.codenames.Model;

import java.util.ArrayList;

public class PlayTurn {
    private String turnID;
    private Player operative;
    private Player spymaster;
    private MapPlayer map;
    private int numOfGuess;
    private ArrayList<String> clues;
    private ArrayList<Word> wordsGuess;
    //    private int turnTiming;
    public String getTurnID() {
        return turnID;
    }

    public void setTurnID(String turnID) {
        this.turnID = turnID;
    }

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

    public ArrayList<String> getClue() {
        return clues;
    }

    public void setClue(ArrayList<String>  clue) {
        this.clues = clue;
    }

    public ArrayList<Word> getWordsGuess() {
        return wordsGuess;
    }

    public void setWordsGuess(ArrayList<Word> wordsGuess) {
        this.wordsGuess = wordsGuess;
    }

    public PlayTurn(Player operative, MapPlayer map, int numOfGuess, ArrayList<String>  clues, ArrayList<Word> wordsGuess) {
        this.operative = operative;
        this.map = map;
        this.numOfGuess = numOfGuess;
        this.clues = clues;
        this.wordsGuess = wordsGuess;
    }

    private void addClue(String clue){
        this.clues.add(clue);
    }
}

