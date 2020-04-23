package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    Button btnShow;
    TextView tvMaterials, tvOnTime, tvAttemptPS, tvReflection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        btnShow = findViewById(R.id.buttonShow);
        tvMaterials = findViewById(R.id.textViewMaterials);
        tvOnTime = findViewById(R.id.textViewOnTime);
        tvAttemptPS = findViewById(R.id.textViewPS);
        tvReflection = findViewById(R.id.textViewReflection);

        Intent intent = getIntent();

        String[] data = intent.getStringArrayExtra("summary");

        tvMaterials.setText(data[0]);
        tvOnTime.setText(data[1]);
        tvAttemptPS.setText(data[2]);
        tvReflection.setText(data[3]);



    }
}
