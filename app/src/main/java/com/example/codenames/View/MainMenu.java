package com.example.codenames.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.codenames.R;

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
                createRoom();
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
    private void createRoom(){

    }
    private void joinRoom(){

    }
    private void showRules(){

    }
}