package com.example.codenames.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;
import com.example.codenames.Model.Game;
import com.example.codenames.Model.GuessWord;
import com.example.codenames.Model.Player;
import com.example.codenames.Model.Word;
import com.example.codenames.R;
import com.example.codenames.View.Room;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DatabaseHandler {
    private static FirebaseDatabase db = FirebaseDatabase.getInstance();
    private static DatabaseReference gameDatabase = db.getReference("game");

    public static void testDatabaseConnection(){
        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Log.d("firebase", "connected");
                } else {
                    Log.d("firebase", "not connected");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("firebase", "Listener was cancelled");
            }
        });
    }
    public static String createNewGame(Context ctx) throws IOException {
        GlobalData.game = new Game();
        GlobalData.game.setListOfWord(getResources.setRandomWords(ctx));
        gameDatabase.child(GlobalData.game.getMapID()).setValue(GlobalData.game);
        return GlobalData.game.getMapID();
    }
    public static void joinAnExistingGame(String gameId, Context ctx){
        DatabaseReference gameRef = gameDatabase.child(gameId);

        gameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    GlobalData.game = new Game(gameId);
                    if(snapshot.child("list_of_words").exists()){
                       ArrayList<Word> listOfWords = new ArrayList<Word>();
                        gameDatabase.child(gameId).child("list_of_words").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                Word word = snapshot.getValue(Word.class);
                                listOfWords.add(word);
                                GlobalData.game.setListOfWord(listOfWords);
                            }
                            @Override
                            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
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
                    }else{
                        //if the room does not exist
                    }
                    DatabaseHandler.getListOfCurrentPlayer(GlobalData.game.getMapID());
                    Intent i = new Intent(ctx, Room.class);
                    ctx.startActivity(i);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    public static void setCurrentGuessWord(GuessWord guessWord){
        DatabaseReference currentGuessWordRef = gameDatabase.child("currentGuessWord");
        currentGuessWordRef.setValue(guessWord);
    }
    public static Player addNewPlayer (String gameId){
        Player player = new Player();
        gameDatabase.child(gameId).child("players").child(player.getPlayerID()).setValue(player);
        return player;
    }
    public static void removePlayer (String gameId, String playerId){
        gameDatabase.child(gameId).child("players").child(playerId).removeValue();
    };
    public static void addRoleForPlater(String gameId, String playerId, TeamType team, Roles roles){
        GlobalData.currentPlayer = new Player(playerId, team, roles);
        gameDatabase.child(gameId).child("players").child(playerId).setValue(GlobalData.currentPlayer);
    };
    public static void getListOfCurrentPlayer(String gameId){

        gameDatabase.child(gameId).child("players").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    Player player = ds.getValue(Player.class);
                    GlobalData.listOfCurrentPlayers.add(player);
                    Log.d("listOfCurren", String.valueOf(GlobalData.listOfCurrentPlayers.size()));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    };
    public static void deleteGame(){
        gameDatabase.child("1565").child("players").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String userId = snapshot.getKey();
                gameDatabase.child("1565").child("players").removeValue();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
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
