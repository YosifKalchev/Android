package com.example.movie_review_app.navigation_fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.movie_review_app.R;

public class SplashScreenFragment extends Fragment {

    public SplashScreenFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Handler handler = new Handler();
        handler.postDelayed(() -> Navigation
                .findNavController(view)
                .navigate(R.id.action_splashScreenFragment_to_startFragment), 5000);

    }
}

//TODO: 21.3.2021 г. Set up bottom navigation and use it to switch between cast and plot overview
//todo: set up fragments for all the movies and add them to nav_graph
//todo: improve switch logic for info-fragment navigation
//todo: design shaping and improvements
