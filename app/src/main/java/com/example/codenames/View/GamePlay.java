package com.example.codenames.View;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.Controller.DatabaseHandler;
import com.example.codenames.Controller.DialogHandler;
import com.example.codenames.Controller.GlobalData;
import com.example.codenames.Controller.Validator;
import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;
import com.example.codenames.Model.Game;
import com.example.codenames.Model.GuessWord;
import com.example.codenames.Model.Player;
import com.example.codenames.Model.Word;
import com.example.codenames.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GamePlay extends AppCompatActivity{
    TextView lblRoomNumber, lblBluePoints, lblRedPoints, lblGuessWord, lblClueNumber;
    ArrayList<Button> listBtnsCards= new ArrayList<>();
    Button btnOprBlue, btnSpyBlue, btnOprRed, btnSpyRed, btnEndTurn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        initialize();
    }
    private void initialize(){
        lblRoomNumber = findViewById(R.id.lblRoomNumber);
        lblRoomNumber.setText("Room number : " + GlobalData.game.getMapID());
        lblGuessWord = findViewById(R.id.lblGuessWord);
        lblClueNumber = findViewById(R.id.lblClueNumber);
        lblRedPoints = findViewById(R.id.lblRedPoints);
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
        for(int i = 0; i < listBtnsCards.size(); i++){
            int finalI = i;
            listBtnsCards.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int result = Validator.isCorrectWord(finalI, GlobalData.game.getCurrentTurn().getTeamID());
                    listBtnsCards.get(finalI).setBackgroundColor(GlobalData.game.getListOfWord().get(finalI).getColor());
                    DatabaseHandler.updateRevealedWord(GlobalData.game.getMapID(),finalI);
                    switch(result){
                        //handle the cases when the user pick a card
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            DialogHandler.displayDialogMessage(v.getContext(), "Wrong word");
                            nextTurn();
                            break;
                        case -1:
                            break;
                    }
                }
            });
        }
        btnEndTurn = findViewById(R.id.btnEndTurn);
        btnOprBlue = findViewById(R.id.btnObjBlue);
        btnSpyBlue = findViewById(R.id.btnSpyBlue);
        btnSpyRed = findViewById(R.id.btnSpyRed);
        btnOprRed = findViewById(R.id.btnObjRed);
        showBoard();
        listenForCurrentPlayer();
        btnEndTurnOnCLick();
    }
    private void setWordsOnBoardsForSpy(){
        if(GlobalData.game.getListOfWord().size() == 25){
            for(int i = 0; i < GlobalData.game.getListOfWord().size(); i++){
                Word word = GlobalData.game.getListOfWord().get(i);
                listBtnsCards.get(i).setText(word.getContent());
                listBtnsCards.get(i).setEnabled(false);
                listBtnsCards.get(i).setBackgroundColor(word.getColor());
                listBtnsCards.get(i).setTextColor(Color.WHITE);
            }
        }
    }
    private void setWordsOnBoardsForOpe(){
        if(GlobalData.game.getListOfWord().size() == 25){
            for(int i = 0; i < GlobalData.game.getListOfWord().size(); i++){
                Word word = GlobalData.game.getListOfWord().get(i);
                listBtnsCards.get(i).setText(word.getContent());
                listBtnsCards.get(i).setEnabled(true);
                listBtnsCards.get(i).setBackgroundColor(Color.GRAY);
                listBtnsCards.get(i).setTextColor(Color.WHITE);
            }
        }
    }
    private void showBoard(){
        switch (GlobalData.currentPlayer.getRole()){
            case operative:
                setWordsOnBoardsForOpe();
                break;
            case spymaster:
                setWordsOnBoardsForSpy();
                break;
            default:
        }
    }
    private void btnEndTurnOnCLick(){
        btnEndTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTurn();
            }
        });
    }
    private void listenForCurrentPlayer(){
        DatabaseHandler.gameDatabase.child(GlobalData.game.getMapID()).child("currentTurn").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Player currentTurn = snapshot.getValue(Player.class);
                    GlobalData.game.setCurrentTurn(currentTurn);
                    Log.d("currentTurn", GlobalData.game.getCurrentTurn().getPlayerID());
                    String messageForCurrentPlayer = "Current player : " + currentTurn.getRole() + " " + currentTurn.getTeamID();
                    DialogHandler.displayDialogMessage(GamePlay.this,messageForCurrentPlayer);
                    setColorButtons(currentTurn);
                    if(GlobalData.game.getCurrentTurn().getPlayerID().equals(GlobalData.currentPlayer.getPlayerID())){
                        if (currentTurn.getRole() == Roles.spymaster) {
                            DialogHandler.displayDialogGuessWord(GamePlay.this, GlobalData.game.getMapID());
                        }else if (currentTurn.getRole() == Roles.operative){

                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        DatabaseHandler.gameDatabase.child(GlobalData.game.getMapID()).child("currentGuessWord").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    GlobalData.game.setCurrentGuessWord(snapshot.getValue(GuessWord.class));
                    Log.d("CurrentGuessWord",GlobalData.game.getCurrentGuessWord().toString());
                    lblGuessWord.setText(GlobalData.game.getCurrentGuessWord().getGuessWord());
                   lblClueNumber.setText(String.valueOf(GlobalData.game.getCurrentGuessWord().getNumberOfGuesses()));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    private void setColorButtons(Player currentTurn){
        btnOprBlue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_default));
        btnOprRed.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_default));
        btnSpyBlue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_default));
        btnSpyRed.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_default));
        if(currentTurn.getTeamID() == TeamType.BLUE && currentTurn.getRole() == Roles.spymaster){
            btnSpyBlue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_blue));
        }else if (currentTurn.getTeamID() == TeamType.BLUE && currentTurn.getRole() == Roles.operative){
            btnSpyBlue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_blue));
        }else if (currentTurn.getTeamID() == TeamType.RED && currentTurn.getRole() == Roles.spymaster){
            btnSpyBlue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_red));
        }else if (currentTurn.getTeamID() == TeamType.RED && currentTurn.getRole() == Roles.operative){
            btnSpyBlue.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_red));
        }
    }
    private void nextTurn(){
        Player currentTurn = GlobalData.game.getCurrentTurn();
        String gameId = GlobalData.game.getMapID();
        if(currentTurn.getTeamID() == TeamType.BLUE && currentTurn.getRole() == Roles.spymaster){
            Player nextPlayer = null;
            for(Player player : GlobalData.listOfCurrentPlayers){
                if(player.getTeamID() == TeamType.BLUE && player.getRole() == Roles.operative){
                    nextPlayer = player;
                    break;
                }
            }
            if(nextPlayer != null){
                DatabaseHandler.changeCurrentTurn(gameId, nextPlayer);
            }
        }else if (currentTurn.getTeamID() == TeamType.BLUE && currentTurn.getRole() == Roles.operative){
            Player nextPlayer = null;
            for(Player player : GlobalData.listOfCurrentPlayers){
                if(player.getTeamID() == TeamType.RED && player.getRole() == Roles.spymaster){
                    nextPlayer = player;
                    break;
                }
            }
            if(nextPlayer != null){
                DatabaseHandler.changeCurrentTurn(gameId, nextPlayer);
            }
        }else if (currentTurn.getTeamID() == TeamType.RED && currentTurn.getRole() == Roles.spymaster){
            Player nextPlayer = null;
            for(Player player : GlobalData.listOfCurrentPlayers){
                if(player.getTeamID() == TeamType.RED && player.getRole() == Roles.operative){
                    nextPlayer = player;
                    break;
                }
            }
            if(nextPlayer != null){
                DatabaseHandler.changeCurrentTurn(gameId, nextPlayer);
            }
        }else if (currentTurn.getTeamID() == TeamType.RED && currentTurn.getRole() == Roles.operative){
            Player nextPlayer = null;
            for(Player player : GlobalData.listOfCurrentPlayers){
                if(player.getTeamID() == TeamType.BLUE && player.getRole() == Roles.spymaster){
                    nextPlayer = player;
                    break;
                }
            }
            if(nextPlayer != null){
                DatabaseHandler.changeCurrentTurn(gameId, nextPlayer);
            }
        }
    }


}