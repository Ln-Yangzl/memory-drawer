package org.zlyang.memoryDrawer.system.commandTest;

import org.junit.Test;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.zlyang.memoryDrawer.system.MockSystem;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-09 11:58
 * @description:
 */
public class ColorTest {

    @Test
    public void GreyColorTest(){
        MockSystem system = new MockSystem(new GreyBoard(8, 255), "color(128)\n" +
                "text(0,0,\"!\")");
        String expect = "text(0,0,\"!\")\n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "        \n" +
                "   5    \n" +
                "        \n";
        assertEquals(expect, system.runSystem());
    }

    @Test
    public void BinaryColorTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "color(128)\n" +
                "text(0,0,\"!\")");
        String expect = "text(0,0,\"!\")\n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "        \n" +
                "   1    \n" +
                "        \n";
        assertEquals(expect, system.runSystem());
    }

}
