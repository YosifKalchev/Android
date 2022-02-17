package com.example.tictactoegame.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.tictactoegame.R;
import com.example.tictactoegame.databinding.FragmentGameDisplayBinding;

public class GameDisplayFragment  extends Fragment {

    FragmentGameDisplayBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnPlayAgain.setVisibility(View.GONE);
        binding.btnHome.setVisibility(View.GONE);

        assert getArguments() != null;
        String[] playerNames = getArguments().getStringArray("playerNames");

        if (playerNames != null) {
            binding.txtGameDisplay.setText((playerNames[0] +"'s turn"));
        }

        binding.btnPlayAgain.setOnClickListener(view1 -> onPlayButtonPlayAgainClicked());
        binding.btnHome.setOnClickListener(view1 -> onButtonHomeClicked(view));

        binding.ticTacToeBoard.setUpGame(binding.btnPlayAgain, binding.btnHome, binding.txtGameDisplay, playerNames);
    }

    private void onButtonHomeClicked(View view) {
        Navigation.findNavController(view).navigate(R.id.action_gameDisplayFragment_to_startFragment);
    }

    private void onPlayButtonPlayAgainClicked() {
        binding.ticTacToeBoard.resetGame();
        binding.ticTacToeBoard.invalidate();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentGameDisplayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
