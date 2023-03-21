package com.example.codenames.Controller;

import com.example.codenames.Model.Word;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidRoomNumber(String gameId){
        Matcher m = Pattern.compile("^\\d{4}$").matcher(gameId);
        return m.matches() ? true : false;
    }
    public static int isCorrectWord(Word word){
        ArrayList<Word> listOfWOrds = GlobalData.game.getListOfWord();
        return 0;
    }
}
