package service.parser;

import command.Command;
import command.impl.LineCommand;
import service.CommandParser;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-04-30 16:53
 * @description:
 */
public class LineParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        List<Integer> args = Arrays.stream(s.substring(s.indexOf('(') + 1, s.indexOf(')'))
                .split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new LineCommand(args.get(0), args.get(1), args.get(2), args.get(3));
    }
}