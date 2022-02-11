package com.example.intlistsorter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArrayListAdapter extends RecyclerView.Adapter<ArrayListAdapter.ArrayViewHolder> {

    List<String> data;


    ArrayListAdapter(List<String> data) {
        this.data = data;
    }



    @NonNull
    @Override
    public ArrayListAdapter.ArrayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rec_item, parent, false);
        return new ArrayListAdapter.ArrayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayListAdapter.ArrayViewHolder holder, int position) {
        holder.txtView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ArrayViewHolder extends RecyclerView.ViewHolder {

        TextView txtView = itemView.findViewById(R.id.txtItem);
        public ArrayViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
