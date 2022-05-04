package service.parser;

import command.Command;
import command.impl.ColorCommand;
import service.CommandParser;

import java.util.function.BiFunction;

/**
 * @author: zlyang
 * @date: 2022-05-03 13:22
 * @description:
 */
public class ColorParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        int colorSet = Integer.parseInt(s.substring(s.indexOf('(') + 1, s.indexOf(')')));
        return new ColorCommand(colorSet);
    }
}
