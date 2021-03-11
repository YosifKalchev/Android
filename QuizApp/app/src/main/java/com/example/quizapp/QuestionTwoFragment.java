package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;


public class QuestionTwoFragment extends NavigatorFragment {


  public QuestionTwoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_question_two, container, false);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        AtomicInteger correctAnswers = new AtomicInteger(getArguments().getInt("correct answers"));
        AtomicInteger totalAnswers = new AtomicInteger(getArguments().getInt("total answers"));

        View btnCorrect = view.findViewById(R.id.btnTrue2);
        View btnIncorrect = view.findViewById(R.id.btnFalse2);
        int direction = R.id.action_questionTwoFragment_to_questionThreeFragment;

        //this is a test code
        TextView test = view.findViewById(R.id.txtTest2);
        test.setText((correctAnswers.get() - 1) + " | " + (totalAnswers.get() - 1) + "" );


        onCorrectAnswerClicked(btnCorrect, correctAnswers, totalAnswers, direction, bundle);

        onWrongAnswerClicked(btnIncorrect, correctAnswers, totalAnswers, direction, bundle);

    }
}