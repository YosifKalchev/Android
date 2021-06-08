package com.example.quizproject.bottomRecView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BottomViewHolder extends RecyclerView.ViewHolder {


    private final TextView txtTitle;
    private List<String> data;



    public BottomViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitleBottom);
    }

    public void transferData(List<String> data) {
        this.data = data;
    }

    public void createSingleRow(String text) {
        txtTitle.setText(text);
    }


}
