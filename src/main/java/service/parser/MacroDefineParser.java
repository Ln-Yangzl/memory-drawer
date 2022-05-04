package service.parser;

import command.Command;
import command.impl.MacroDefineCommand;
import service.CommandParser;
import utils.CmdType;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-05-03 10:41
 * @description:
 */
public class MacroDefineParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        List<Command> commands = Arrays.stream(s.substring(s.indexOf("{") + 1, s.indexOf("}")).split("\\n"))
                .filter(str -> !str.isBlank())
                .map(str -> CommandParser.getParser(CmdType.getType(str)).apply(str, parser))
                .collect(Collectors.toList());
        return new MacroDefineCommand(commands, s.substring(s.indexOf("#") + 1, s.indexOf("{")));
    }

}
