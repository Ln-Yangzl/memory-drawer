package org.zlyang.memoryDrawer.service.parser;

import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.impl.MacroCallCommand;
import org.zlyang.memoryDrawer.service.CommandParser;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-05-03 11:34
 * @description:
 */
public class MacroCallParser implements BiFunction<String, CommandParser, Command> {

    @Override
    public Command apply(String s, CommandParser parser) {
        String name = s.substring(s.indexOf("!") + 1, s.indexOf("("));
        List<Integer> args = Arrays.stream(s.substring(s.indexOf("(") + 1, s.indexOf(")")).split(","))
                .map(String::strip)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new MacroCallCommand(parser.getMacroDefinition(name), args.get(0), args.get(1));
    }
}
