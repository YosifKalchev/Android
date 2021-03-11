package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;


public class QuestionThreeFragment extends NavigatorFragment {



    public QuestionThreeFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_question_three, container, false);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);



        assert getArguments() != null;
        AtomicInteger correctAnswers = new AtomicInteger(getArguments().getInt("correct answers"));
        AtomicInteger totalAnswers = new AtomicInteger(getArguments().getInt("total answers"));

        int direction = R.id.action_questionThreeFragment_to_questionFourFragment;
        Button btnConfirm = (Button) view.findViewById(R.id.btnConfirmAnswer3);

        //this is a test code
        TextView test = view.findViewById(R.id.txtTest3);
        test.setText((correctAnswers.get() - 1) + " | " + (totalAnswers.get() - 1) + "" );

//CorrectAnswers.ANSWER_QUESTION_THREE.toString())
        btnConfirm.setOnClickListener(v -> {

            EditText editText = (EditText) view.findViewById(R.id.edtAnswer3);
            String answer = editText.getText().toString().toUpperCase();

            if (answer.equals("Q")) {
                onCorrectAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
            } else {
                onWrongAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}