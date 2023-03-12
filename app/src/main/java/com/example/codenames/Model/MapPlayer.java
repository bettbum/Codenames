package com.example.codenames.Model;

import android.graphics.Color;

public class MapPlayer {
    private String mapID;
    private Word[] words;
    private Color[] colors;
    private String role;

    public String getMapID() {
        return mapID;
    }

    public void setMapID(String mapID) {
        this.mapID = mapID;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MapPlayer(String mapID, Word[] words, Color[] colors, String role) {
        this.mapID = mapID;
        this.words = words;
        this.colors = colors;
        this.role = role;
    }
}

