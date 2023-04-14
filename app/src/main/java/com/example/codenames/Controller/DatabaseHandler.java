package com.example.codenames.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.Enum.TeamType;
import com.example.codenames.Model.Game;
import com.example.codenames.Model.GuessWord;
import com.example.codenames.Model.MapPlayer;
import com.example.codenames.Model.Player;
import com.example.codenames.Model.Team;
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
    public static DatabaseReference gameDatabase = db.getReference("game");

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
        GlobalData.listOfWords = new ArrayList<Word>();
        gameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    GlobalData.game = new Game(gameId);
                    if(snapshot.child("listOfWord").exists()){
                        gameDatabase.child(gameId).child("listOfWord").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                Word word = snapshot.getValue(Word.class);
                                GlobalData.listOfWords.add(word);
                                GlobalData.game.setListOfWord(GlobalData.listOfWords);
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
                        new CountDownTimer(1000,1000){
                            @Override
                            public void onTick(long l) {
                            }
                            @Override
                            public void onFinish() {
                                Intent i = new Intent(ctx, Room.class);
                                ctx.startActivity(i);
                            }
                        }.start();
                    }else{
                        //if the room does not exist
                        DialogHandler.displayDialogMessage(ctx,"The room does not exist");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public static void updateRevealedWord(String gameId, int index){
        gameDatabase.child(gameId).child("listOfWord").child(String.valueOf(index)).child("revealed").setValue(true);
    }
    public static void setCurrentGuessWord(String gameId, GuessWord guessWord){
        DatabaseReference currentGuessWordRef = gameDatabase.child(gameId).child("currentGuessWord");
        currentGuessWordRef.setValue(guessWord);
    }
    public static void getCurrentGuessword(String gameId){
        gameDatabase.child(gameId).child("currentGuessWord").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    GlobalData.game.setCurrentGuessWord(snapshot.getValue(GuessWord.class));
                    Log.d("CurrentGuessWord",GlobalData.game.getCurrentGuessWord().toString());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    };
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
        if(team == TeamType.BLUE && roles == Roles.spymaster){
            changeCurrentTurn(gameId,GlobalData.currentPlayer);
        }
    };
    public static void changeCurrentTurn (String gameId, Player currentTurn){
        gameDatabase.child(gameId).child("currentTurn").setValue(currentTurn);
    }
    public static void updateTeamWinner(String gameId, TeamType winner){
        gameDatabase.child(gameId).child("winner").setValue(winner);
    }
    public static void updatePoints(String gameId, TeamType teamGetPoint){
        if (teamGetPoint == TeamType.BLUE){
            int point = GlobalData.game.getBluePoints() + 1;
            gameDatabase.child(gameId).child("bluePoints").setValue(point);
        }else{
            int point = GlobalData.game.getRedPoints() + 1;
            gameDatabase.child(gameId).child("redPoints").setValue(point);
        }
    }
}
