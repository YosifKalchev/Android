package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class GameDisplayFragment  extends Fragment {

    private TicTacToeBoard ticTacToeBoard;

    private TextView fTxtGameDisplay;
    private Button fBtnHome;
    private Button fBtnPlayAgain;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        fBtnPlayAgain.setVisibility(View.GONE);
        fTxtGameDisplay.setVisibility(View.GONE);

        assert getArguments() != null;
        String[] playerNames = getArguments().getStringArray("playerNames");

        if (playerNames != null) {
            fTxtGameDisplay.setText((playerNames[0]));
        }
//        String[] playerNames = {"yosko", "penchi"};
//todo fix getting the names by debbuging

        fBtnPlayAgain.setOnClickListener(view1 -> onPlayButtonPlayAgainClicked());
        fBtnHome.setOnClickListener(view1 -> onButtonHomeClicked(view));

        ticTacToeBoard.setUpGame(fBtnPlayAgain, fBtnHome, fTxtGameDisplay, playerNames);
    }

    private void onButtonHomeClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.action_gameDisplayFragment_to_startFragment);
    }

    private void onPlayButtonPlayAgainClicked() {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    private void initViews(View view) {
        fTxtGameDisplay = view.findViewById(R.id.txtGameDisplay);
        fBtnHome = view.findViewById(R.id.btnHome);
        fBtnPlayAgain = view.findViewById(R.id.btnPlayAgain);
        ticTacToeBoard = view.findViewById(R.id.ticTacToeBoard);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_display, container, false);
    }
}
