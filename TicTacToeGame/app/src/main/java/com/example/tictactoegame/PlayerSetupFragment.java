package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class PlayerSetupFragment extends Fragment {

    private EditText fEdtPlayer1;
    private EditText fEdtPlayer2;
    private Button fBtnConfirm;
    private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players_setup, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = new Bundle();
        Button fBtnConfirm = initViews(view);
        String player1Name = fEdtPlayer1.getText().toString();
        String player2Name = fEdtPlayer2.getText().toString();
        String[] playerNames = {player1Name, player2Name};

        bundle.putStringArray("playerNames", playerNames);

        fBtnConfirm.setOnClickListener(view1 -> onButtonSubmitClicked(view));

    }

    private void onButtonSubmitClicked(View view) {


        Navigation
                .findNavController(view)
                .navigate(R.id.action_playerSetupFragment_to_gameDisplayFragment, bundle);
    }

    private Button initViews(@NonNull View view) {

        fBtnConfirm = view.findViewById(R.id.btnSubmit);
        fEdtPlayer1 = view.findViewById(R.id.edtPlayer1);
        fEdtPlayer2 = view.findViewById(R.id.edtPlayer2);
        return fBtnConfirm;
    }
}
