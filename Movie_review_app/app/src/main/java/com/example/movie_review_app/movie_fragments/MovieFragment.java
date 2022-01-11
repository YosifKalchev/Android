package com.example.movie_review_app.movie_fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.movie_review_app.R;
import com.example.movie_review_app.models.Movie;
import com.example.movie_review_app.navigation_fragments.NavigationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MovieFragment extends NavigationFragment {

    private TextView txtView;
    private Movie movieInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        movieInfo = getArguments().getParcelable("selectedMovie");
        txtView = view.findViewById(R.id.txtName);
        txtView.setText(movieInfo.getName());
        ((ImageView) view.findViewById(R.id.imgPoster)).setImageResource(movieInfo.getImageRes());

        BottomNavigationView btmNavAvatar = view.findViewById(R.id.btmNav);
        btmNavAvatar.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_home: showHomeScreen(view); break;
                case R.id.action_crew: showCrewScreen(txtView, movieInfo); break;
                case R.id.action_review: showReviewScreen(txtView, movieInfo); break;
                case R.id.action_publish: showPublishScreen(txtView, movieInfo); break;
            } return true;
        });
    }
}
