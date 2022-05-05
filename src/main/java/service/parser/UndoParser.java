package service.parser;

import command.Command;
import command.impl.UndoCommand;
import service.CommandParser;

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
