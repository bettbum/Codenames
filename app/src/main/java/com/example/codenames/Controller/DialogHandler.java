package com.example.codenames.Controller;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.codenames.Model.Enum.Roles;
import com.example.codenames.Model.GuessWord;
import com.example.codenames.Model.Player;
import com.example.codenames.R;
import com.example.codenames.View.GamePlay;

import java.util.Dictionary;

public class DialogHandler {
    public static void displayDialogMessage(Context ctx, String message){
        Dialog dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.dialog_message);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        TextView lblMessage = dialog.findViewById(R.id.lblMessage);
        lblMessage.setText(message);
        dialog.show();
        new CountDownTimer(2000,1000){
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                dialog.dismiss();
                Log.d("dd","Finished Dialog");
            }
        }.start();
    }
    public static void displayDialogGuessWord(Context ctx, String gameId) {
        Dialog dialog = new Dialog(ctx);
        dialog.setContentView(R.layout.dialog_guessword);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        EditText edGuessWord = dialog.findViewById(R.id.edGuessWord);
        EditText edNumberOfGuesses = dialog.findViewById(R.id.edNumOfGuesses);
        TextView lblErrorNumOfGuesses = dialog.findViewById(R.id.lblErrorNumOfGuesses);
        TextView lblErrorGuessWord = dialog.findViewById(R.id.lblErrorGuessWord);
        Button btnSubmit = dialog.findViewById(R.id.btnSubmit);
        edGuessWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lblErrorGuessWord.setVisibility(s.length() == 0 ? View.VISIBLE : View.INVISIBLE);
                btnSubmit.setEnabled(s.length() != 0 && lblErrorNumOfGuesses.getVisibility() != View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        edNumberOfGuesses.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lblErrorNumOfGuesses.setVisibility(s.length() == 0 ? View.VISIBLE : View.INVISIBLE);
                btnSubmit.setEnabled(s.length() != 0 && lblErrorGuessWord.getVisibility() != View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessWord = edGuessWord.getText().toString();
                int numberOfGuesses = Integer.parseInt(edNumberOfGuesses.getText().toString());
                DatabaseHandler.setCurrentGuessWord(gameId, new GuessWord(guessWord, numberOfGuesses));
                DatabaseHandler.getCurrentGuessword(GlobalData.game.getMapID());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                },100);
            }
        });
        dialog.show();
    }
}
