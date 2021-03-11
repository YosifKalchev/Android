package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class QuestionSixFragment extends NavigatorFragment {

    public QuestionSixFragment() {

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

        int direction = R.id.action_questionSixFragment_to_resultFragment;
        Button btnConfirm = view.findViewById(R.id.btnConfirmAnswer6);

        CheckBox checkBox1 = view.findViewById(R.id.checkBox1);
        CheckBox checkBox2 = view.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = view.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = view.findViewById(R.id.checkBox4);
        CheckBox checkBox5 = view.findViewById(R.id.checkBox5);
        CheckBox checkBox6 = view.findViewById(R.id.checkBox6);
        CheckBox checkBox7 = view.findViewById(R.id.checkBox7);
        CheckBox checkBox8 = view.findViewById(R.id.checkBox8);

        CheckBox[] checkBoxes = new CheckBox[]{
                checkBox1, checkBox3, checkBox4, checkBox7,
                checkBox2, checkBox5, checkBox6, checkBox8
        };

        checkIfCorrectAnswerIsSelected(checkBox1);

        checkIfCorrectAnswerIsSelected(checkBox3);

        checkIfCorrectAnswerIsSelected(checkBox4);

        checkIfCorrectAnswerIsSelected(checkBox7);

        btnConfirm.setOnClickListener(v -> {

            int checkedBoxesCount = 0;
            int checkedCorrectAnswersCount = 0;

            for (CheckBox box : checkBoxes)
                if (box.isChecked()) {
                    checkedBoxesCount++;
                }

            if (checkedBoxesCount == 0) {
                Toast.makeText(v.getContext(), "You have not chosen answers", Toast.LENGTH_SHORT).show();
            } else {
                if (checkedBoxesCount > 4) {
                    Toast.makeText(v.getContext(), "You have selected too many answers", Toast.LENGTH_SHORT).show();
                } else {
                    CheckBox[] checkedCorrectBoxes = new CheckBox[] {
                            checkBox1, checkBox3, checkBox4, checkBox7
                    };

                    for (CheckBox box : checkedCorrectBoxes) {
                        if (box.isChecked()) {
                            checkedCorrectAnswersCount++;
                        }
                    }
                    onCorrectAnswerSelected(v, checkedCorrectAnswersCount, checkedBoxesCount,
                            correctAnswers, totalAnswers, direction, bundle);
                }
            }
        });

    }


    private void checkIfCorrectAnswerIsSelected(CheckBox checkBox1) {
        AtomicBoolean isCorrAnswerOneChecked = new AtomicBoolean(false);

        checkBox1.setOnClickListener(v -> isCorrAnswerOneChecked.set(checkBox1.isChecked()));
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_six, container, false);
    }
}
