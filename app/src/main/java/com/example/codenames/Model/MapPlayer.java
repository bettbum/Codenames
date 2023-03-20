package com.example.codenames.Model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.R;

import java.util.ArrayList;
import java.util.Collections;

public class MapPlayer {
    private String mapID;
    private ArrayList<Word> words;
    private ArrayList<Color> colors;

    public String getMapID() {
        return mapID;
    }

    public void setMapID(String mapID) {
        this.mapID = mapID;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public MapPlayer(String mapID, ArrayList<Word> words, ArrayList<Color> colors, Roles role) {
        this.mapID = mapID;
        this.words = words;
        this.colors = colors;
    }
    public MapPlayer(){}
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MapPlayer(String mapID, ArrayList<Word> words) {
        this.mapID = mapID;
        this.words = words;
        //this.colors = generateColor();
    }


}

