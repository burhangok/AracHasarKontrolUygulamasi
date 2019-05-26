package com.burhangok.arahasarkontrol;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    TextView resultTV;
    int countOfDamage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        resultTV =findViewById(R.id.result);

        countOfDamage=getIntent().getIntExtra("count",0);

        if(countOfDamage>5) {
            resultTV.setText("ARACINIZ PERT DURUMDADIR!");
            resultTV.setTextColor(Color.RED);
        }

        else {

            resultTV.setText("ARACINIZ ONARIMA ALINACAKTIR.");
            resultTV.setTextColor(Color.GREEN);
        }

    }
}
