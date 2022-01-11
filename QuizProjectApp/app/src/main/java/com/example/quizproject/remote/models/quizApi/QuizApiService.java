package com.example.quizproject.remote.models.quizApi;

import com.example.quizproject.remote.models.quizApi.categories_models.ResponseModelForCategories;
import com.example.quizproject.remote.models.quizApi.questions_models.ResponseModelForQuestions;

import retrofit2.Call;
import retrofit2.http.GET;


public interface QuizApiService {

    //get questions
    @GET("api.php?amount=1&category=11&difficulty=hard&type=multiple")
    Call<ResponseModelForQuestions> getQuestion();

    //get categories
    @GET("api_category.php")
    Call<ResponseModelForCategories> getCategories();
}
