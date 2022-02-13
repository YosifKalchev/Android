package com.example.videoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private ArrayList<VideoModel> data;
    private Context context;
    private VideoClickInterface videoClickInterface;

    public VideoAdapter(Context context, ArrayList<VideoModel> data, VideoClickInterface videoClickInterface) {
        this.data = data;
        this.context = context;
        this.videoClickInterface = videoClickInterface;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.video_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
            VideoModel videoModel = data.get(position);
            holder.fThumbnail.setImageBitmap(videoModel.getThumbnail());
            holder.itemView.setOnClickListener(
                    view -> videoClickInterface.onVideoClicked(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fThumbnail;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            fThumbnail = itemView.findViewById(R.id.imgThumbnail);
        }
    }

    public interface VideoClickInterface {
        void onVideoClicked(int position);
    }
}
