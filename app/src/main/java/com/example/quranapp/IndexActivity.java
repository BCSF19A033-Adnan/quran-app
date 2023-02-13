package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {

    List<String> parahList = new ArrayList<>();
    List<String> surrahList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Intent intent = getIntent();
        String searchCategory = intent.getStringExtra("category");

        initializeDataInList();
        recyclerView = findViewById(R.id.indexView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new IndexAdapter(getApplicationContext(), parahList) ;
        recyclerView.setAdapter(adapter);
    }

    private void initializeDataInList() {
        for(int i=1; i<=30; i++)
        {
            String st = "Parah ";
            st = st+i;
            parahList.add(st);
        }
    }
}