package com.myapplicationdev.android.p01_dailygoals;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class SummaryActivity extends AppCompatActivity {

    Button btnShow;
    TextView tvMaterials, tvOnTime, tvAttemptPS, tvReflection;
    String[] data;

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("readMaterials", data[0]);
        editor.putString("arriveOnTime", data[1]);
        editor.putString("attemptPS", data[2]);
        editor.putString("reflection", data[3]);
        editor.apply();
        super.onStop();
    }

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

        data = intent.getStringArrayExtra("summary");

        tvMaterials.setText(data[0]);
        tvOnTime.setText(data[1]);
        tvAttemptPS.setText(data[2]);
        tvReflection.setText(data[3]);

        //Check what's saved in SharedPreferences
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        Map<String, ?> keys = sharedPreferences.getAll();
//
//
//        for (Map.Entry<String, ?> key : keys.entrySet()) {
//
//
//            String json2 = sharedPreferences.getString(key.getKey(), null);
//
//            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//            alertDialog.setTitle("Date");
//            alertDialog.setMessage(key.getKey() + " " + json2);
//            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            alertDialog.show();

            btnShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SummaryActivity.this);
                    if (sharedPreferences.getString("readMaterials", "") != "") {
                        tvMaterials.setText(sharedPreferences.getString("readMaterials", ""));
                    }
                    if (sharedPreferences.getString("arriveOnTime", "") != "") {
                        tvOnTime.setText(sharedPreferences.getString("arriveOnTime", ""));
                    }
                    if (sharedPreferences.getString("attemptPS", "") != "") {
                        tvAttemptPS.setText(sharedPreferences.getString("attemptPS", ""));
                    }
                    if (sharedPreferences.getString("reflection", "") != "") {
                        tvReflection.setText(sharedPreferences.getString("reflection", ""));
                    }
                }
            });

        }
    }
