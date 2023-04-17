package com.example.codenames.View;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.Controller.DatabaseHandler;
import com.example.codenames.Controller.DialogHandler;
import com.example.codenames.Controller.GlobalData;
import com.example.codenames.Model.Enum.TeamType;
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
        new CountDownTimer(1000,1000){
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                Intent i = new Intent(getBaseContext(), Room.class);
                i.putExtra("gameId",gameId);
                startActivity(i);
            }
        }.start();
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