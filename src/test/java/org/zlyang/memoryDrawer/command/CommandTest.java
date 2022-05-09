package org.zlyang.memoryDrawer.command;

import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.zlyang.memoryDrawer.command.impl.ColorCommand;
import org.zlyang.memoryDrawer.command.impl.LineCommand;
import org.zlyang.memoryDrawer.command.impl.TextCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:14
 * @description:
 */
public class CommandTest {

    @Test
    public void lineCommandTest(){
        String std = "    9\n"
                    +"   9 \n"
                    +"  9  \n"
                    +" 9   \n"
                    +"9    \n";
        GreyBoard board = new GreyBoard(5, 255);
        LineCommand lineCommand = new LineCommand(0, 0, 4, 4);
        lineCommand.setReceiver(board);
        lineCommand.execute();
        assertEquals(std, board.toString());
    }

    @Test
    public void colorAndTextCommandTest(){
        String std = "   1    \n" +
                    "   1    \n" +
                    "   1    \n" +
                    "   1    \n" +
                    "   1    \n" +
                    "        \n" +
                    "   1    \n" +
                    "        \n";
        GreyBoard greyBoard = new GreyBoard(8, 255);
        TextCommand textCommand = new TextCommand(0, 0, "!");
        textCommand.setReceiver(greyBoard);
        ColorCommand colorCommand = new ColorCommand(26);
        colorCommand.setReceiver(greyBoard);
        colorCommand.execute();
        textCommand.execute();
        assertEquals(std, greyBoard.toString());
    }

}
