package com.example.codenames.Controller;

import android.graphics.Color;

import com.example.codenames.Model.Team;
import com.example.codenames.Model.Word;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidRoomNumber(String gameId) {
        Matcher m = Pattern.compile("^\\d{4}$").matcher(gameId);
        return m.matches() ? true : false;
    }

    public static int isCorrectWord(int index, Team team){
        ArrayList<Word> listOfWOrds = GlobalData.game.getListOfWord();
        if (listOfWOrds.get(index).getColor() == Color.BLACK) {
            return 0;
        }else if (listOfWOrds.get(index).getColor() == Color.YELLOW) {
            return 1;
        }else if (team.getColor().equals(listOfWOrds.get(index).getColor())) {
            return 2;
        }else
            return 3;
    }

}
