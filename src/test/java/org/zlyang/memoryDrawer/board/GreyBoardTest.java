package org.zlyang.memoryDrawer.board;

import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.junit.Test;
import org.zlyang.memoryDrawer.utils.LineDrawer;
import org.zlyang.memoryDrawer.utils.TextDrawer;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-03 19:49
 * @description:
 */
public class GreyBoardTest {

    @Test
    public void simpleLineTest(){
        GreyBoard greyBoard = new GreyBoard(5, 255);
        greyBoard.draw(LineDrawer.drawLine(0, 0, 3, 3));
        String except = "     \n"
                +"   9 \n"
                +"  9  \n"
                +" 9   \n"
                +"9    \n";
        assertEquals(except, greyBoard.toString());
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
        GreyBoard greyBoard = new GreyBoard(8, 26);
        greyBoard.draw(TextDrawer.drawText(0, 0, "!"));
        assertEquals(std, greyBoard.toString());
    }

    @Test
    public void stateTest(){
        GreyBoard greyBoard = new GreyBoard(5, 255);
        Object state = greyBoard.getState();
        greyBoard.draw(LineDrawer.drawLine(0, 0, 3, 3));
        greyBoard.setState(state);
        String except = "     \n"
                +"     \n"
                +"     \n"
                +"     \n"
                +"     \n";
        assertEquals(except, greyBoard.toString());
    }
}
