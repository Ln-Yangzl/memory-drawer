package org.zlyang.memoryDrawer.service.parser;

import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.impl.RedoCommand;
import org.zlyang.memoryDrawer.service.CommandParser;

import java.util.function.BiFunction;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:10
 * @description:
 */
public class RedoParser implements BiFunction<String, CommandParser, Command> {
    @Override
    public Command apply(String s, CommandParser commandParser) {
        return new RedoCommand();
    }
}
