package com.example.quizproject.tools;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.TextView;

public class QuestionCountdownTimer {

    private final String text;

    public QuestionCountdownTimer(TextView text1, int seconds, String text) {
        this.text = text;
    }

    public void countdown(int Seconds, TextView txtView) {
        new CountDownTimer(Seconds * 1000 + 1000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisecondsLeft) {
                int seconds = (int) (millisecondsLeft / 1000);
                seconds = seconds % 60;
                txtView.setText(text + "\n" + seconds);
            }

            @SuppressLint("SetTextI18n")
            public void onFinish() {
                txtView.setText("Completed");
            }
        }.start();
    }
}
