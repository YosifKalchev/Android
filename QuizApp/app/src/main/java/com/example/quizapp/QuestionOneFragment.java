package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.concurrent.atomic.AtomicInteger;

public class QuestionOneFragment extends Fragment {

    public QuestionOneFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.btnTrue).setOnClickListener(this::advanceToNextQuestion);
        view.findViewById(R.id.btnFalse).setOnClickListener(this::advanceToNextQuestion);

    }


    private void advanceToNextQuestion(View view) {
        Navigation.findNavController(view).navigate(R.id.action_questionOneFragment_to_questionTwoFragment);
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
