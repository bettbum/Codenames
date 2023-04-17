package com.example.codenames.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.codenames.Controller.DatabaseHandler;
import com.example.codenames.Controller.DialogHandler;
import com.example.codenames.Controller.GlobalData;
import com.example.codenames.Controller.Validator;
import com.example.codenames.Model.Enum.TeamType;
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
        setStates();
    }
    private void initialize(){
        edRoomNumber = findViewById(R.id.edRoomNumber);
        lblError = findViewById(R.id.lblError);
        btnBack = findViewById(R.id.btnBack);
        btnGo = findViewById(R.id.btnGo);
    }
    private void setStates(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edRoomNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lblError.setVisibility(s.length() == 0 ? View.VISIBLE : View.INVISIBLE);
                btnGo.setEnabled(s.length() != 0);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameId = edRoomNumber.getText().toString();
                if(!Validator.isValidRoomNumber(gameId)){
                    lblError.setVisibility(View.VISIBLE);
                }else{
                    DatabaseHandler.joinAnExistingGame(gameId, v.getContext());
                }
            }
        });
    }

}