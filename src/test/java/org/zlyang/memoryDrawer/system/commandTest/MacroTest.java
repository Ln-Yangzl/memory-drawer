package org.zlyang.memoryDrawer.system.commandTest;

import org.junit.Test;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.zlyang.memoryDrawer.system.MockSystem;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-09 12:01
 * @description:
 */
public class MacroTest {
    @Test
    public void simpleMacroTest(){
        MockSystem system = new MockSystem(new BinaryBoard(8), "#bottomLine{\n" +
                "    text(0,0,\"!\")\n" +
                "    line(0,0,7,0)\n" +
                "}\n" +
                "!bottomLine(0,0)");
        String expect = "!bottomLine(0,0)\n" +
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
    public void macroColorTest(){
        MockSystem system = new MockSystem(new GreyBoard(8, 255), "#bottomLine{\n" +
                "    color(255)\n" +
                "    line(0,0,7,0)\n" +
                "    text(0,0,\"!\")\n" +
                "}\n" +
                "color(26)\n" +
                "!bottomLine(0,0)");
        String expect = "!bottomLine(0,0)\n" +
                "   9    \n" +
                "   9    \n" +
                "   9    \n" +
                "   9    \n" +
                "   9    \n" +
                "        \n" +
                "   9    \n" +
                "99999999\n";
        assertEquals(expect, system.runSystem());
    }

    @Test
    public void nestedMacroTest(){
        MockSystem system = new MockSystem(new GreyBoard(8, 255), "#bottomLine{\n" +
                "    color(255)\n" +
                "    line(0,0,7,0)\n" +
                "}\n" +
                "#startTimeView{\n" +
                "    color(128)\n" +
                "    bottomLine(0, 0)\n" +
                "    text(0,0,\"!\")\n" +
                "}\n" +
                "!startTimeView(0,0)");
        String expect = "!startTimeView(0,0)\n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "   5    \n" +
                "        \n" +
                "   5    \n" +
                "99999999\n";
        assertEquals(expect, system.runSystem());
    }
}
