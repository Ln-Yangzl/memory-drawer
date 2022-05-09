package org.zlyang.memoryDrawer.Command.impl;

import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.Executable;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:30
 * @description:
 */
public class ColorCommand extends Command implements Executable {

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
