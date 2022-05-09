package org.zlyang.memoryDrawer.system.commandTest;

import org.junit.Test;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.zlyang.memoryDrawer.system.MockSystem;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-09 14:51
 * @description:
 */
public class RedoTest {

    @Test
    public void simpleRedoTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8),
                "text(0,0,\"!\")\n" +
                "undo\n" +
                "redo");
        String expect = "text(0,0,\"!\")\n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "        \n" +
                "   1    \n" +
                "        \n" +
                "undo\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "redo\n" +
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
    public void emptyRedoTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "redo");
        String expect = "redo\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n";
        assertEquals(expect, system.runSystem());
    }

    @Test
    public void macroRedoTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8),
                "#bottomLine{\n" +
                "    text(0,0,\"!\")\n" +
                "    line(0,0,7,0)\n" +
                "}\n" +
                "!bottomLine(0,0)\n" +
                "undo\n" +
                "redo");
        String expect = "!bottomLine(0,0)\n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "        \n" +
                "   1    \n" +
                "11111111\n" +
                "undo\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "redo\n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "   1    \n" +
                "        \n" +
                "   1    \n" +
                "11111111\n";
        assertEquals(expect, system.runSystem());
    }

    @Test
    public void colorRedoTest(){
        MockSystem system = new MockSystem(new GreyBoard(8, 255),
                "color(255)\n" +
                "color(128)\n" +
                "undo\n" +
                "redo\n" +
                "text(0,0,\"!\")\n");
        String expect = "undo\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "redo\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "text(0,0,\"!\")\n" +
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

}
