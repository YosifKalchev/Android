package com.example.quizproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.quizproject.R;
import com.example.quizproject.models.Game;
import com.example.quizproject.repos.GameRepository;

import org.jetbrains.annotations.NotNull;

public class GameInfoFragment extends Fragment {

    private TextView category1;
    private TextView category2;
    private TextView dateLastPlayed;
    private TextView topPlayerName;
    private ImageView diffMedium;
    private ImageView diffHard;
    private String gameTitle;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        assert getArguments() != null;
        gameTitle = getArguments().getString("title");
        Game currentGame = GameRepository.getInstance().getGameByName(gameTitle);

        setUpToolbar(view);
        initView(view);
        bindData(currentGame);
        setupButton(view);

    }

    private void setupButton(@NotNull View view) {
        Button btnPlayGame = view.findViewById(R.id.btnCreateGame);
        btnPlayGame.setOnClickListener(v ->
                Navigation
                        .findNavController(v)
                        .navigate(R.id.action_gameInfoFragment_to_playGameFragment));
    }

    private void bindData(Game game) {
        category1.setText(game.getFirstCategory());
        category2.setText(game.getSecondCategory());

        String gameDifficulty = game.getDifficulty();
        if (gameDifficulty.equals("hard")) {
            diffMedium.setVisibility(View.VISIBLE);
            diffHard.setVisibility(View.VISIBLE);
        }
        if (gameDifficulty.equals("medium")) {
            diffMedium.setVisibility(View.VISIBLE);
        }
    }

    private void initView(View view) {
        category1 = view.findViewById(R.id.txtCategory1);
        category2 = view.findViewById(R.id.txtCategory2);
        dateLastPlayed = view.findViewById(R.id.txtLastPlayedInfo);
        topPlayerName = view.findViewById(R.id.txtTopPlayerInfo);
        diffMedium = view.findViewById(R.id.imgDifficultyMedium);
        diffHard = view.findViewById(R.id.imgDifficultyHard);

    }

    private void setUpToolbar(@NotNull View view) {

        Toolbar toolbar = view.findViewById(R.id.toolbarGameTab);
        toolbar.setTitle(gameTitle);
        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_gameInfoFragment_to_mainFragment);

        });
        toolbar.inflateMenu(R.menu.menu_game_tb);
    }

    //todo create clickable rows:
    //todo 1) Last played -> GameHistory // 2) TopPlayed -> GameLeaderboardFragment
}
