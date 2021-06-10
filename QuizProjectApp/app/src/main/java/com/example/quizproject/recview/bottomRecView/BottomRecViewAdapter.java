package com.example.quizproject.recview.bottomRecView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;
import com.example.quizproject.models.Game;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class BottomRecViewAdapter extends RecyclerView.Adapter<BottomViewHolder> {

    private final List<Game> data;

    public BottomRecViewAdapter(List<Game> data) {
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

        Game game = data.get(position);
        holder.bindData(game);
        holder.transferData(data);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
