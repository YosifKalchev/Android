package com.example.quizproject.topRecView;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;
import com.example.quizproject.models.Game;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopRecViewAdapter extends RecyclerView.Adapter<TopViewHolder> {

    private final List<Game> data;

    public TopRecViewAdapter(List<Game> data) {
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull @NotNull TopViewHolder holder, int position) {


        Game game = data.get(position);
        holder.bindData(game);
        holder.transferData(data);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
