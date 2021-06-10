package com.example.quizproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quizproject.R;

import org.jetbrains.annotations.NotNull;

public class CreateGameFragment extends Fragment {

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewInit(view);
        setUpToolbar(view);

        //todo set adapter for spinner and give it list of categories via API call
    }

    private void viewInit(@NotNull View view) {
        Spinner spnFirstCategories = view.findViewById(R.id.spnFirstCategorySelector);
        Spinner spnSecondCategories = view.findViewById(R.id.spnSecondCategorySelector);
        Spinner spnDifficultySelector = view.findViewById(R.id.spnGameDifficultySelector);
        Button btnCreateGame = view.findViewById(R.id.btnCreateGame);

        //todo set spinner values
        //todo set button clickListener and add the created game to GameRepository
    }

    private void setUpToolbar(@NotNull View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbarGameTab);
        toolbar.setTitle("Create game");
        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_createGameFragment_to_mainFragment);

        });
        toolbar.inflateMenu(R.menu.menu_game_tb);
    }
}
