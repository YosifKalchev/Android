package com.example.recycle_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        View singleElement =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.task_item, parent, false);

        return new TaskViewHolder(singleElement);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

        Task task = data.get(position);
        holder.bindData(task);

        holder.changeDoneView(task);
        holder.itemView.setOnClickListener(View -> {
            if (!task.isDone()) {
                task.setDone(true);
                holder.changeDoneView(task);
            } else {
                removeRow(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void removeRow(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }
}
