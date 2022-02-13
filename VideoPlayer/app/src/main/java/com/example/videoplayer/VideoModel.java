package com.example.videoplayer;

import android.graphics.Bitmap;

public class VideoModel {

    private String name;
    private String path;
    private Bitmap thumbnail;

    public VideoModel(String name, String path, Bitmap thumbnail) {
        this.name = name;
        this.path = path;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }
}