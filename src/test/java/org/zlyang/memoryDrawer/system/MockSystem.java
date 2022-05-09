package org.zlyang.memoryDrawer.system;

import org.zlyang.memoryDrawer.board.Board;
import org.zlyang.memoryDrawer.Command.Command;
import org.zlyang.memoryDrawer.Command.Executable;
import org.zlyang.memoryDrawer.Command.impl.ColorCommand;
import org.zlyang.memoryDrawer.service.CommandExecutor;
import org.zlyang.memoryDrawer.service.CommandParser;
import org.zlyang.memoryDrawer.service.CommandReader;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author: zlyang
 * @date: 2022-05-09 11:39
 * @description:
 */
public class MockSystem {

    private final Board board;

    private final CommandParser commandParser;

    private final CommandExecutor commandExecutor;

    private final StringBuilder result;

    public MockSystem(Board board, String commands) {
        this.board = board;
        this.result = new StringBuilder();
        this.commandParser = new CommandParser(new CommandReader(new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8))));
        this.commandExecutor = new CommandExecutor(board);
    }

    public String runSystem(){
        while(commandParser.hasNextCommand()){
            Command nextCommand = commandParser.nextCommand();
            if(nextCommand instanceof Executable){
                commandExecutor.execute(nextCommand);
                if(!(nextCommand instanceof ColorCommand)){
                    result.append(nextCommand + "\n");
                    result.append(board);
                }
            }

        }
        return result.toString();
    }
}
