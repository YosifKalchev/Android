package com.example.tictactoegame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.tictactoegame.R;
import com.example.tictactoegame.databinding.FragmentPlayersSetupBinding;

public class PlayerSetupFragment extends Fragment {

    FragmentPlayersSetupBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentPlayersSetupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSubmit.setOnClickListener(view1 -> onButtonSubmitClicked(view));
    }

    private void onButtonSubmitClicked(View view) {
        Bundle bundle = new Bundle();
        String player1Name = (!binding.edtPlayer1.getText().toString().isEmpty()) ? binding.edtPlayer1.getText().toString() : "Player 1";
        String player2Name = (!binding.edtPlayer2.getText().toString().isEmpty()) ? binding.edtPlayer2.getText().toString() : "Player 2";

        String[] playerNames = {player1Name, player2Name};

        bundle.putStringArray("playerNames", playerNames);

        Navigation
                .findNavController(view)
                .navigate(R.id.action_playerSetupFragment_to_gameDisplayFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
