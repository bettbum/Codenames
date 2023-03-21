package com.example.codenames;

import static com.example.codenames.Controller.DatabaseHandler.testDatabaseConnection;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        //testing color
//        MapPlayer map = new MapPlayer();
//        ArrayList<Color> colors = map.generateColor(getBaseContext());
//        Log.d("testing colors", colors.toString());


        //testing if the words are on board
//        Intent i = new Intent(this, GamePlay.class);
//        startActivity(i);
        testDatabaseConnection();
        //Testing guessword dialog
//        Button dialogbtn = findViewById(R.id.btnTestDialog);
//        dialogbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DialogHandler.displayDialogGuessWord(view);
//            }
//        });
    }
}