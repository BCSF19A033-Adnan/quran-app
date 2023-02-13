package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView parah,surrah;
    String browseCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parah = findViewById(R.id.byParrah);
        surrah = findViewById(R.id.bySurrah);

        parah.setOnClickListener(this);
        surrah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.byParrah:
                browseCategory = "p";
                loadIndex();
                break;
            case R.id.bySurrah:
                browseCategory = "s";
                loadIndex();
                break;
        }
    }

    private void loadIndex() {
        Intent intent = new Intent(getApplicationContext(), IndexActivity.class);
        if(browseCategory.equals("p"))
        {
            intent.putExtra("category","p");
        }
        else
        {
            intent.putExtra("category","s");
        }
        startActivity(intent);
    }
}