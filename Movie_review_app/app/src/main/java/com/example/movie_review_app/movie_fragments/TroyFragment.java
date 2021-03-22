package com.example.movie_review_app.movie_fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.movie_review_app.R;
import com.example.movie_review_app.constants.Direction;
import com.example.movie_review_app.navigation_fragments.NavigationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class TroyFragment extends NavigationFragment {

    private TextView txtView;
    private ArrayList<String> movieInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_troy, container, false);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        movieInfo = getArguments().getStringArrayList("items");
        txtView = view.findViewById(R.id.txtTroy);


        BottomNavigationView btmNavTroy = view.findViewById(R.id.bmtNavTroy);
        btmNavTroy.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_home: showHomeScreen(view, Direction.TROY_TO_START.getValue()); break;
                case R.id.action_crew: showCrewScreen(txtView, movieInfo); break;
                case R.id.action_review: showReviewScreen(txtView, movieInfo); break;
                case R.id.action_publish: showPublishScreen(txtView, movieInfo); break;
            } return true;
        });
    }
}
//TODO Create fragments for all the movies.