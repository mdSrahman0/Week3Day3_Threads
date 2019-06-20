// Use Java Thread/Runnables to calculate pi to 12 digits

package com.example.week3day3_threads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CalculatePie extends AppCompatActivity {

    TextView tvDisplay;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_pie);
        tvDisplay = findViewById(R.id.tvDisplay);
        intent = getIntent();
    }

    public void onClick(View view) {
        Log.d("TAG", "onClick: ");
        Runnable thread = new Runnable() {
            @Override
            public void run() {
                // We use an infinite sequence to calculate to calculate pi: 1 - 1/3 + 1/5 - 1/7.....
                double pi = 0;
                double s = 1;
                int n = 1000;
                for(int i = 1; i < n; i=1+2) {
                    pi += s/i;
                    s = -s;
                }
                double finalPi = pi*4;
                Log.d("TAG", "run: " + finalPi);
            }
        };
        //Thread thread = new Thread(runnable());
        //new Thread(thread).start();
    }
}
