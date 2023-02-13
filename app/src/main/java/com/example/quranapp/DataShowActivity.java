package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DataShowActivity extends AppCompatActivity {

    boolean isPara = false;
    int no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        Intent intent = getIntent();
        String line = intent.getStringExtra("data");

        Log.d("op1", line);

        String[] arr = line.split(" ");
        if(line.contains("Para"))
        {
            isPara=true;
            no = Integer.parseInt(arr[1]);
        }
        else
        {
            no = Integer.parseInt(arr[1]);
        }

        Toast.makeText(getApplicationContext(), "data is: "+line, Toast.LENGTH_SHORT).show();

    }
}