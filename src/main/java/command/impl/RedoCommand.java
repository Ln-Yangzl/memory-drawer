package command.impl;

import command.Command;
import command.Executable;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:03
 * @description:
 */
public class RedoCommand extends Command implements Executable {
    @Override
    protected void executeCommand() {
        throw new RuntimeException("Redo command execute!");
    }

    @Override
    public String toString() {
        return "redo";
    }
}
