package com.example.quranapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Verse> data;
    Context ctx;
    String lang="Arabic";

    public DataAdapter(Context ctx, List<Verse> data){
        this.inflater = LayoutInflater.from(ctx);
        this.data = data;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.data_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data

//        holder. spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//        {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//            {
//                lang = parent.getItemAtPosition(position).toString();
//                Log.d("k", lang);
//                onBindViewHolder(ViewHolder, position);
//            }
//            public void onNothingSelected(AdapterView<?> parent)
//            {
//                lang="Arabic";
//            }
//        });

        holder.verseText.setText(data.get(position).getText());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView verseText;
        Spinner spinnerLanguages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            verseText = itemView.findViewById(R.id.verse);
            spinnerLanguages = itemView.findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(ctx, R.array.languages, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinnerLanguages.setAdapter(adapter);

            spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    lang = parent.getItemAtPosition(position).toString();
                    Log.d("k", lang);

                    TextView t = (TextView) view;
                    if(lang.equals("Urdu"))
                    {
                        t.setText(data.get(position).getUrduTranslation());
                    }
                    else if(lang.equals("English"))
                    {
                        t.setText(data.get(position).getEnglishTranslation());
                    }
                    else if(lang.equals("Sindhi"))
                    {
                        t.setText(data.get(position).getSindhiTranslation());
                    }
                    else if(lang.equals("Hindi"))
                    {
                        t.setText(data.get(position).getHindiTranslation());
                    }
                    else if(lang.equals("Pushto"))
                    {
                        t.setText(data.get(position).getPushtoTranslation());
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });

        }
    }
}
