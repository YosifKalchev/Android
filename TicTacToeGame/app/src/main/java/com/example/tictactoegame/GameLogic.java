package com.example.tictactoegame;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoegame.constants.WinType;

public class GameLogic {

    private static final int BOARD_SIZE = 3;
    private final int [][] gameBoard;
    private Button btnPlayAgain;
    private Button btnHome;

    private String[] playerNames = {"Player 1", "Player 2"};

    private int[] winType = {-1, -1, -1};

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


    private TextView playerTurn;

    //todo new Random for not always player one plays first
    private int player = 1;

    public GameLogic() {
        gameBoard = new int[BOARD_SIZE][BOARD_SIZE];

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                gameBoard[r][c] = 0;
            }
        }
        
    }


    @SuppressLint("SetTextI18n")
    public boolean updateGameBoard(int row, int column)
    {
        if (gameBoard[row-1][column-1] == 0)
            {
            gameBoard[row-1][column-1] = player;

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


    @SuppressLint("SetTextI18n")
    public boolean hasWinner() {
        boolean isWinner = false;

        for (int r = 0; r < BOARD_SIZE; r++) {
            if (gameBoard[r][0] == gameBoard[r][1]
                    && gameBoard[r][0] == gameBoard[r][2]
                    && gameBoard[r][0] != 0) {
                winType = new int[] {r, 0, WinType.COLUMN.value};
                isWinner = true;
                break;
            }
        }

        for (int c = 0; c < BOARD_SIZE; c++) {
            if (gameBoard[0][c] == gameBoard[1][c]
                    && gameBoard[0][c] == gameBoard[2][c]
                    && gameBoard[0][c] != 0) {
                winType = new int[] {0, c, WinType.ROW.value};
                isWinner = true;
                break;
            }
        }

        if(gameBoard[0][0] == gameBoard[1][1]
                && gameBoard[0][0] == gameBoard[2][2]
                && gameBoard[0][0] != 0) {
            winType = new int[] {0, 2, WinType.NEG_DIAGONAL.value};
            isWinner = true;
        }

        if(gameBoard[2][0] == gameBoard[1][1]
                && gameBoard[2][0] == gameBoard[0][2]
                && gameBoard[2][0] != 0) {
            winType = new int[] {2, 2, WinType.POS_DIAGONAL.value};
            isWinner = true;
        }

        int boardFilled = 0;
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                if(gameBoard[r][c] != 0) {
                    boardFilled += 1;
                }
            }
        }
        if(isWinner) {
            btnPlayAgain.setVisibility(View.VISIBLE);
            btnHome.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player - 1] + " won!!!"));
            return true;

        } else {
            if(boardFilled == 9) {
                btnPlayAgain.setVisibility(View.VISIBLE);
                btnHome.setVisibility(View.VISIBLE);
                playerTurn.setText("Tie game!");
                return true;
            }
            else {
                return false;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void resetGame() {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                gameBoard[r][c] = 0;
            }
        }

        player = 1;
        btnPlayAgain.setVisibility(View.GONE);
        btnHome.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0] + "'s turn"));
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
