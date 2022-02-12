package com.example.tictactoegame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TicTacToeBoard extends View {

    public static final int DRAW_O = 0;
    public static final int DRAW_X = 1;

    private final int boardColor;
    private final int XColor;
    private final int OColor;
    private final int winningLineColor;

    private boolean winningLine = false;

    private int cellSize = getWidth()/3;
    private final static double SPACE_VALUE = 0.2;
    private final static int BOARD_SIZE = 3;
    private final GameLogic game;

    private final Paint paint = new Paint();

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        game = new GameLogic();

        TypedArray ta = context
                .getTheme()
                .obtainStyledAttributes(attrs,
                        R.styleable.TicTacToeBoard, 0, 0);

        try {
            boardColor = ta.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            XColor = ta.getInteger(R.styleable.TicTacToeBoard_XColor, 0);
            OColor = ta.getInteger(R.styleable.TicTacToeBoard_YColor, 0);
            winningLineColor = ta.getInteger(R.styleable.TicTacToeBoard_winningLineColor, 0);
        } finally {
            ta.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension/3;

        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
        drawMarkers(canvas);

    }

    private void drawMarkers(Canvas canvas) {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                int currentGameBoard = game.getGameBoard()[r][c];

                if (currentGameBoard != DRAW_O) {
                    if (currentGameBoard == DRAW_X) {
                        drawX(canvas, r, c);
                    } else {
                        drawO(canvas, r, c);
                    }
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN) {
            int row = (int) Math.ceil(y/cellSize);
            int col = (int) Math.ceil(x/cellSize);


            if (!winningLine) {
                if (game.updateGameBoard(row, col)) {
                    invalidate();

                    if(game.hasWinner()) {
                        winningLine = true;
                        invalidate();
                    }

                    if (game.getPlayer() % 2 == 0) {
                        game.setPlayer(game.getPlayer() - 1);
                    } else {
                        game.setPlayer(game.getPlayer() + 1);
                    }
                }
            }


            invalidate();

            return true;
        }

        return false;
    }

    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);


        for (int c = 1; c < 3; c++) {
            canvas.drawLine(cellSize*c, 0, cellSize*c, canvas.getWidth(), paint);
        }

        for (int r = 1; r < 3; r++) {
            canvas.drawLine(0, cellSize*r, canvas.getHeight(), cellSize*r, paint);
        }
    }

    private void drawX(Canvas canvas, int row, int col) {
        paint.setColor(XColor);

        canvas.drawLine((float) ((col+1)*cellSize - cellSize*SPACE_VALUE),
                        (float) (row*cellSize + cellSize*SPACE_VALUE),
                        (float) (col*cellSize + cellSize*SPACE_VALUE),
                        (float) ((row+1)*cellSize - cellSize*SPACE_VALUE),
                        paint );

        canvas.drawLine((float) (col*cellSize + cellSize*SPACE_VALUE),
                        (float) (row*cellSize + cellSize*SPACE_VALUE),
                        (float) ((col+1)*cellSize - cellSize*SPACE_VALUE),
                        (float) ((row+1)*cellSize - cellSize*SPACE_VALUE),
                        paint );
    }

    private void drawO(Canvas canvas, int row, int col) {
        paint.setColor(OColor);

        canvas.drawOval((float) (col*cellSize + cellSize*SPACE_VALUE),
                        (float) (row*cellSize + cellSize*SPACE_VALUE),
                        (float)((col*cellSize+ cellSize) - cellSize*SPACE_VALUE),
                        (float) ((row*cellSize+cellSize) - cellSize*SPACE_VALUE),
                         paint);
    }

    private void drawHorizontalLine(Canvas canvas, int row, int col) {
        canvas.drawLine(col, (row * cellSize) + (cellSize/2),
                cellSize*BOARD_SIZE, (row * cellSize) + (cellSize/2), paint);
    }

    private void drawVerticalLine(Canvas canvas, int row, int col) {
        canvas.drawLine(col*cellSize + cellSize/2, row,
                col*cellSize + cellSize/2, cellSize*BOARD_SIZE, paint);
    }

    //todo negative and positive diagonals

    public void resetGame() {
        game.resetGame();
        winningLine = false;
    }

    public void setUpGame(Button playAgain, Button home, TextView displayPlayer, String[] names) {

        game.setBtnPlayAgain(playAgain);
        game.setBtnHome(home);
        game.setPlayerTurn(displayPlayer);
        game.setPlayerNames(names);
    }
}
