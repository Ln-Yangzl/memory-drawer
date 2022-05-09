package command.impl;

import command.Command;
import command.Executable;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:02
 * @description:
 */
public class UndoCommand extends Command implements Executable {
    @Override
    protected void executeCommand() {
        throw new RuntimeException("UndoCommand execute!");
    }

    @Override
    public String toString() {
        return "undo";
    }
}
