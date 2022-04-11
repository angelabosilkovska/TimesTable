package com.android.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.listView);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        int max = 20;
        int startingPosition = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);
        generateTimesTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;

                if (i<min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }
                else {
                    timesTableNumber = i;
                }
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> numbers = new ArrayList<String>();
        for(int j = 1; j <= 10; j++){
            numbers.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
        myListView.setAdapter(arrayAdapter);
    }
}