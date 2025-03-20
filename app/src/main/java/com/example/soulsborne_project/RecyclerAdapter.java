package com.example.soulsborne_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final List<Soulsborne> itemList; // List to hold data for RecyclerView
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(Context context, List<Soulsborne> itemList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.itemList = itemList;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.soulsborneitems_layout, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        /* Bind the data to the views in the ViewHolder */
        Soulsborne item = itemList.get(position);
        holder.name.setText(item.getName());
        holder.year.setText("Release year: " + item.getYear());
        holder.difficulty.setText("Difficulty: " + item.getDifficulty());
        holder.rating.setText("Rating: " + item.getRating());
        holder.runtime.setText("Runtime: " + item.getRuntime());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, year, difficulty, rating, runtime;

        /* Initialize the TextViews by finding them in the item_layout */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            year = itemView.findViewById(R.id.year);
            difficulty = itemView.findViewById(R.id.difficulty);
            rating = itemView.findViewById(R.id.rating);
            runtime = itemView.findViewById(R.id.runtime);
        }
    }
}
