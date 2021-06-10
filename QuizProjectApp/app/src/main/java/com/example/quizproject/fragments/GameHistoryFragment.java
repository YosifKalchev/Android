package com.example.quizproject.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;


public class GameHistoryFragment extends Fragment {


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpToolbar(view);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_game, container, false);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //todo Create list of when the games is played and add the date after each game
    //todo show the list values on the screen


    private void setUpToolbar(@NotNull View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbarGameTab);
        toolbar.setTitle("Create game");
        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_createGameFragment_to_mainFragment);

        });
        toolbar.inflateMenu(R.menu.menu_game_tb);
    }
}
