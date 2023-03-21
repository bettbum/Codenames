package com.example.codenames.View;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.R;

import java.util.ArrayList;

public class GamePlay extends AppCompatActivity {
    TextView lblRoomNumber, lblTurn, lblBluePoints, lblRedPoints;
    ArrayList<Button> listBtnsCards= new ArrayList<>();
    Button btnOprBlue, btnSpyBlue, btnOprRed, btnSpyRed;
    ArrayList<String> listOfWords = new ArrayList<>();

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
        btnOprBlue = findViewById(R.id.btnObjBlue);
        btnSpyBlue = findViewById(R.id.btnSpyBlue);
        btnSpyRed = findViewById(R.id.btnSpyRed);
        btnOprRed = findViewById(R.id.btnObjRed);
        setWordsOnBoards();
    }
    private void setWordsOnBoards(){
//        try {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                //listOfWords = retrieveWords(getBaseContext());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Log.d("testing words", String.valueOf(listOfWords));
        if(listOfWords.size() == 25){
            for(int i = 0; i < listOfWords.size(); i++){
                listBtnsCards.get(i).setText(listOfWords.get(i));
            }
        }
    }

}