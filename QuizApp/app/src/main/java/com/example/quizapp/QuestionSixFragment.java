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
import androidx.navigation.Navigation;

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

//        //this is a test code
        TextView test = view.findViewById(R.id.txtTest6);
        test.setText((correctAnswers.get() - 1) + " | " + (totalAnswers.get() - 1) + "" );



        int direction = R.id.action_questionSixFragment_to_resultFragment;
        Button btnConfirm = (Button) view.findViewById(R.id.btnConfirmAnswer5);

        CheckBox checkBox1 = view.findViewById(R.id.checkBox1);
        CheckBox checkBox2 = view.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = view.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = view.findViewById(R.id.checkBox4);
        CheckBox checkBox5 = view.findViewById(R.id.checkBox5);
        CheckBox checkBox6 = view.findViewById(R.id.checkBox6);
        CheckBox checkBox7 = view.findViewById(R.id.checkBox7);
        CheckBox checkBox8 = view.findViewById(R.id.checkBox8);

        CheckBox[] checkBoxes = new CheckBox[] {
            checkBox1, checkBox3, checkBox4, checkBox7,
                checkBox2, checkBox5, checkBox6, checkBox8
        };

//        AtomicInteger numberOfBoxesChecked = new AtomicInteger();

        navigateToResultScreen(view, correctAnswers, totalAnswers, direction, btnConfirm, checkBoxes);


    }

    private void navigateToResultScreen(View view, AtomicInteger correctAnswers,
                                        AtomicInteger totalAnswers, int direction, Button btnConfirm,
                                        CheckBox[] checkBoxes) {
        btnConfirm.setOnClickListener(v -> {
            int answersGiven = findCountOfAnswersGiven(checkBoxes);

            if (answersGiven == 0) {
                Toast.makeText(v.getContext(), "You haven't select and answer!", Toast.LENGTH_SHORT).show();
                navigateToResultScreen(view, correctAnswers,
                         totalAnswers, direction, btnConfirm,
                        checkBoxes);
            } else {
                if (answersGiven > 4) {
                    Toast.makeText(v.getContext(), "You have selected too many answers!", Toast.LENGTH_SHORT).show();
                    navigateToResultScreen(view, correctAnswers,
                            totalAnswers, direction, btnConfirm,
                            checkBoxes);
                } else {
                    for (int i = 0; i < checkBoxes.length -1 ; i++) {
                        if (checkBoxes[i].isChecked()) {
                            correctAnswers.getAndIncrement();
                        }
                    }

                    for (CheckBox checkbox : checkBoxes) {
                        if (checkbox.isChecked()) {
                            totalAnswers.getAndIncrement();
                        }
                    }
                    bundle.putInt("correct answers", correctAnswers.get());
                    bundle.putInt("total answers", totalAnswers.get());
                    Navigation.findNavController(view).navigate(direction, bundle);
                }
            }

        });
    }

    private int findCountOfAnswersGiven(CheckBox[] checkBoxes) {
        int result = 0;
        for (CheckBox checkbox : checkBoxes) {
            if (checkbox.isChecked()) {
                result++;
            }
        } return result;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_six, container, false);
    }
}
