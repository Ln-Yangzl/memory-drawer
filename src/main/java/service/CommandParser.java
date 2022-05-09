package service;

import command.Command;
import command.impl.*;
import service.parser.*;
import utils.CmdType;

import java.io.InputStream;
import java.util.*;
import java.util.function.BiFunction;

/**
 * @author: zlyang
 * @date: 2022-04-30 15:50
 * @description:
 */
public class CommandParser {

    private CommandReader commandReader;

    private final Map<String, MacroDefineCommand> macroCommand = new HashMap<>();

    private static final Map<CmdType, BiFunction<String, CommandParser, Command>> parser = new HashMap<>();

    static {
        parser.put(CmdType.LINE, new LineParser());
        parser.put(CmdType.TEXT, new TextParser());
        parser.put(CmdType.COLOR, new ColorParser());
        parser.put(CmdType.MACRO_CALL, new MacroCallParser());
        parser.put(CmdType.MACRO_DEFINE, new MacroDefineParser());
        parser.put(CmdType.REDO, new RedoParser());
        parser.put(CmdType.UNDO, new UndoParser());
    }

    public CommandParser(CommandReader commandReader) {
        this.commandReader = commandReader;
    }

    public List<Command> getAllCommand(){
        ArrayList<Command> commands = new ArrayList<>();
        while(hasNextCommand()){
            Command command = nextCommand();
            if(!(command instanceof MacroDefineCommand)){
                commands.add(command);
            }
        }
        return commands;
    }

    public boolean hasNextCommand() {
        return commandReader.hasNextCommand();
    }

    public Command nextCommand() {
        if(!hasNextCommand()){
            throw new RuntimeException("No more command found!");
        }
        String commandString = commandReader.nextCommandString();
        Command command = parser.get(CmdType.getType(commandString)).apply(commandString, this);
        if(command instanceof MacroDefineCommand){
            MacroDefineCommand macroDefineCommand = (MacroDefineCommand) command;
            macroCommand.put(macroDefineCommand.getName(), macroDefineCommand);
        }
        return command;
    }

    public static BiFunction<String, CommandParser, Command> getParser(CmdType type) {
        return parser.get(type);
    }

    public MacroDefineCommand getMacroDefinition(String name){
        return this.macroCommand.get(name);
    }




}
