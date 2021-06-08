package com.example.quizproject.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quizproject.R;
import com.example.quizproject.remote.models.QuotesApi.GenresResponseModel;
import com.example.quizproject.remote.models.QuotesApi.QuotesApiService;
import com.example.quizproject.remote.models.quizApi.QuizApiService;
import com.example.quizproject.remote.models.quizApi.QuizResponseModel;

import org.jetbrains.annotations.NotNull;


import java.util.Arrays;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class QuestionFragment extends Fragment {


    private TextView txtQuestionField;
    private TextView txtCorrectAnswer;
    private TextView txtWrongAnswers;
    private TextView txtDifficulty;
    private TextView txtCategory;
    private Button btnGenerateQuestion;
    private QuotesApiService serviceQuotes;
    private QuizApiService serviceQuiz;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable
            Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //todo move this in question fragment
        initView(view);
        loadQuestionFromApi();

        btnGenerateQuestion.setOnClickListener(view1 -> loadQuestionFromApi());
    }

    private void initView(View view) {

        txtQuestionField = view.findViewById(R.id.txtQuestionField);
        txtCorrectAnswer = view.findViewById(R.id.txtCorrectAnswer);
        txtWrongAnswers = view.findViewById(R.id.txtWrongAnswers);
        txtDifficulty = view.findViewById(R.id.txtDifficulty);
        txtCategory = view.findViewById(R.id.txtCategory);
        btnGenerateQuestion = view.findViewById(R.id.btnGenerateQuestion);

        setupQuotesRetrofit();
        setupQuizRetrofit();
    }

    private void setupQuizRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceQuiz = retrofit.create(QuizApiService.class);
    }

    private void setupQuotesRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://quote-garden.herokuapp.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceQuotes = retrofit.create(QuotesApiService.class);
    }


    private void loadQuestionFromApi() {


            serviceQuiz.getQuestion().enqueue(new Callback<QuizResponseModel>() {
                @Override
                public void onResponse(@NotNull Call<QuizResponseModel> call, @NotNull Response<QuizResponseModel> response) {
                    if (response.isSuccessful()) {
                        QuizResponseModel qrm = response.body();
                        for (int i = 0; i < Objects.requireNonNull(qrm).results.length; i++) {
                            Log.e("MainFragment", "Question:"+qrm.results[i].getCorrect_answer());
                            txtQuestionField.setText(qrm.results[i].getQuestion());
                            txtCategory.setText(qrm.results[i].getCategory());
                            txtCorrectAnswer.setText(qrm.results[i].getCorrect_answer());
                            txtWrongAnswers.setText(Arrays.toString(qrm.results[i].getIncorrect_answers()));
                            txtDifficulty.setText(qrm.results[i].getDifficulty());
                        }
                    } else {
                        Log.e("MainFragment", "Call Failed");
                    }
                }

                @Override
                public void onFailure(@NotNull Call<QuizResponseModel> call, @NotNull Throwable t) {
                    Log.e("MainFragment", "Call Failed", t);
                }
            });


    }

    private void loadQuotesFromApi() {

        serviceQuotes.getAllGenres().enqueue(new Callback<GenresResponseModel>() {
            @Override
            public void onResponse(@NotNull Call<GenresResponseModel> call, @NotNull Response<GenresResponseModel> response) {
                if (response.isSuccessful()) {
                    GenresResponseModel responseModel = response.body();
                    for (int i = 0; i < Objects.requireNonNull(responseModel).data.length; i++) {
                        Log.e("MainFragment", "Genre:"+responseModel.data[i]);
                    }
                    txtQuestionField.setText(responseModel.data[12]);
                } else {
                    Log.e("MainFragment", "Call Failed");
                }
            }

            @Override
            public void onFailure(@NotNull Call<GenresResponseModel> call, @NotNull Throwable t) {
                Log.e("MainFragment", "Call Failed", t);
            }
        });



    }
}
