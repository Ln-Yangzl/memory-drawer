package service.parser;

import command.Command;
import command.impl.RedoCommand;
import service.CommandParser;

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
