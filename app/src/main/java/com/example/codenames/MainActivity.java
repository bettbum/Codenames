package com.example.codenames;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.codenames.Model.MapPlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //testing color
        MapPlayer map = new MapPlayer();
        ArrayList<Color> colors = map.generateColor(getBaseContext());
        Log.d("testing colors", colors.toString());

        //Testing dialog button
//        Button dialogbtn = findViewById(R.id.btnTestDialog);
//        Dialog dialog = new Dialog(MainActivity.this);
//        dialogbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                dialog.setContentView(R.layout.dialog_guessword);

//                dialog.setContentView(R.layout.dialog_message);

//                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                dialog.getWindow().setBackgroundDrawable(null);
//                dialog.setCancelable(false);
//                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

////                TextView lblMessage = dialog.findViewById(R.id.lblMessage);
////                lblMessage.setText("Wrong word");

//                TextView lblMessage = dialog.findViewById(R.id.lblMessage);
//                lblMessage.setText("Wrong word");

//                dialog.show();
//                new CountDownTimer(2000,1000){
//                    @Override
//                    public void onTick(long l) {
//                    }
//                    @Override
//                    public void onFinish() {
//                        dialog.dismiss();
//                        Log.d("dd","Finished Dialog");
//                    }
//                }.start();
//            }
//        });
    }
}