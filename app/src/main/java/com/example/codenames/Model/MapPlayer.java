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
    private ArrayList<Player> listOfPlayers;

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
    public MapPlayer(){
        listOfPlayers = new ArrayList<>();
    }
}

