package org.zlyang.memoryDrawer.service.parser;

import org.zlyang.memoryDrawer.command.Command;
import org.zlyang.memoryDrawer.command.impl.ColorCommand;
import org.zlyang.memoryDrawer.service.CommandParser;

import java.util.function.BiFunction;

/**
 * @author: zlyang
 * @date: 2022-05-03 13:22
 * @description:
 */
public class ColorParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        int colorSet = Integer.parseInt(s.substring(s.indexOf('(') + 1, s.indexOf(')')).strip());
        return new ColorCommand(colorSet);
    }
}
