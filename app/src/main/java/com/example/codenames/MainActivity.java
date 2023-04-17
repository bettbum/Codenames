package com.example.codenames;

import static com.example.codenames.Controller.DatabaseHandler.testDatabaseConnection;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.Controller.DialogHandler;
import com.example.codenames.View.MainMenu;

public class MainActivity extends AppCompatActivity {


    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);
    }
}