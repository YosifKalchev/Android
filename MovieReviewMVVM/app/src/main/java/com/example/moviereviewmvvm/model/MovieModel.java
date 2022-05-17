package com.example.moviereviewmvvm.model;

public class MovieMemeModel {

    //todo create the appropriate API model for the new API

    private String name;
    private String url;


    public MovieMemeModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }


}
