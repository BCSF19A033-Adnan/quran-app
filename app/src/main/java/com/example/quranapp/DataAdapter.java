package com.example.quranapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

        holder.verseText.setText(data.get(position).getText());


        holder.spinnerLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#85C5CD"));

                lang = parent.getItemAtPosition(position).toString();


//                    Toast.makeText(ctx, holder.getAdapterPosition()+" "+lang, Toast.LENGTH_SHORT).show();

                if(lang.equals("Urdu"))
                {
                    holder.transField.setText(data.get(holder.getAdapterPosition()).getUrduTranslation());
                }
                else if(lang.equals("English"))
                {
                    holder.transField.setText(data.get(holder.getAdapterPosition()).getEnglishTranslation());
                }
                else if(lang.equals("Sindhi"))
                {
                    holder.transField.setText(data.get(holder.getAdapterPosition()).getSindhiTranslation());
                }
                else if(lang.equals("Hindi"))
                {
                    holder.transField.setText(data.get(holder.getAdapterPosition()).getHindiTranslation());
                }
                else if(lang.equals("Pushto"))
                {
                    holder.transField.setText(data.get(holder.getAdapterPosition()).getPushtoTranslation());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView verseText;
        TextView transField;
        Spinner spinnerLanguages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            verseText = itemView.findViewById(R.id.verse);
            transField = itemView.findViewById(R.id.translationField);

            spinnerLanguages = itemView.findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(ctx, R.array.languages, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinnerLanguages.setAdapter(adapter);


        }
    }
}
