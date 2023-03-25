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


        //Testing button Rules:
        Button btnCreateRoom = findViewById(R.id.btnCreateRoom);
        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),Room.class );
                startActivity(i);

            }
        });

        //Testing button Rules:
        Button btnRules = findViewById(R.id.btnRule);
        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),Rules.class );
                startActivity(i);

            }
        });

        //Testing button Rules:
        Button btnJoinRoom = findViewById(R.id.btnJoinRoom);
        btnJoinRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),JoinRoom.class );
                startActivity(i);

            }
        });
    }
}