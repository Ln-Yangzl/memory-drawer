package org.zlyang.memoryDrawer.board;

import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.junit.Test;
import org.zlyang.memoryDrawer.utils.LineDrawer;
import org.zlyang.memoryDrawer.utils.TextDrawer;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-03 19:39
 * @description:
 */
public class BinaryBoardTest {

    @Test
    public void simpleLineTest(){
        BinaryBoard binaryBoard = new BinaryBoard(5);
        binaryBoard.draw(LineDrawer.drawLine(0, 0, 3, 3));
        String except = "     \n"
                        +"   1 \n"
                        +"  1  \n"
                        +" 1   \n"
                        +"1    \n";
        assertEquals(except, binaryBoard.toString());
    }

    @Test
    public void simpleTextTest(){
        String std = "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "        \n" +
                "   1    \n" +
                "        \n";
        BinaryBoard binaryBoard = new BinaryBoard(8);
        binaryBoard.draw(TextDrawer.drawText(0, 0, "!"));
        assertEquals(std, binaryBoard.toString());
    }

    @Test
    public void stateTest(){
        BinaryBoard binaryBoard = new BinaryBoard(5);
        Object state = binaryBoard.getState();
        binaryBoard.draw(LineDrawer.drawLine(0, 0, 3, 3));
        binaryBoard.setState(state);
        String except = "     \n"
                +"     \n"
                +"     \n"
                +"     \n"
                +"     \n";
        assertEquals(except, binaryBoard.toString());
    }

}
