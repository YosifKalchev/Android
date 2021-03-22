package com.example.movie_review_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_review_app.constants.Direction;
import com.example.movie_review_app.models.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final TextView txtTitle;
    private final TextView txtGrade;
    private List<Movie> data;
    private final Bundle bundle;



    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtGrade = itemView.findViewById(R.id.txtGrade);
        bundle = new Bundle();
    }

    @SuppressLint("SetTextI18n")
    public void createSingleRow(Movie movie, int position) {

        txtTitle.setText(movie.getName());
        txtGrade.setText(movie.getGrade().toString() + "/10");


        itemView.setOnClickListener(v -> {

            switch (position) {
                case 0 : navigateTo(0, Direction.START_TO_TROY); break;
                case 1 : navigateTo(1, Direction.START_TO_AVATAR); break;
                case 2 : navigateTo(2, Direction.START_TO_TAKEN); break;
                case 3 : navigateTo(3, Direction.START_TO_MORTAL_KOMBAT); break;
                case 4 : navigateTo(4, Direction.START_TO_BAD_BOYS); break;
            }
        });
    }


    private void navigateTo(int position, Direction direction) {

        String name = data.get(position).getName();
        String crew = data.get(position).getCrew().toString();
        String review = data.get(position).getReview().toString();
        String yearOfPublish = String.valueOf(data.get(position).getYearOfPublish());
        String grade = data.get(position).getGrade().toString();
        String id = String.valueOf(data.get(position).getId());


        ArrayList<String> transferItems = new ArrayList<>(
                Arrays.asList(name, crew, review, yearOfPublish, grade, id));
        bundle.putStringArrayList("items", transferItems);

        Navigation.findNavController(itemView).navigate(direction.getValue(), bundle);
    }


    public void transferData(List<Movie> data) {
        this.data = data;
    }
}
