package com.example.moviereviewmvvm.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviereviewmvvm.databinding.RvItemBinding;
import com.example.moviereviewmvvm.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private final Context context;
    private List<MovieModel> data;

    public MovieListAdapter(Context context, List<MovieModel> data) {
        this.context = context;
        this.data = data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RvItemBinding rvItemBinding;

        public ViewHolder (@NonNull RvItemBinding rvItemBinding) {
            super(rvItemBinding.getRoot());
            this.rvItemBinding = rvItemBinding;
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<MovieModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        RvItemBinding rvItemBinding = RvItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(rvItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.ViewHolder holder, int position) {
        holder.rvItemBinding.tvRowItemText.setText(data.get(position).getName());
        Glide.with(context)
                .load(data.get(position).getUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.rvItemBinding.ivRowItemImage);
    }

    @Override
    public int getItemCount() {

        if (this.data != null) {
            return data.size();
        }
        return 0;
    }
}
