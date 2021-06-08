package com.example.quizproject.remote.models.quizApi;

import retrofit2.Call;
import retrofit2.http.GET;


public interface QuizApiService {

    //get questions
    @GET("api.php?amount=1&category=11&difficulty=hard&type=multiple")
    Call<QuizResponseModel> getQuestion();
}
