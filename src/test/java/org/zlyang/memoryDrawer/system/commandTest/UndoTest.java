package org.zlyang.memoryDrawer.system.commandTest;

import org.junit.Test;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.zlyang.memoryDrawer.system.MockSystem;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-09 14:42
 * @description:
 */
public class UndoTest {

    @Test
    public void simpleUndoTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "text(0,0,\"!\")\n" +
                "undo");
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
                "        \n";
        assertEquals(expect, system.runSystem());
    }

    @Test
    public void emptyUndoTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "undo");
        String expect = "undo\n" +
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
    public void macroUndoTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "#bottomLine{\n" +
                "    text(0,0,\"!\")\n" +
                "    line(0,0,7,0)\n" +
                "}\n" +
                "!bottomLine(0,0)\n" +
                "undo");
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
                "        \n";
        assertEquals(expect, system.runSystem());
    }

    @Test
    public void colorUndoTest(){
        MockSystem system = new MockSystem(new GreyBoard(8, 255), "color(255)\n" +
                "color(128)\n" +
                "undo\n" +
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
                "text(0,0,\"!\")\n" +
                "   9    \n" +
                "   9    \n" +
                "   9    \n" +
                "   9    \n" +
                "   9    \n" +
                "        \n" +
                "   9    \n" +
                "        \n";
        assertEquals(expect, system.runSystem());
    }

}
