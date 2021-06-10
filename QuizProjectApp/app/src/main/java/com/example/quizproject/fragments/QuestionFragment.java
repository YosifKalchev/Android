package com.example.quizproject.fragments;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.quizproject.R;
import com.example.quizproject.remote.models.quizApi.QuizApiService;
import com.example.quizproject.remote.models.quizApi.questions_models.ResponseModelForQuestions;

import org.jetbrains.annotations.NotNull;


import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class QuestionFragment extends Fragment {

//todo use the correct fields
    private TextView txtQuestionField;
    private TextView txtCorrectAnswer;
    private TextView txtGenerateQuestion;
    private TextView txtWrongAnswers;
    private TextView txtDifficulty;
    private TextView txtCategory;
    private QuizApiService serviceQuiz;
    private TextView txtAnswer2;
    private TextView txtAnswer3;
    private TextView txtAnswer4;

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
        loadQuestionFromApi(view);

        txtGenerateQuestion.setOnClickListener(v -> loadQuestionFromApi(view));

    }

    private void initView(View view) {

       //todo use the correct fields for variables

        txtGenerateQuestion = view.findViewById(R.id.txtGenerateQuestion);
        txtQuestionField = view.findViewById(R.id.txtQuestionField);
        txtCorrectAnswer = view.findViewById(R.id.txtCorrectAnswer);
        txtAnswer2 = view.findViewById(R.id.txtAnswOption2);
        txtAnswer3 = view.findViewById(R.id.txtAnswOption3);
        txtAnswer4 = view.findViewById(R.id.txtAnswOption4);


        setupQuizRetrofit();
    }

    private void setupQuizRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceQuiz = retrofit.create(QuizApiService.class);
    }

    private void loadQuestionFromApi(View view) {


            serviceQuiz.getQuestion().enqueue(new Callback<ResponseModelForQuestions>() {
                @Override
                public void onResponse(@NotNull Call<ResponseModelForQuestions> call, @NotNull Response<ResponseModelForQuestions> response) {
                    if (response.isSuccessful()) {
                        Log.e("MainFragment", "Call Succeeded");
                        ResponseModelForQuestions qrm = response.body();
                        for (int i = 0; i < Objects.requireNonNull(qrm).results.length; i++) {
                            Log.e("MainFragment", "Question:"+qrm.results[i].getCorrect_answer());

                            String[] wrAnswers = qrm.results[i].getIncorrect_answers();
                            txtAnswer2.setText(Html.fromHtml(wrAnswers[0]));
                            txtAnswer3.setText(Html.fromHtml(wrAnswers[1]));
                            txtAnswer4.setText(Html.fromHtml(wrAnswers[2]));

                            txtQuestionField.setText(Html.fromHtml(qrm.results[i].getQuestion()));
                            txtCorrectAnswer.setText(Html.fromHtml(qrm.results[i].getCorrect_answer()));


//todo fix answer fields not show the text inserted

                        }
                    } else {
                        Log.e("MainFragment", "Call Failed");
                    }
                }

                @Override
                public void onFailure(@NotNull Call<ResponseModelForQuestions> call, @NotNull Throwable t) {
                    Log.e("MainFragment", "Call Failed", t);
                }
            });


    }
}
