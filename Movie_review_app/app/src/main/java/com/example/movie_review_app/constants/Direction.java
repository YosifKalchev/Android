package com.example.movie_review_app.constants;

import com.example.movie_review_app.R;

public enum Direction {

    SPLASH_SCREEN_TO_START(R.id.action_splashScreenFragment_to_startFragment),
    START_TO_TROY(R.id.action_startFragment_to_troyFragment),
    TROY_TO_START(R.id.action_troyFragment_to_startFragment),
    START_TO_AVATAR(R.id.action_startFragment_to_avatarFragment),
    AVATAR_TO_START(R.id.action_avatarFragment_to_startFragment),
    START_TO_TAKEN(R.id.action_startFragment_to_takenFragment),
    TAKEN_TO_START(R.id.action_takenFragment_to_startFragment),
    START_TO_MORTAL_KOMBAT(R.id.action_startFragment_to_mortalKombatFragment),
    MORTAL_KOMBAT_TO_START(R.id.action_mortalKombatFragment_to_startFragment),
    START_TO_BAD_BOYS(R.id.action_startFragment_to_badBoysFragment),
    BAD_BOYS_TO_START(R.id.action_badBoysFragment_to_startFragment),
    START_TO_GODZILLA(R.id.action_startFragment_to_godzillaFragment),
    GODZILLA_TO_START(R.id.action_godzillaFragment_to_startFragment),
    START_TO_ZACK_SNYDER(R.id.action_startFragment_to_zackFragment),
    ZACK_SNYDER_TO_START(R.id.action_zackFragment_to_startFragment),
    START_TO_RUSH_HOUR_3(R.id.action_startFragment_to_rushHourFragment),
    RUSH_HOUR_3_TO_START(R.id.action_rushHourFragment_to_startFragment),
    START_TO_CLASH_OF_TITANS(R.id.action_startFragment_to_titansFragment),
    CLASH_OF_TITANS_TO_START(R.id.action_titansFragment_to_startFragment),
    START_TO_GLITTER(R.id.action_startFragment_to_glitterFragment),
    GLITTER_TO_START(R.id.action_glitterFragment_to_startFragment)
    ;

    int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
