package com.example.quizproject.fragments;

import android.annotation.SuppressLint;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;
import com.example.quizproject.bottomRecView.BottomRecViewAdapter;
import com.example.quizproject.repos.GameRepository;
import com.example.quizproject.topRecView.TopRecViewAdapter;

import org.jetbrains.annotations.NotNull;

import java.text.Format;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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

            }



    private void createTopRecView(View view) {

        RecyclerView topRecyclerView = view.findViewById(R.id.topRecView);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        TopRecViewAdapter topAdapter = new TopRecViewAdapter(GameRepository.getInstance().getGames());
        topRecyclerView.setAdapter(topAdapter);
    }

    private void createBottomRecView(View view) {

        List<String> bottomS = Arrays.asList("Bottom 1", "Bottom 2",
                "Bottom 3", "4", "5", "6");
        RecyclerView bottomRecyclerView = view.findViewById(R.id.bottomRecView);
        bottomRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        BottomRecViewAdapter bottomAdapter = new BottomRecViewAdapter(bottomS);
        bottomRecyclerView.setAdapter(bottomAdapter);
    }

    //todo create directions to all toolbar back arrows!!! (global toolbar interface)


}
