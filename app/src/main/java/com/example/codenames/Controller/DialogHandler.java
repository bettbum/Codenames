package com.example.codenames.Controller;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.codenames.Model.GuessWord;
import com.example.codenames.R;

import java.util.Dictionary;

public class DialogHandler {
    public static void displayDialogMessage(View v, String message){
        Dialog dialog = new Dialog(v.getContext());
        dialog.setContentView(R.layout.dialog_message);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        TextView lblMessage = dialog.findViewById(R.id.lblMessage);
        lblMessage.setText("Wrong word");
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
    public static void displayDialogGuessWord(View v) {
        Dialog dialog = new Dialog(v.getContext());
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
                int numberOfGuesses = Integer.valueOf(edNumberOfGuesses.getText().toString());
                DatabaseHandler.setCurrentGuessWord(new GuessWord(guessWord, numberOfGuesses));
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
