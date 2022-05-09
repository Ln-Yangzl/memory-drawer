package org.zlyang.memoryDrawer.service;

import org.zlyang.memoryDrawer.board.Board;
import org.zlyang.memoryDrawer.command.Command;
import org.zlyang.memoryDrawer.command.impl.RedoCommand;
import org.zlyang.memoryDrawer.command.impl.UndoCommand;

import java.util.LinkedList;
/**
 * @author: zlyang
 * @date: 2022-04-30 15:51
 * @description:
 */
public class CommandExecutor {

    private Board board;

    private final LinkedList<Command> commandList;

    private final LinkedList<Command> executedCommand;

    private final LinkedList<Command> redoList;

    public CommandExecutor() {
        this.commandList = new LinkedList<>();
        this.executedCommand = new LinkedList<>();
        this.redoList = new LinkedList<>();
    }

    public CommandExecutor(Board board) {
        this();
        this.board = board;
    }

    public void addCommand(Command nextCommand) {
        nextCommand.setReceiver(board);
        commandList.add(nextCommand);
    }

    public void executeAll() {
        while(!commandList.isEmpty()){
            Command nextCommand = commandList.pollFirst();
            execute(nextCommand);
        }
    }

    public void execute(Command nextCommand) {
        nextCommand.setReceiver(board);
        if(nextCommand instanceof RedoCommand && !redoList.isEmpty()){
            Command command = redoList.pollLast();
            command.execute();
            executedCommand.add(command);
            return;
        }
        if(nextCommand instanceof UndoCommand && !executedCommand.isEmpty()){
            Command command = executedCommand.pollLast();
            command.unExecute();
            redoList.add(command);
            return;
        }
        nextCommand.execute();
        executedCommand.add(nextCommand);
        redoList.clear();
    }
}