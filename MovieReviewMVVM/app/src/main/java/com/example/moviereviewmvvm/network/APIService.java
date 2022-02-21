package com.example.moviereviewmvvm.network;

import com.example.moviereviewmvvm.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("get_memes")
    Call<List<MovieModel>> getMovieList();

    //todo fix API usage
}
