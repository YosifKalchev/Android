package com.example.movie_review_app.navigation_fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movie_review_app.MovieAdapter;
import com.example.movie_review_app.R;
import com.example.movie_review_app.constants.Crew;
import com.example.movie_review_app.constants.Grade;
import com.example.movie_review_app.constants.Review;
import com.example.movie_review_app.models.Movie;
import java.util.Arrays;
import java.util.List;

public class StartFragment extends Fragment {

    RecyclerView recyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Movie movie1 = new Movie("Troy", 2004, Review.TROY, Grade.VERY_GOOD,
                Crew.TROY_CAST);
        Movie movie2 = new Movie("Avatar", 2009, Review.AVATAR, Grade.SUPERIOR,
                Crew.AVATAR_CAST);
        Movie movie3 = new Movie("Taken", 2008, Review.TAKEN, Grade.EXCELLENT,
                Crew.TAKEN_CAST);
        Movie movie4 = new Movie("Mortal Kombat", 2021, Review.MORTAL_KOMBAT,
                Grade.OUTSTANDING, Crew.MORTAL_KOMBAT_CAST);
        Movie movie5 = new Movie("Bad Boys", 1995, Review.BAD_BOYS, Grade.GOOD,
                Crew.BAD_BOYS_CAST);


        List<Movie> movies =  Arrays.asList(movie1, movie2, movie3, movie4, movie5);
        createRecyclerView(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter adapter = new MovieAdapter(movies);

        recyclerView.setAdapter(adapter);

    }

    private void createRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recMovieList);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
