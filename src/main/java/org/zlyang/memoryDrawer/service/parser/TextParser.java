package org.zlyang.memoryDrawer.service.parser;

import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.impl.TextCommand;
import org.zlyang.memoryDrawer.service.CommandParser;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:37
 * @description:
 */
public class TextParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        List<String> args = Arrays.stream(s.substring(s.indexOf('(') + 1, s.indexOf(')'))
                .split(","))
                .map(String::stripLeading)
                .map(String::stripTrailing)
                .collect(Collectors.toList());
        return new TextCommand(Integer.parseInt(args.get(0)), Integer.parseInt(args.get(1)), args.get(2).replace("\"", ""));
    }
}
