package com.example.codenames;

import static com.example.codenames.Controller.DatabaseHandler.testDatabaseConnection;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.Controller.DialogHandler;
import com.example.codenames.View.GamePlay;
import com.example.codenames.View.JoinRoom;
import com.example.codenames.View.Room;
import com.example.codenames.View.Rules;

public class MainActivity extends AppCompatActivity {


    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //testing color
//        MapPlayer map = new MapPlayer();
//        ArrayList<Color> colors = map.generateColor(getBaseContext());
//        Log.d("testing colors", colors.toString());


        //testing if the words are on board
//        Intent i = new Intent(getBaseContext(), GamePlay.class);
//        startActivity(i);
//        testDatabaseConnection();
//        //Testing guessword dialog
//        Button dialogbtn = findViewById(R.id.btnTestDialog);
//        dialogbtn.setOnClickListener(new View.OnClickListener() {
           // @Override
//            public void onClick(View view) {
//                DialogHandler.displayDialogGuessWord(view);
//            }
//        });

        //Testing button Rules:
        Button btnRules = findViewById(R.id.btnRule);
        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),Rules.class );
                startActivity(i);

            }
        });

    }
}