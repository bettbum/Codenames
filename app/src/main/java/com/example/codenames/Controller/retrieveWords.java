package com.example.codenames.Controller;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class retrieveWords {

    @RequiresApi(api = Build.VERSION_CODES.O)
    static ArrayList<String> retrieveWords() throws IOException {

        int numOfLineToRead = 25;
        File file = new File("Assets/words.txt");

        //Create new array List to add word from file
        ArrayList<String> temp = new ArrayList<String>();
        // Get all the lines into a single list
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
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
