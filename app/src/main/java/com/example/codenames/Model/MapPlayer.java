package com.example.codenames.Model;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.R;

import java.util.Collections;
import java.util.List;

public class MapPlayer {
    private String mapID;
    private Word[] words;
    private Color[] colors;
    private Roles role;

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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public MapPlayer(String mapID, Word[] words, Color[] colors, Roles role) {
        this.mapID = mapID;
        this.words = words;
        this.colors = colors;
        this.role = role;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MapPlayer(int mapID, Word[] words) {
        this.mapID = mapID;
        this.words = words;
        this.colors = generateColor();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    //Suffering a random array of color map
    public Color[] generateColor() {
        Resources res = null;
        int red = res.getColor(R.color.red_button);
        int blue = res.getColor(R.color.blue_button);
        int gray = res.getColor(R.color.gray_400);
        int darkGray = res.getColor(R.color.gray_600);
        List<Color> original = null;
        Color[] result = new Color[25];
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
        original.toArray(result);
        return result;
    }
}

