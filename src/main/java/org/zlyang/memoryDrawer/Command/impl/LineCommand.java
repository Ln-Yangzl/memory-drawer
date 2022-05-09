package org.zlyang.memoryDrawer.Command.impl;

import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.Executable;
import org.zlyang.memoryDrawer.utils.LineDrawer;

/**
 * @author: zlyang
 * @date: 2022-04-30 18:11
 * @description:
 */
public class LineCommand extends Command implements Executable {

    private final int x1, x2, y1, y2;

    public LineCommand(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    protected void executeCommand() {
        this.board.draw(LineDrawer.drawLine(offsetX + x1, offsetY + y1, offsetX + x2, offsetY + y2));
    }

    @Override
    public String toString() {
        return "line(" + x1 + "," + y1 + "," + x2 + "," + y2 + ")";
    }
}
