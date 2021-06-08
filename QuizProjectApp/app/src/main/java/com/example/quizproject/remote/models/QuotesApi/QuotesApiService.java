package com.example.quizproject.remote.models.QuotesApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuotesApiService {

    //get quotes
    @GET("quotes?limit=10")
    Call<GenresResponseModel> getQuotes();

    //get all genres
    @GET("genres")
    Call<GenresResponseModel> getAllGenres();
}
