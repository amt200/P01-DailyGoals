package com.myapplicationdev.android.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnOK;
    RadioGroup radioGroupMaterials, radioGroupOnTime, radioGroupAttemptPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK = findViewById(R.id.buttonOK);
        editText = findViewById(R.id.editTextReflection);

        radioGroupMaterials = findViewById(R.id.radioGrpReadMaterials);
        radioGroupOnTime = findViewById(R.id.radioGrpOnTime);
        radioGroupAttemptPS = findViewById(R.id.radioGrpAttemptPS);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup[] radioGroups = new RadioGroup[3];

                radioGroups[0] = radioGroupMaterials;
                radioGroups[1] = radioGroupOnTime;
                radioGroups[2] = radioGroupAttemptPS;

                String[] summary_answers = new String[4];
                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

                populate_data_summary(summary_answers, radioGroups);

                intent.putExtra("summary", summary_answers);

                startActivity(intent);

            }
        });

    }
    private void populate_data_summary(String[] data_summary, RadioGroup[] radioGroup){

        for(int i = 0; i < radioGroup.length; i++){

            int selectedID = radioGroup[i].getCheckedRadioButtonId();

            RadioButton radioButton = (RadioButton)findViewById(selectedID);

            if(radioButton == null){
                data_summary[i] = "";
            }
            else {
                String selectedAnswer = radioButton.getText().toString();

                data_summary[i] = selectedAnswer;
            }

        }

        if(editText.getText().toString().length() < 1){
            data_summary[data_summary.length-1] = "";
        }
        else {
            data_summary[data_summary.length-1] = editText.getText().toString();
        }
    }
}
