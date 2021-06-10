package com.example.quizproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PrepareQuestionFragment extends Fragment {

    boolean clicked1 = false;
    boolean clicked2 = false;
    boolean clicked3 = false;
    boolean clicked4 = false;
    private Button btnPlayer1;
    private Button btnPlayer2;
    private Button btnPlayer3;
    private Button btnPlayer4;
    private int buttonsClickedCounter;
    private List<Boolean> clickers = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        initView(view);

        Navigation
                .findNavController(view)
                .navigate(R.id.action_prepareQuestionFragment_to_questionFragment);
//        checkForCompletion(view);

    }

//    private void checkForCompletion(View view) {
//        checkForClicks(btnPlayer1, clicked1);
//        checkForClicks(btnPlayer2, clicked2);
//        checkForClicks(btnPlayer3, clicked3);
//        checkForClicks(btnPlayer4, clicked4);
//        if (buttonsClickedCounter > 1) {
//            proceedToQuestion(view);
//        } else {
//            checkForCompletion(view);
//        }
//
//    }

//    private void proceedToQuestion(View view) {
//        Navigation
//                .findNavController(view)
//                .navigate(R.id.action_prepareQuestionFragment_to_questionFragment);
//    }

//    private void checkForClicks(Button btn, boolean clicked) {
//        btn.setOnClickListener(v -> {
//            if (!clicked) {
//                buttonsClickedCounter++;
//                Toast.makeText(getContext(), "Button clicked", Toast.LENGTH_SHORT).show();
//                clicked1 = true;
//            }
//        });
//    }

    private void initView(View view) {

        btnPlayer1 = view.findViewById(R.id.btnPlayer1);
        btnPlayer2 = view.findViewById(R.id.btnPlayer2);
        btnPlayer3 = view.findViewById(R.id.btnPlayer3);
        btnPlayer4 = view.findViewById(R.id.btnPlayer4);

    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_prepare, container, false);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
