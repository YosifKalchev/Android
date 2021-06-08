package com.example.quizproject.bottomRecView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class BottomRecViewAdapter extends RecyclerView.Adapter<BottomViewHolder> {

    private final List<String> data;

    public BottomRecViewAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public BottomViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View singleElement =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_bottom, parent, false);
        return new BottomViewHolder(singleElement);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BottomViewHolder holder, int position) {
        String title = data.get(position);
        holder.createSingleRow(title);
        holder.transferData(data);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
