package com.example.moviereviewmvvm.model;

public class MemeModel {


    String name;
    String url;

//    String id;
//    int width;
//    int height;
//    int box_count;


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public MemeModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
