package com.example.recycle_view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TextView txtTitle;
    private final View difficulty;
    private final TextView txtDone;

    public TaskViewHolder(@NonNull View itemView) {

        super(itemView);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        difficulty = itemView.findViewById(R.id.viewDifficulty);
        txtDone = itemView.findViewById(R.id.txtDone);
    }

    public void bindData(Task task) {



        txtTitle.setText(task.getTitle());

        Context context = itemView.getContext();

        int difficultyColor = getDifficultyColor(task);

        difficulty.setBackgroundColor(context.getColor(difficultyColor));
//        changeDoneView(task);
    }

    public void changeDoneView(Task task) {
        if (task.isDone()) {
            txtDone.setVisibility(View.VISIBLE);
        } else {
            txtDone.setVisibility(View.INVISIBLE);
        }
    }

    private int getDifficultyColor(Task task) {
        int difficultyColor = 0;
        switch (task.getDifficulty()) {
            case EASY: difficultyColor = R.color.easy_green; break;
            case MEDIUM: difficultyColor = R.color.medium_yellow; break;
            case HARD: difficultyColor = R.color.hard_red; break;
        }
        return difficultyColor;
    }
}
