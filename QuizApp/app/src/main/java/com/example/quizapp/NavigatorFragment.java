package com.example.quizapp;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.concurrent.atomic.AtomicInteger;

public class NavigatorFragment extends Fragment {
    public NavigatorFragment() {
        bundle = new Bundle();
    }

    Bundle bundle;


    public static void onCorrectAnswerClicked(View view, AtomicInteger correctAnswers, AtomicInteger totalAnswers,
                                              int direction, Bundle bundle) {
        view.setOnClickListener(v -> {
            correctAnswers.getAndIncrement();
            totalAnswers.getAndIncrement();
            bundle.putInt("correct answers", correctAnswers.get());
            bundle.putInt("total answers", totalAnswers.get());
            Navigation.findNavController(v).navigate(direction, bundle);
        });
    }

    public static void onWrongAnswerClicked(View view, AtomicInteger correctAnswers, AtomicInteger totalAnswers,
                                            int direction, Bundle bundle) {
        view.setOnClickListener(v -> {
            totalAnswers.getAndIncrement();
            bundle.putInt("correct answers", correctAnswers.get());
            bundle.putInt("total answers", totalAnswers.get());
            Navigation.findNavController(v).navigate(direction, bundle);
        });
    }

    public static void onCorrectAnswerInserted(View view, AtomicInteger correctAnswers, AtomicInteger totalAnswers,
                                              int direction, Bundle bundle) {
            correctAnswers.getAndIncrement();
            totalAnswers.getAndIncrement();
            bundle.putInt("correct answers", correctAnswers.get());
            bundle.putInt("total answers", totalAnswers.get());
            Navigation.findNavController(view).navigate(direction, bundle);
    }

    public static void onWrongAnswerInserted(View view, AtomicInteger correctAnswers, AtomicInteger totalAnswers,
                                               int direction, Bundle bundle) {
        totalAnswers.getAndIncrement();
        bundle.putInt("correct answers", correctAnswers.get());
        bundle.putInt("total answers", totalAnswers.get());
        Navigation.findNavController(view).navigate(direction, bundle);
    }

    public static void onCorrectAnswerSelected(
            View view, int numberOfCorrectAnswersGiven, int numberOfTotalAnswersGiven,
            AtomicInteger correctAnswers, AtomicInteger totalAnswers, int direction, Bundle bundle) {

        totalAnswers.getAndAdd(numberOfTotalAnswersGiven - 1);
        correctAnswers.getAndAdd(numberOfCorrectAnswersGiven - 1);
        bundle.putInt("correct answers", correctAnswers.get());
        bundle.putInt("total answers", totalAnswers.get());
        Navigation.findNavController(view).navigate(direction, bundle);
    }
}
