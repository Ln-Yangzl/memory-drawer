package board;

import board.impl.BinaryBoard;
import org.junit.Test;
import utils.LineDrawer;

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

}
