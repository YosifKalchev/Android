package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import java.util.concurrent.atomic.AtomicInteger;

public class QuestionOneFragment extends NavigatorFragment {

    public QuestionOneFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View btnCorrect = view.findViewById(R.id.btnFalse);
        View btnIncorrect = view.findViewById(R.id.btnTrue);
        int direction = R.id.action_questionOneFragment_to_questionTwoFragment;

        AtomicInteger correctAnswers = new AtomicInteger(1);
        AtomicInteger totalAnswers = new AtomicInteger(1);


        onCorrectAnswerClicked(btnCorrect, correctAnswers, totalAnswers, direction, bundle);

        onWrongAnswerClicked(btnIncorrect, correctAnswers, totalAnswers, direction, bundle);
    }





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_one, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
