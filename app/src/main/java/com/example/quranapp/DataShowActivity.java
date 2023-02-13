package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

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

    private void searchJsonAndUpdate(String surahName) throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        Log.d("ll", String.valueOf(obj));

//        try {
//            JSONObject obj = new JSONObject(loadJSONFromAsset());
//            JSONArray verseArray = obj.getJSONArray("verses");
//            for (int i = 0; i < verseArray.length(); i++) {
//                JSONObject verseDetail = verseArray.getJSONObject(i);
//                String surah = verseDetail.getString("englishName");
//                Log.d("searchJson", surah + " " + surah.length() + surahName + " " + surahName.length());
//                if (surah.equals(surahName)) {
//                    Log.d("searchJson", "inside if block");
//                    int num = verseDetail.getInt("number");
//                    String ayat = verseDetail.getString("text");
//                    String revType = verseDetail.getString("revelationType");
//                    int verseNum = verseDetail.getInt("numberInSurah");
//                    int parahNo = verseDetail.getInt("juz");
//                    String[] translations = {
//                            verseDetail.getString("UrduTranslation"),
//                            verseDetail.getString("UrduTafseer"),
//                            verseDetail.getString("EnglishTranslation"),
//                            verseDetail.getString("Englishtafseer"),
//                            verseDetail.getString("HindiTranslation"),
//                            verseDetail.getString("HindiTafseer"),
//                            verseDetail.getString("SindhiTranslation"),
//                            verseDetail.getString("SindhiTafseer"),
//                            verseDetail.getString("PushtoTransation"),
//                            verseDetail.getString("PushtoTafseer")
//                    };
//                    verses.add(new SurahVerse(num, ayat, revType, surah, verseNum, parahNo, translations));
//                    Log.d("searchJson", String.valueOf(adapter.getItemCount()));
//                    adapter.notifyItemRangeChanged(0, verses.size());
//                    //adapter.notifyItemChanged(verses.size() - 1);
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        if (!verses.isEmpty())
//            Log.d("searchJson", "Surah Found!!");
//        else
//            Log.d("searchJson", "Surah Not Found!! " + surahName);
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