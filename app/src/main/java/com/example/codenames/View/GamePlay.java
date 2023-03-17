package com.example.codenames.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.codenames.R;

import java.util.ArrayList;

public class GamePlay extends AppCompatActivity {
    TextView lblRoomNumber, lblTurn, lblBluePoints, lblRedPoints;
    ArrayList<Button> listBtnsCards= new ArrayList<>();
    Button btnObjBlue, btnSpyBlue, btnObjRed, btnSpyRed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        initialize();
    }
    private void initialize(){
        lblRoomNumber = findViewById(R.id.lblRoomNumber);
        lblTurn = findViewById(R.id.lblTurn);
        lblBluePoints = findViewById(R.id.lblBluePoints);
        listBtnsCards.add(findViewById(R.id.btn00));
        listBtnsCards.add(findViewById(R.id.btn01));
        listBtnsCards.add(findViewById(R.id.btn02));
        listBtnsCards.add(findViewById(R.id.btn03));
        listBtnsCards.add(findViewById(R.id.btn04));
        listBtnsCards.add(findViewById(R.id.btn10));
        listBtnsCards.add(findViewById(R.id.btn11));
        listBtnsCards.add(findViewById(R.id.btn12));
        listBtnsCards.add(findViewById(R.id.btn13));
        listBtnsCards.add(findViewById(R.id.btn14));
        listBtnsCards.add(findViewById(R.id.btn20));
        listBtnsCards.add(findViewById(R.id.btn21));
        listBtnsCards.add(findViewById(R.id.btn22));
        listBtnsCards.add(findViewById(R.id.btn23));
        listBtnsCards.add(findViewById(R.id.btn24));
        listBtnsCards.add(findViewById(R.id.btn30));
        listBtnsCards.add(findViewById(R.id.btn31));
        listBtnsCards.add(findViewById(R.id.btn32));
        listBtnsCards.add(findViewById(R.id.btn33));
        listBtnsCards.add(findViewById(R.id.btn34));
        listBtnsCards.add(findViewById(R.id.btn40));
        listBtnsCards.add(findViewById(R.id.btn41));
        listBtnsCards.add(findViewById(R.id.btn42));
        listBtnsCards.add(findViewById(R.id.btn43));
        listBtnsCards.add(findViewById(R.id.btn44));
        btnObjBlue = findViewById(R.id.btnObjBlue);
        btnSpyBlue = findViewById(R.id.btnSpyBlue);
        btnSpyRed = findViewById(R.id.btnSpyRed);
        btnObjRed = findViewById(R.id.btnObjRed);

    }
}