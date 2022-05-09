package org.zlyang.memoryDrawer.service.parser;

import org.zlyang.memoryDrawer.command.Command;
import org.zlyang.memoryDrawer.command.impl.MacroCallCommand;
import org.zlyang.memoryDrawer.command.impl.MacroDefineCommand;
import org.zlyang.memoryDrawer.service.CommandParser;
import org.zlyang.memoryDrawer.utils.CmdType;

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
        List<Command> commands;
        commands = Arrays.stream(s.substring(s.indexOf("{") + 1, s.indexOf("}")).split("\\n"))
                .filter(str -> !str.isBlank())
                .map(String::strip)
                .map(str -> {
                    Command command = null;
                    try{
                        command = CommandParser.getParser(CmdType.getType(str)).apply(str, parser);
                    } catch (IllegalArgumentException e) {
                        command = new MacroCallCommand(parser.getMacroDefinition(str.strip().substring(0, str.indexOf("("))), 0, 0);
                    }
                    return command;
                })
                .collect(Collectors.toList());
        return new MacroDefineCommand(commands, s.substring(s.indexOf("#") + 1, s.indexOf("{")));
    }

}
