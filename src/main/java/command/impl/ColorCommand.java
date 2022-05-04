package command.impl;

import board.Board;
import command.Command;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:30
 * @description:
 */
public class ColorCommand extends Command {

    private final int color;

    public ColorCommand(int color) {
        this.color = color;
    }

    @Override
    protected void executeCommand() {
        board.setColor(color);
    }

    @Override
    public String toString() {
        return "color(" + color + ")";
    }
}
