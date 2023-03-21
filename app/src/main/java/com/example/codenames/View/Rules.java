package com.example.codenames.View;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.codenames.R;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        EditText editTextRules = findViewById(R.id.editTextRules);
        String ruleContent = String.valueOf(R.string.rules);
        editTextRules.setText(android.text.Html.fromHtml(ruleContent));
    }
}