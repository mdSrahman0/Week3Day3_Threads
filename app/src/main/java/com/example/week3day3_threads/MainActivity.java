// Use AsyncTask to sort an array of 1000 randomly generated numbers

package com.example.week3day3_threads;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Async.AsyncCallback{
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
        tvDisplay.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btGenerate:
                Async asyncTask = new Async(this);
                asyncTask.execute("");
                break;
            case R.id.btPie:
                Intent i = new Intent(this, CalculatePie.class);
                startActivity(i);
        } // end switch
    }

    @Override
    public void returnString(String string) {
        tvDisplay.setText(string);
    }
}
