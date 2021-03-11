package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class QuestionFiveFragment extends NavigatorFragment {
    public QuestionFiveFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_five, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        assert getArguments() != null;

        AtomicInteger correctAnswers = new AtomicInteger(getArguments().getInt("correct answers"));
        AtomicInteger totalAnswers = new AtomicInteger(getArguments().getInt("total answers"));

        int direction = R.id.action_questionFiveFragment_to_questionSixFragment;
        Button btnConfirm = view.findViewById(R.id.btnConfirmAnswer5);

        RadioButton btnCorrectAnswer = view.findViewById(R.id.radioButton1);
        AtomicBoolean isCorrectAnswerGiven = new AtomicBoolean(false);

        btnCorrectAnswer.setOnClickListener(v -> {
            isCorrectAnswerGiven.set(btnCorrectAnswer.isChecked());
        });

        btnConfirm.setOnClickListener(v -> {
            if (isCorrectAnswerGiven.get()) {
                onCorrectAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
            } else {
                onWrongAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
            }
        });

    }
}
