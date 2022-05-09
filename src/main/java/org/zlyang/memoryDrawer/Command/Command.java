package org.zlyang.memoryDrawer.Command;

import org.zlyang.memoryDrawer.board.Board;


/**
 * @author: zlyang
 * @date: 2022-04-30 17:35
 * @description:
 */
public abstract class Command {

    protected Board board;

    private Object history;

    private int color;

    protected int offsetX = 0, offsetY = 0;


    /**
     * 设置命令的接受者
     * @param board 命令接受者
     */
    public void setReceiver(Board board){
        this.board = board;
    }


    /**
     * 执行命令的外部接口
     */
    public void execute(){
        history = board.getState();
        color = board.getColor();
        executeCommand();
    }

    /**
     * 执行命令的具体实现
     */
    protected abstract void executeCommand();

    /**
     * 撤销命令
     */
    public void unExecute(){
        board.setState(history);
        board.setColor(color);
        history = null;
    }

    /**
     * 为当前命令设置偏移
     * @param x x坐标
     * @param y y坐标
     */
    public void setOffset(int x, int y){
        this.offsetX = x;
        this.offsetY = y;
    }
}
