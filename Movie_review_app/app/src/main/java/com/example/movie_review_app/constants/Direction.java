package com.example.movie_review_app.constants;

import com.example.movie_review_app.R;

public enum Direction {

    //TODO Fill the constants values with actions from nav_graph

    START_TO_TROY(R.id.action_startFragment_to_troyFragment),
    TROY_TO_START(R.id.action_troyFragment_to_startFragment),
    START_TO_AVATAR(11),
    AVATAR_TO_START(11),
    START_TO_TAKEN(12),
    TAKEN_TO_START(12),
    START_TO_MORTAL_KOMBAT(13),
    MORTAL_KOMBAT_TO_START(13),
    START_TO_BAD_BOYS(14),
    BAD_BOYS_TO_START(14)
    ;

    int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
