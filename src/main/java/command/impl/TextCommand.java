package command.impl;

import board.Board;
import command.Command;
import command.Executable;
import utils.TextDrawer;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:17
 * @description:
 */
public class TextCommand extends Command implements Executable {

    private final String text;

    private final int x, y;

    public TextCommand(int x, int y, String text) {
        this.text = text;
        this.x = x;
        this.y = y;
    }


    @Override
    protected void executeCommand() {
        board.draw(TextDrawer.drawText(this.x + offsetX, this.y + offsetY, text));
    }

    @Override
    public String toString() {
        return "text(" + x + "," + y + ",\"" + text + "\")";
    }
}
