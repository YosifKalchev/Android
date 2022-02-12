package com.example.tictactoegame.constants;

public enum WinType {


    COLUMN (1),
    ROW (2),
    NEG_DIAGONAL(3),
    POS_DIAGONAL (4)
    ;

    public final int value;

    WinType(int value) {
        this.value = value;
    }
}
