package com.example.quranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Verse> data;
    Context ctx;

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

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView verseText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            verseText = itemView.findViewById(R.id.verse);

        }
    }
}
