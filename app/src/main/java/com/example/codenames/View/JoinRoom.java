package com.example.codenames.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.codenames.R;

public class JoinRoom extends AppCompatActivity {
    EditText edRoomNumber;
    TextView lblError;
    Button btnBack, btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_room);
        initialize();
    }
    private void initialize(){
        edRoomNumber = findViewById(R.id.edRoomNumber);
        lblError = findViewById(R.id.lblError);
        btnBack = findViewById(R.id.btnBack);
        btnGo = findViewById(R.id.btnGo);

    }
}