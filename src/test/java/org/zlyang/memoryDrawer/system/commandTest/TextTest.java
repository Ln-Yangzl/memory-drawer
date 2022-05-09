package org.zlyang.memoryDrawer.system.commandTest;

import org.junit.Test;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.system.MockSystem;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-09 11:53
 * @description:
 */
public class TextTest {

    @Test
    public void singleCharacterTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "text(0,0,\"!\")");
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

    @Test
    public void simpleTextTest(){
        MockSystem system = new MockSystem(new BinaryBoard(16), "text(0,0,\"!!\")");
        String expect = "text(0,0,\"!!\")\n" +
                "                \n" +
                "                \n" +
                "                \n" +
                "                \n" +
                "                \n" +
                "                \n" +
                "                \n" +
                "                \n" +
                "   1       1    \n" +
                "   1       1    \n" +
                "   1       1    \n" +
                "   1       1    \n" +
                "   1       1    \n" +
                "                \n" +
                "   1       1    \n" +
                "                \n";
        assertEquals(expect, system.runSystem());
    }
}
