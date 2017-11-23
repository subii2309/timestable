package com.example.subin.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesList;

    public void generateTimesTable(int timesTable){



        ArrayList<String> timesTableContent = new ArrayList<String>();//contents in teh time table
        for (int i =1; i<=10; i++){ //values to be added
            timesTableContent.add(Integer.toString(i * timesTable));//is the multiplying value from 1 to 10, and timestable value is the one got from the seekbar
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesList.setAdapter(arrayAdapter); 
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekBar = (SeekBar) findViewById(R.id.timesTableSeekBar); //get the seekbar

       timesList = (ListView) findViewById(R.id.timesList);//get the list

        timesTableSeekBar.setMax(20);//max value for seekbar 20

        timesTableSeekBar.setProgress(10);//currentpos, progress is 10

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //when seekbar is clicked
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//on chnaging it it shud go until 1 and not to 0

                int min = 1;//create a variable with value 1
                int timestable;//jus another variable
                if (i < min) { //if the seekbar value becomes less than one

                    timestable = min; //then timestable value ll be 1
                    timesTableSeekBar.setProgress(min);//and the seekbar progress value shud also be in one and not go to 0

                } else {
                    timestable = i; //if not the value to be the value of the progrss
                }

                generateTimesTable(timestable); //call this method when the seekbar is changed each time
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);//this is to show that the intial table to be 10

    }
}
