package com.example.quizproject.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quizproject.models.CurrentGame;
import com.example.quizproject.tools.MultipleChoiceQuestionsResult;
import com.example.quizproject.tools.QuestionCountdownTimer;
import com.example.quizproject.R;
import com.example.quizproject.tools.ThreadUtils;
import com.example.quizproject.repos.PlayerRepository;
import com.example.quizproject.repos.BooleanQuestionsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PrepareQuestionFragment extends Fragment {

//    private FragmentFirstRoundPutFingersBinding binding;
    private List<String> names;
    private int playersCount;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private TextView txtQuestionField;
    private Button btnPlayer1;
    private Button btnPlayer2;
    private Button btnPlayer3;
    private Button btnPlayer4;
    private int timerLimit;
    private String infoMessage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_prepare, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

        name1 = PlayerRepository.getInstance().getPlayers().get(0).getName();
        name2 = PlayerRepository.getInstance().getPlayers().get(1).getName();
        name3 = PlayerRepository.getInstance().getPlayers().get(2).getName();
        name4 = PlayerRepository.getInstance().getPlayers().get(3).getName();


        if (MultipleChoiceQuestionsResult.roundNumber == CurrentGame.getNumberOfMultipleChoiceQuestions()) {
            Navigation.findNavController(requireView()).navigate(R.id.action_prepareQuestionFragment_to_questionFragment);
//todo track this navigation
        } else {
            Random randomObject = new Random();
            int randNumber = randomObject.nextInt(5);

            timerLimit = 10;
            infoMessage = "answer in ...";
            startTimer(timerLimit, txtQuestionField,
                    infoMessage);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    setQuestion(randNumber);
                }
            }, 5000);

            names = new ArrayList<>();
            playersCount = 0;

            if (name1 != null) {
                btnPlayer1.setClickable(true);
                btnPlayer1.setOnClickListener(view1 -> onButtonAnswerClicked(name1));}
            if (name2 != null){
                btnPlayer2.setClickable(true);
                btnPlayer2.setOnClickListener(view1 -> onButtonAnswerClicked(name2));}
            if (name3 != null){
                btnPlayer3.setClickable(true);
                btnPlayer3.setOnClickListener(view1 -> onButtonAnswerClicked(name3));}
            if (name4 != null){
               btnPlayer4.setClickable(true);
                btnPlayer4.setOnClickListener(view1 -> onButtonAnswerClicked(name4));}

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Bundle fragmentData = new Bundle();
                    if (playersCount == 0) {
                        restartFragment();
                    } else if (playersCount == 1) {
                        fragmentData.putString("name1", names.get(0));
                        ThreadUtils.getHandlerInstance().post(() -> navigateToNextScreen(view, fragmentData));
                    } else if (playersCount >= 2) {
                        fragmentData.putString("name1", names.get(0));
                        fragmentData.putString("name2", names.get(1));
                        ThreadUtils.getHandlerInstance().post(() -> navigateToNextScreen(view, fragmentData));
                    }
                }

            }, CurrentGame.getPlayersResponseTime() *1000 + 5000);
        }
    }

    private void initView(View view) {

        btnPlayer1 = view.findViewById(R.id.btnPlayer1);
        btnPlayer2 = view.findViewById(R.id.btnPlayer2);
        btnPlayer3 = view.findViewById(R.id.btnPlayer3);
        btnPlayer4 = view.findViewById(R.id.btnPlayer4);
        txtQuestionField = view.findViewById(R.id.txtPreQuestion);
    }

    private void navigateToNextScreen(View view, Bundle fragmentData) {
        Navigation.findNavController(view).navigate(R.id.action_prepareQuestionFragment_to_questionFragment, fragmentData);
    }

    private void restartFragment() {
        assert getFragmentManager() != null;
        getFragmentManager()
                .beginTransaction()
                .detach(this)
                .attach(this)
                .commit();
    }


    private void setQuestion(int randNumber){
        int roundCounter = MultipleChoiceQuestionsResult.roundNumber;
        if (randNumber == 0) {

            Log.e("MainFragment", "Number is zero");
        } else {

            txtQuestionField.setText(BooleanQuestionsRepo.getInstance().getQuestion(roundCounter));
        }
        roundCounter++;
        MultipleChoiceQuestionsResult.roundNumber = roundCounter;
        MultipleChoiceQuestionsResult.randNumber = randNumber;
    }

    private void onButtonAnswerClicked(String name) {

        names.add(name);
        playersCount = playersCount + 1;

        if (name.equals(name1)) {
           btnPlayer1.setClickable(false);
        } else if(name.equals(name2)) {
            btnPlayer2.setClickable(false);
        } else if(name.equals(name3)) {
            btnPlayer3.setClickable(false);
        } else if(name.equals(name4)) {
            btnPlayer4.setClickable(false);
        }
    }

    private void startTimer(int sec, TextView tv, String text) {
        new QuestionCountdownTimer(tv, sec, text).countdown(sec, tv);
    }

    //todo fix this view to show up and function properly
}
