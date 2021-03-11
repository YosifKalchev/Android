package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.concurrent.atomic.AtomicInteger;

public class QuestionFourFragment extends NavigatorFragment {
    public QuestionFourFragment() {
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;

        AtomicInteger correctAnswers = new AtomicInteger(getArguments().getInt("correct answers"));
        AtomicInteger totalAnswers = new AtomicInteger(getArguments().getInt("total answers"));

        int direction = R.id.action_questionFourFragment_to_questionFiveFragment;
        Button btnConfirm = (Button) view.findViewById(R.id.btnConfirmAnswer4);


        //this is a test code
        TextView test = view.findViewById(R.id.txtTest4);
        test.setText((correctAnswers.get() - 1) + " | " + (totalAnswers.get() - 1) + "" );

        btnConfirm.setOnClickListener(v -> {

            EditText editText = (EditText) view.findViewById(R.id.edtAnswer4);
            String answer = editText.getText().toString().toUpperCase();

            if (answer.equals("1234")) {
                onCorrectAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
            } else {
                onWrongAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
            }


        });


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_four, container, false);



    }
}
