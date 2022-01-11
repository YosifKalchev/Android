package com.example.quizproject.recview.bottomRecView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizproject.R;
import com.example.quizproject.models.Game;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BottomViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgLogo;
    private TextView txtTitle;
    private TextView txtDate;
    private List<Game> data;



    public BottomViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initView(itemView);

    }

    private void initView(View itemView) {
        imgLogo = itemView.findViewById(R.id.imgBtmLogo);
        txtTitle = itemView.findViewById(R.id.txtBtmGameTitle);
        txtDate = itemView.findViewById(R.id.txtBtmDate);
    }


    public void bindData(Game game) {

        txtTitle.setText(game.getTitle());
        txtDate.setText(game.getDateLastPlayed());

    }

    public void transferData(List<Game> data) {
        this.data = data;
    }

    public void createSingleRow(String text) {
        txtTitle.setText(text);
    }


}
