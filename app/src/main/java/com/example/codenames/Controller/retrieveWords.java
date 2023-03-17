package com.example.codenames.Controller;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class retrieveWords {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<String> retrieveWords(Context ctx) throws IOException {

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
}
