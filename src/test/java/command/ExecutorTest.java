package command;

import board.impl.BinaryBoard;
import board.impl.GreyBoard;
import command.impl.ColorCommand;
import command.impl.LineCommand;
import command.impl.TextCommand;
import command.impl.UndoCommand;
import org.junit.Test;
import service.CommandExecutor;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:46
 * @description:
 */
public class ExecutorTest {

    @Test
    public void executorToGreyBoardTest(){
        String std = "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "        \n" +
                "   5    \n" +
                "        \n";
        GreyBoard greyBoard = new GreyBoard(8, 255);
        CommandExecutor executor = new CommandExecutor(greyBoard);
        executor.addCommand(new ColorCommand(128));
        executor.addCommand(new TextCommand(0, 0, "!"));
        executor.addCommand(new LineCommand(0, 0, 4, 4));
        executor.addCommand(new UndoCommand());
        executor.executeAll();
        assertEquals(std, greyBoard.toString());
    }

    @Test
    public void executorToBinaryBoardTest(){
        String std = "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "        \n" +
                "   1    \n" +
                "        \n";
        BinaryBoard binaryBoard = new BinaryBoard(8);
        CommandExecutor executor = new CommandExecutor(binaryBoard);
        executor.addCommand(new ColorCommand(26));
        executor.addCommand(new TextCommand(0, 0, "!"));
        executor.addCommand(new LineCommand(0, 0, 4, 4));
        executor.addCommand(new UndoCommand());
        executor.executeAll();
        assertEquals(std, binaryBoard.toString());
    }

}
