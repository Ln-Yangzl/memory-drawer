package org.zlyang.memoryDrawer.system.commandTest;


import org.junit.Test;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.service.CommandExecutor;
import org.zlyang.memoryDrawer.service.CommandParser;
import org.zlyang.memoryDrawer.service.CommandReader;
import org.zlyang.memoryDrawer.system.MockSystem;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-09 11:28
 * @description:
 */
public class LineTest {

    @Test
    public void simpleLineTest(){
        MockSystem system = new MockSystem(new BinaryBoard(5), "line(0,0,4,4)");
        String expect = "line(0,0,4,4)\n" +
                "    1\n" +
                "   1 \n" +
                "  1  \n" +
                " 1   \n" +
                "1    \n";
        assertEquals(expect, system.runSystem());

    }

    @Test
    public void crossLineTest(){
        MockSystem system = new MockSystem(new BinaryBoard(5), "line(2,0,2,4)\n" +
                "line(0,2,4,2)");
        String expect = "line(2,0,2,4)\n" +
                "  1  \n" +
                "  1  \n" +
                "  1  \n" +
                "  1  \n" +
                "  1  \n" +
                "line(0,2,4,2)\n" +
                "  1  \n" +
                "  1  \n" +
                "11111\n" +
                "  1  \n" +
                "  1  \n";
        assertEquals(expect, system.runSystem());
    }

}
