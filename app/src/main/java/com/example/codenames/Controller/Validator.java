package com.example.codenames.Controller;

import android.graphics.Color;

import com.example.codenames.Model.Enum.TeamType;

import com.example.codenames.Model.Word;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidRoomNumber(String gameId) {
        Matcher m = Pattern.compile("^\\d{4}$").matcher(gameId);
        return m.matches() ? true : false;
    }

    //case 0 : lose
    //case 1: continue without losing
    //case 2 : correct -> continue guessing
    //case 3: next turn
    //case -1: invalid
    public static int isCorrectWord(int index, TeamType teamType){
        ArrayList<Word> listOfWOrds = GlobalData.game.getListOfWord();
        if (listOfWOrds.get(index).getColor() == -16777216) {
            return 0;
        }else if (listOfWOrds.get(index).getColor() == -676096) {
            return 1;
        }else if (teamType == TeamType.RED) {
            //if the red team chose the correct color
            if (listOfWOrds.get(index).getColor() == -2090984){
                return 2;
            }else{
                return 3;
            }
        }else if(teamType == TeamType.BLUE) {
            //if the blue team chose the correct color
            if (listOfWOrds.get(index).getColor() == -16383492){
                return 2;
            }else{
                return 3;
            }
        }
        return -1;
    }

}
