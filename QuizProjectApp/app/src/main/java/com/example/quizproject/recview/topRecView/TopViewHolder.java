package com.example.quizproject.recview.topRecView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;
import com.example.quizproject.models.Game;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopViewHolder extends RecyclerView.ViewHolder {

//todo create change logo option
//    private ImageView imgLogo;

    private List<Game> data;
    private ImageView imgDiffMedium;
    private ImageView imgDiffHard;
    private TextView txtGameTitle;
    private TextView txtCategoryOne;
    private TextView txtCategoryTwo;
    private View singleElement;
    private Bundle bundle = new Bundle();
    private TextView txtDate;



    public TopViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        viewInit(itemView);
        navigateToGameInfo();
    }

    public void transferData(List<Game> data) {
        this.data = data;
    }

    private void viewInit(View view) {
//        imgLogo = view.findViewById(R.id.imgLogo);
        imgDiffMedium = view.findViewById(R.id.imgDiffMedium);
        imgDiffHard = view.findViewById(R.id.imgDiffHard);
        txtGameTitle = view.findViewById(R.id.gameTitle);
        txtCategoryOne = view.findViewById(R.id.firstCategory);
        txtCategoryTwo = view.findViewById(R.id.secondCategory);
        singleElement = view.findViewById(R.id.item_top);
        txtDate = view.findViewById(R.id.txtLastPlayedInfo);
    }

    public void bindData(Game game) {

        bundle.putString("title", game.getTitle());

        txtGameTitle.setText(game.getTitle());
        txtCategoryOne.setText(game.getFirstCategory());
        txtCategoryTwo.setText(game.getSecondCategory());

        String gameDifficulty = game.getDifficulty();
        if (gameDifficulty.equals("hard")) {
            imgDiffHard.setVisibility(View.VISIBLE);
            imgDiffMedium.setVisibility(View.VISIBLE);
        }
        if (gameDifficulty.equals("medium")) {
            imgDiffMedium.setVisibility(View.VISIBLE);
        }
    }



    private void navigateToGameInfo() {

        singleElement.setOnClickListener(v ->
                Navigation.findNavController(v)
                        .navigate(R.id.action_mainFragment_to_gameInfoFragment, bundle));
    }
}
