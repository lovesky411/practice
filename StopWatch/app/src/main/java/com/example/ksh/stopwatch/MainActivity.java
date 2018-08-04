package com.example.ksh.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity  {

    private Chronometer mChroonometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChroonometer = (Chronometer) findViewById(R.id.chronoometer);

        Button start = (Button) findViewById(R.id.start_button);
        Button stop = (Button) findViewById(R.id.stop_button);
        Button reset = (Button) findViewById(R.id.reset_button);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChroonometer.setBase(SystemClock.elapsedRealtime());
                mChroonometer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChroonometer.stop();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChroonometer.setBase(SystemClock.elapsedRealtime());
                mChroonometer.start();
            }
        });


    }
}
