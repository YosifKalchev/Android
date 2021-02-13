package com.example.recycle_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {


    private final List<Task> data;

    public TaskAdapter(List<Task> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View singleElement = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.task_item, parent);

        TaskViewHolder viewHolder = new TaskViewHolder(singleElement);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
