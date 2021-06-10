package com.example.quizproject.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;
import com.example.quizproject.models.Game;
import com.example.quizproject.recview.bottomRecView.BottomRecViewAdapter;
import com.example.quizproject.repos.GameRepository;
import com.example.quizproject.recview.topRecView.TopRecViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MainFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        createTopRecView(view);
        createBottomRecView(view);

        FloatingActionButton floatingButton = view.findViewById(R.id.floatingActionButton);
        floatingButton.setOnClickListener(v ->
                Navigation.findNavController(view)
                        .navigate(R.id.action_mainFragment_to_createGameFragment));

            }



    private void createTopRecView(View view) {

        RecyclerView topRecyclerView = view.findViewById(R.id.topRecView);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        TopRecViewAdapter topAdapter = new TopRecViewAdapter(GameRepository.getInstance().getGames());
        topRecyclerView.setAdapter(topAdapter);
    }

    private void createBottomRecView(View view) {

        List<Game> bottomS = GameRepository.getInstance().getGames();
        RecyclerView bottomRecyclerView = view.findViewById(R.id.bottomRecView);
        bottomRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        BottomRecViewAdapter bottomAdapter = new BottomRecViewAdapter(bottomS);
        bottomRecyclerView.setAdapter(bottomAdapter);
    }

    //todo create directions to all toolbar back arrows!!! (global toolbar interface)


}
