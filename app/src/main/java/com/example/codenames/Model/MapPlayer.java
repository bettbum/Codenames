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

    @RequiresApi(api = Build.VERSION_CODES.O)
    //Suffering a random array of color map
    public ArrayList<Color> generateColor(Context ctx) {
        Resources res = ctx.getResources();
        int red = res.getColor(R.color.red_button);
        int blue = res.getColor(R.color.blue_button);
        int gray = res.getColor(R.color.gray_400);
        int darkGray = res.getColor(R.color.gray_600);
        ArrayList<Color> original = new ArrayList<Color>();
        //map has 1 gray Card
        original.add(Color.valueOf(gray));

        //map has 9 red Card
        for (int i = 0; i < 10; i++) {
            original.add(Color.valueOf(red));
        }
        //map has 8 red Card
        for (int i = 0; i < 9; i++) {
            original.add(Color.valueOf(blue));
        }
        Collections.shuffle(original);
        return original;
    }
}

