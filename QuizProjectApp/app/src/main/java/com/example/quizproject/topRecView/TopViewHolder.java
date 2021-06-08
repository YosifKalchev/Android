package com.example.quizproject.topRecView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopViewHolder extends RecyclerView.ViewHolder {


    private final TextView txtTitle;
    private List<String> data;



    public TopViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitleTop);
    }

    public void transferData(List<String> data) {
        this.data = data;
    }

    public void createSingleRow(String text) {

        txtTitle.setText(text);
    }
}
