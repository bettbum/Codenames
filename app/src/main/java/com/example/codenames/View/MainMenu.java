package com.example.codenames.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.Controller.DatabaseHandler;
import com.example.codenames.R;

import java.io.IOException;

public class MainMenu extends AppCompatActivity {
    Button btnCreateRoom, btnJoinRoom, btnRule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initialize();
    }
    private void initialize(){
        btnCreateRoom = findViewById(R.id.btnCreateRoom);
        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createRoom();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        btnJoinRoom = findViewById(R.id.btnJoinRoom);
        btnJoinRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinRoom();
            }
        });
        btnRule = findViewById(R.id.btnRule);
        btnRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRules();
            }
        });
    }
    private void createRoom() throws IOException {
        String gameId = DatabaseHandler.createNewGame(getBaseContext());
        Intent i = new Intent(this, Room.class);
        i.putExtra("gameId",gameId);
        startActivity(i);
    }
    private void joinRoom(){
        Intent i = new Intent(this, JoinRoom.class);
        startActivity(i);
    }
    private void showRules(){
        Intent i = new Intent(this, Rules.class);
        startActivity(i);
    }
}