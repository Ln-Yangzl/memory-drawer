package org.zlyang.memoryDrawer.serviceTest.impl;

import org.zlyang.memoryDrawer.serviceTest.Command;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:22
 * @description:
 */
public class MacroDefineCommand extends Command {

    private final List<Command> commandList;

    private final String name;

    public MacroDefineCommand(List<Command> commandList, String name) {
        this.commandList = commandList;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    @Override
    protected void executeCommand() {
        throw new RuntimeException("MacroDefineCommand execute method called!");
    }

    @Override
    public String toString() {
        return "#" + name + "{\n"
                + commandList.stream().map(command -> "    " + command.toString() + "\n").collect(Collectors.joining())
                + "}";
    }
}
