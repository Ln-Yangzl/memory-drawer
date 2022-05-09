package org.zlyang.memoryDrawer.service.parser;

import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.impl.UndoCommand;
import org.zlyang.memoryDrawer.service.CommandParser;

import java.util.function.BiFunction;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:11
 * @description:
 */
public class UndoParser implements BiFunction<String, CommandParser, Command> {
    @Override
    public Command apply(String s, CommandParser commandParser) {
        return new UndoCommand();
    }
}
