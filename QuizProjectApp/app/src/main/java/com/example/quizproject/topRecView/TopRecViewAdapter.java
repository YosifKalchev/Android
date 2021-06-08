package com.example.quizproject.topRecView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopRecViewAdapter extends RecyclerView.Adapter<TopViewHolder> {

    private final List<String> data;

    public TopRecViewAdapter(List<String> data) {
        this.data = data;
    }


    @NotNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View singleElement =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_top, parent, false);
        return new TopViewHolder(singleElement);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopViewHolder holder, int position) {

        String title = data.get(position);
        holder.createSingleRow(title);
        holder.transferData(data);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
