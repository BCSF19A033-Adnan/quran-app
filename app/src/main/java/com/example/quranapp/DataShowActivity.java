package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DataShowActivity extends AppCompatActivity {

    boolean isPara = false;
    int no;

    List<Verse> verseList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

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
            Log.d("op2", String.valueOf(no));
            try {
                getParrahVerses(no);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
        {
            no = Integer.parseInt(arr[1]);
            Log.d("op2", String.valueOf(no));
            try {
                getSurrahVerses(no);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

//        Toast.makeText(getApplicationContext(), "data is: "+line, Toast.LENGTH_SHORT).show();
        Log.d("op3", String.valueOf(verseList));

        recyclerView = findViewById(R.id.dataViewRecycler);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DataAdapter(getApplicationContext(), verseList) ;
        recyclerView.setAdapter(adapter);

    }

    private void getSurrahVerses(int no) throws JSONException {

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray verseArray = obj.getJSONArray("verses");
            for (int i = 0; i < verseArray.length(); i++) {
                JSONObject verseDetail = verseArray.getJSONObject(i);
                int surrahNo = verseDetail.getInt("surah_number");
                if (surrahNo == no) {
                    String surah = verseDetail.getString("englishName");
                    int num = verseDetail.getInt("number");
                    String ayat = verseDetail.getString("text");
                    Log.d("opp", String.valueOf(ayat));
                    String revType = verseDetail.getString("revelationType");
                    int verseNum = verseDetail.getInt("numberInSurah");
                    int parahNo = verseDetail.getInt("juz");
                    String[] translations = {
                            verseDetail.getString("UrduTranslation"),
                            verseDetail.getString("UrduTafseer"),
                            verseDetail.getString("EnglishTranslation"),
                            verseDetail.getString("Englishtafseer"),
                            verseDetail.getString("HindiTranslation"),
                            verseDetail.getString("HindiTafseer"),
                            verseDetail.getString("SindhiTranslation"),
                            verseDetail.getString("SindhiTafseer"),
                            verseDetail.getString("PushtoTransation"),
                            verseDetail.getString("PushtoTafseer")
                    };
                    verseList.add(new Verse(num, ayat, revType, surah, verseNum, parahNo, translations));
//                    adapter.notifyItemRangeChanged(0, verseList.size());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getParrahVerses(int no) throws JSONException {

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray verseArray = obj.getJSONArray("verses");
            for (int i = 0; i < verseArray.length(); i++) {
                JSONObject verseDetail = verseArray.getJSONObject(i);
                int parahNo = verseDetail.getInt("juz");
                if (parahNo == no) {
                    String surah = verseDetail.getString("englishName");
                    int num = verseDetail.getInt("number");
                    String ayat = verseDetail.getString("text");
                    String revType = verseDetail.getString("revelationType");
                    int verseNum = verseDetail.getInt("numberInSurah");
                    String[] translations = {
                            verseDetail.getString("UrduTranslation"),
                            verseDetail.getString("UrduTafseer"),
                            verseDetail.getString("EnglishTranslation"),
                            verseDetail.getString("Englishtafseer"),
                            verseDetail.getString("HindiTranslation"),
                            verseDetail.getString("HindiTafseer"),
                            verseDetail.getString("SindhiTranslation"),
                            verseDetail.getString("SindhiTafseer"),
                            verseDetail.getString("PushtoTransation"),
                            verseDetail.getString("PushtoTafseer")
                    };
                    verseList.add(new Verse(num, ayat, revType, surah, verseNum, parahNo, translations));
//                    adapter.notifyItemRangeChanged(0, verseList.size());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    // get json from file
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("QuranMetaData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}