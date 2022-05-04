package board.impl;

import board.Board;
import utils.BitMap;
import utils.Point;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-05-03 18:42
 * @description:
 */
public class BinaryBoard implements Board {

    private BitMap[] bitMaps;

    private final int boardSize;

    public BinaryBoard() {
        this(50);
    }

    public BinaryBoard(int size){
        this.boardSize = size;
        this.bitMaps = new BitMap[boardSize];
        for (int i = 0; i < boardSize; i++) {
            bitMaps[i] = new BitMap(boardSize);
        }
    }


    @Override
    public void draw(List<Point> points) {
        for (Point point : points) {
            if(checkBound(point)){
                bitMaps[boardSize - point.getX() - 1].set(point.getY(), 1);
            }
        }
    }

    @Override
    public Object getState() {
        BitMap[] copy = new BitMap[boardSize];
        System.arraycopy(bitMaps, 0, copy, 0, boardSize);
        return copy;
    }

    @Override
    public void setState(Object state) {
        this.bitMaps = (BitMap[]) state;
    }

    private boolean checkBound(Point point){
        return 0 <= point.getX() && point.getX() < boardSize && 0 <= point.getY() && point.getY() < boardSize;
    }

    @Override
    public String toString() {
        return Arrays.stream(bitMaps).map(bitMap -> bitMap.toString() + "\n").collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryBoard that = (BinaryBoard) o;
        return Arrays.equals(bitMaps, that.bitMaps);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bitMaps);
    }
}
