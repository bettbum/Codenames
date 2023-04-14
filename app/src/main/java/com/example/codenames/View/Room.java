package com.example.codenames.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.codenames.Controller.DatabaseHandler;
import com.example.codenames.Controller.GlobalData;
import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;
import com.example.codenames.Model.Player;
import com.example.codenames.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

public class Room extends AppCompatActivity {
    TextView lblRoomNumber, lblNumberOfPlayersJoined;
    Button btnObjectiveBlue, btnSpymasterBlue, btnObjectiveRed, btnSpymasterRed, btnBack, btnReady;
    TeamType team; Roles role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        initialize();
    }
    private void initialize(){
        listenForCurrentPlayers();
        lblRoomNumber = findViewById(R.id.lblRoomNumber);
        if(GlobalData.game.getMapID() != null){
            lblRoomNumber.setText("Room number : " + GlobalData.game.getMapID());
        }
        lblNumberOfPlayersJoined = findViewById(R.id.lblNumberOfPlayersJoined);
        lblNumberOfPlayersJoined.setText("Number of players joined : " + (GlobalData.listOfCurrentPlayers.size()+1));
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GlobalData.currentPlayer != null && GlobalData.game != null){
                    DatabaseHandler.removePlayer(GlobalData.game.getMapID(), GlobalData.currentPlayer.getPlayerID());
                    finish();
                }
            }
        });
        btnObjectiveBlue = findViewById(R.id.btnObjectiveBlue);
        btnObjectiveBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnOnCLick(btnObjectiveBlue);
                team = TeamType.BLUE;
                role = Roles.operative;
            }
        });
        btnSpymasterBlue = findViewById(R.id.btnSpymasterBlue);
        btnSpymasterBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnOnCLick(btnSpymasterBlue);
                team = TeamType.BLUE;
                role = Roles.spymaster;;
            }
        });
        btnObjectiveRed = findViewById(R.id.btnObjectiveRed);
        btnObjectiveRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnOnCLick(btnObjectiveRed);
                team = TeamType.RED;
                role = Roles.operative;;
            }
        });
        btnSpymasterRed = findViewById(R.id.btnSpymasterRed);
        btnSpymasterRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnOnCLick(btnSpymasterRed);
                team = TeamType.RED;
                role = Roles.spymaster;
            }
        });
        btnReady = findViewById(R.id.btnReady);
        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GlobalData.game != null){
                    DatabaseHandler.addRoleForPlater(GlobalData.game.getMapID(), GlobalData.currentPlayer.getPlayerID(), team, role);
                }
            }
        });
        GlobalData.currentPlayer = DatabaseHandler.addNewPlayer(GlobalData.game.getMapID());
    }
    @SuppressLint("ResourceAsColor")
    private void resetBtnColor(){
        btnObjectiveBlue.setBackground(getResources().getDrawable(R.drawable.button_blue));
        btnSpymasterBlue.setBackground(getResources().getDrawable(R.drawable.button_blue));
        btnObjectiveRed.setBackground(getResources().getDrawable(R.drawable.button_red));
        btnSpymasterRed.setBackground(getResources().getDrawable(R.drawable.button_red));
    }
    private void setBtnOnCLick(Button btn){
        resetBtnColor();
        btn.setBackground(getResources().getDrawable(R.drawable.button_gray));
        btnReady.setEnabled(true);
    }
    private void listenForCurrentPlayers(){
        DatabaseHandler.gameDatabase.child(GlobalData.game.getMapID()).child("players").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Player player = snapshot.getValue(Player.class);
                GlobalData.listOfCurrentPlayers.add(player);
                if (player.getTeamID() == TeamType.BLUE && player.getRole() == Roles.operative) {
                    btnObjectiveBlue.setEnabled(false);
                } else if (player.getTeamID() == TeamType.BLUE && player.getRole() == Roles.spymaster) {
                    btnSpymasterBlue.setEnabled(false);
                } else if (player.getTeamID() == TeamType.RED && player.getRole() == Roles.operative) {
                    btnObjectiveRed.setEnabled(false);
                } else if (player.getTeamID() == TeamType.RED && player.getRole() == Roles.spymaster) {
                    btnSpymasterRed.setEnabled(false);
                }
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(GlobalData.listOfCurrentPlayers.size() == 4){
                    Intent intent = new Intent(Room.this, GamePlay.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}