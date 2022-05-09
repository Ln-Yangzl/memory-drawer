package org.zlyang.memoryDrawer.command.impl;

import org.zlyang.memoryDrawer.board.Board;
import org.zlyang.memoryDrawer.command.Command;
import org.zlyang.memoryDrawer.command.Executable;

import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-05-03 11:12
 * @description:
 */
public class MacroCallCommand extends Command implements Executable {

    private final List<Command> commandList;

    private final String name;


    public MacroCallCommand(MacroDefineCommand defineCommand, int x, int y) {
        this.commandList = defineCommand.getCommandList();
        this.offsetX = x;
        this.offsetY = y;
        this.name = defineCommand.getName();
    }

    @Override
    protected void executeCommand() {
        int color = board.getColor();
        commandList.forEach(command -> {
            command.setOffset(offsetX, offsetY);
            command.execute();
        });
        board.setColor(color);
    }

    @Override
    public void setReceiver(Board board) {
        super.setReceiver(board);
        commandList.forEach(command -> command.setReceiver(board));
    }

    @Override
    public String toString() {
        return "!" + name + "(" + offsetX + "," + offsetY + ")";
    }
}
