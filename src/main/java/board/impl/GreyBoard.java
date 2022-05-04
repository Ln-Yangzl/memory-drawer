package board.impl;

import board.Board;
import utils.Point;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-05-03 18:42
 * @description:
 */
public class GreyBoard implements Board {

    private final int boardSize;

    private char[][] board;

    private int color;

    public GreyBoard(int boardSize, int color) {
        this.boardSize = boardSize;
        this.color = color;
        this.board = new char[boardSize][boardSize];
    }

    public GreyBoard(){
        this(50, 255);
    }

    @Override
    public void draw(List<Point> points) {
        for (Point point : points) {
            if(checkBound(point)){
                board[boardSize - point.getX() - 1][point.getY()] = (char)color;
            }
        }
    }

    @Override
    public Object getState() {
        char[][] copy = new char[boardSize][boardSize];
        System.arraycopy(board, 0, copy, 0, boardSize);
        return copy;
    }

    @Override
    public void setState(Object state) {
        this.board = (char[][]) state;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public int setColor(int color) {
        int temp = this.color;
        this.color = color;
        return temp;
    }

    private boolean checkBound(Point point){
        return 0 <= point.getX() && point.getX() < boardSize && 0 <= point.getY() && point.getY() < boardSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int current = (int) (board[i][j] / 25.6);
                sb.append(current == 0 ? " " : current);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreyBoard greyBoard = (GreyBoard) o;
        return Arrays.equals(board, greyBoard.board);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(board);
    }
}
