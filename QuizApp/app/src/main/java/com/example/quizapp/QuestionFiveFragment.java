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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        Button btnConfirm = (Button) view.findViewById(R.id.btnConfirmAnswer6);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);


        //this is a test code
        TextView test = view.findViewById(R.id.txtTest5);
        test.setText((correctAnswers.get() - 1) + " | " + (totalAnswers.get() - 1) + "" );


        btnConfirm.setOnClickListener(v -> {


            if (radioGroup.getCheckedRadioButtonId() != -1)
            {
//                RadioButton checkedRadioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
//                RadioButton correctAnswer = v.findViewById(R.id.radioButton1);
//                String checkedButtonText = checkedRadioButton.getText().toString();
//                String correctButtonText = correctAnswer.getText().toString();

//
//                if (correctAnswer.isChecked()) {
                //todo execute this method only if the correct answer is selected
                    onCorrectAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
//                }
//                else {
//                    onWrongAnswerInserted(v, correctAnswers, totalAnswers, direction, bundle);
//                }

            } else {
                Toast.makeText(v.getContext(), "Choose an option", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
