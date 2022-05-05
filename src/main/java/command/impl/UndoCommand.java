package command.impl;

import command.Command;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:02
 * @description:
 */
public class UndoCommand extends Command {
    @Override
    protected void executeCommand() {
        throw new IllegalCallerException("UndoCommand execute!");
    }
}
