package com.example.movie_review_app;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_review_app.models.Movie;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final TextView txtTitle;
    private final TextView txtGrade;



    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtGrade = itemView.findViewById(R.id.txtGrade);
    }

    @SuppressLint("SetTextI18n")
    public void createSingleRow(Movie movie, int position) {

        txtTitle.setText(movie.getName());
        txtGrade.setText(movie.getGrade().toString());


        itemView.setOnClickListener(v -> {

            switch (position) {
                case 0 : navigateToZero(); break;
                case 1 : navigateToOne(); break;
            }


        });
    }

    private void navigateToOne() {
        Toast.makeText(itemView.getContext(), "Well Done", Toast.LENGTH_SHORT).show();

    }

    private void navigateToZero() {
        Navigation.findNavController(itemView).navigate(R.id.action_startFragment_to_troyFragment);
    }
}
