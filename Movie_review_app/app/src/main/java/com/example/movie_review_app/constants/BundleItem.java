package com.example.movie_review_app.constants;

public enum BundleItem {

    NAME(0),
    CREW(1),
    REVIEW(2),
    YEAR_OF_PUBLISH(3),
    GRADE(4),
    ID(5),
    PICTURE (6)
    ;

    private final int value;

    BundleItem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
