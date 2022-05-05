package command.impl;

import command.Command;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:03
 * @description:
 */
public class RedoCommand extends Command {
    @Override
    protected void executeCommand() {
        throw new IllegalCallerException("Redo command execute!");
    }
}
