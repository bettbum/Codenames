package com.example.codenames.Controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.codenames.Model.Game;
import com.example.codenames.Model.GuessWord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    public static String createNewGame(){
        Game newGame = new Game();
        gameDatabase.child(newGame.getMapID()).setValue(newGame);
        return newGame.getMapID();
    }
    public static void joinAnExistingGame(String gameId){
        DatabaseReference gameRef = gameDatabase.child(gameId);
        gameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    //if the room exists
                }else{
                    //if the room does not exist

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

}
