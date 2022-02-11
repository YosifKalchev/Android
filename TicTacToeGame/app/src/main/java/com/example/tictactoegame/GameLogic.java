package com.example.tictactoegame;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {

    private static final int BOARD_SIZE = 3;
    private int [][] gameboard;
    private Button btnPlayAgain;
    private String[] playerNames = {"Player 1", "Player 2"};

    public void setBtnPlayAgain(Button btnPlayAgain) {
        this.btnPlayAgain = btnPlayAgain;
    }

    public void setBtnHome(Button btnHome) {
        this.btnHome = btnHome;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    private Button btnHome;
    private TextView playerTurn;


    //todo new Random for not always player one plays first
    private int player = 1;

    public GameLogic() {
        gameboard = new int[BOARD_SIZE][BOARD_SIZE];

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                gameboard[r][c] = 0;
            }
        }
        
    }


    @SuppressLint("SetTextI18n")
    public boolean updateGameBoard(int row, int column)
    {
        if (gameboard[row-1][column-1] == 0)
            {
            gameboard[row-1][column-1] = player;

                if (player == 1)
                {
                playerTurn.setText((playerNames[1] + "'s turn"));
                } else
                {
                playerTurn.setText((playerNames[0] + "'s turn"));
                }

            return true;
            }
        else
            {
            return false;
            }
    }


    public boolean hasWinner() {
        //todo create winner check method

        return false; //fix this also
    }

    public void resetGame() {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                gameboard[r][c] = 0;
            }
        }
    }

    public int[][] getGameBoard() {
        return gameboard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }
}
