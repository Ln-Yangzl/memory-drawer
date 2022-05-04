package board;

import board.impl.BinaryBoard;
import board.impl.GreyBoard;
import org.junit.Test;
import utils.LineDrawer;

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
}
