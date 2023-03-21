package com.example.codenames.Controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.codenames.Model.Word;
import com.example.codenames.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class getResources {

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static ArrayList<String> retrieveWords(Context ctx) throws IOException {

        int numOfLineToRead = 25;
        InputStream inputStream = ctx.getAssets().open("Words.txt");
        //Create new array List to add word from file
        ArrayList<String> temp = new ArrayList<String>();
        // Get all the lines into a single list
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null;) {
            lines.add(line);
        }
        //Shuffle lines.
        Collections.shuffle(lines);
        // Get a random word and point at the end.
        int wordFinish = new Random().nextInt(lines.size() / numOfLineToRead) * numOfLineToRead;
        // Point to the be start
        int start = wordFinish - numOfLineToRead;
        // Create a sublist with the start and finish indexes.
        for (String line : lines.subList(start, wordFinish))
            temp.add(line);
        return temp;
    }
    //not enough 25
    @RequiresApi(api = Build.VERSION_CODES.O)
    //Suffering a random array of color map
    private static ArrayList<Integer> generateColor(Context ctx) {
        Resources res = ctx.getResources();
        int red = res.getColor(R.color.red);
        int blue = res.getColor(R.color.blue);
        int black = res.getColor(R.color.black);
        int yellow = res.getColor(R.color.yellow);
        ArrayList<Integer> original = new ArrayList<Integer>();
        //map has 1 gray Card
        original.add(black);

        //map has 9 red Card
        for (int i = 0; i < 9; i++) {
            original.add(red);
        }
        //map has 8 red Card
        for (int i = 0; i < 8; i++) {
            original.add(blue);
        }
        //map has 7 yellow card
        for(int i = 0; i < 7; i++){
            original.add(yellow);
        }
        Collections.shuffle(original);
        return original;
    }
    static ArrayList<Word> setRandomWords(Context ctx) throws IOException {
        ArrayList<Word> listOfRandomWords = new ArrayList<Word>();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            ArrayList<String> listOfWords = retrieveWords(ctx);
            ArrayList<Integer> listOfColors = generateColor(ctx);

            if(listOfWords.size() == listOfColors.size()){
                for(int i = 0 ; i < listOfColors.size(); i++){
                    String content = listOfWords.get(i);
                    int color = listOfColors.get(i);
                    listOfRandomWords.add(new Word(content,color));
                }
            }
        }
        return listOfRandomWords;
    }
}
