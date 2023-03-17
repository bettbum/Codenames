package com.example.codenames.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.codenames.R;

public class Room extends AppCompatActivity {
    TextView lblRoomNumber, lblNumberOfPlayersJoined;
    Button btnObjectiveBlue, btnSpymasterBlue, btnObjectiveRed, btnSpymasterRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        initialize();
    }
    private void initialize(){
        lblRoomNumber = findViewById(R.id.lblRoomNumber);
        lblNumberOfPlayersJoined = findViewById(R.id.lblNumberOfPlayersJoined);
        btnObjectiveBlue = findViewById(R.id.btnObjectiveBlue);
        btnObjectiveBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnObjectiveBlue.setBackgroundColor(Color.GRAY);
            }
        });
        btnSpymasterBlue = findViewById(R.id.btnSpymasterBlue);
        btnObjectiveRed = findViewById(R.id.btnObjectiveRed);
        btnSpymasterRed = findViewById(R.id.btnSpymasterRed);

    }
    @SuppressLint("ResourceAsColor")
    private void resetBtnColor(){
        btnObjectiveBlue.setBackgroundColor(R.color.blue_button);
        btnSpymasterBlue.setBackgroundColor(R.color.blue_button);
        btnObjectiveRed.setBackgroundColor(R.color.red_button);
        btnSpymasterRed.setBackgroundColor(R.color.red_button);
    }
}