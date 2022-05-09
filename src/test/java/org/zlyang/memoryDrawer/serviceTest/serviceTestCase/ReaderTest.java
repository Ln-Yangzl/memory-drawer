package org.zlyang.memoryDrawer.serviceTest.serviceTestCase;

import org.junit.Test;
import org.zlyang.memoryDrawer.service.CommandReader;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-03 15:58
 * @description:
 */
public class ReaderTest {

    @Test
    public void simpleReadTest(){
        String[] STD = {"line(0,0,19,19)",
                "text(11,0,\"!\")",
                "#timeview{\n" +
                        "    line(0,0,45,0)\n" +
                        "    text(0,3,\"10:15\")\n" +
                        "}",
                "!timeview(50,50)"};
        CommandReader commandReader = new CommandReader(getClass().getClassLoader().getResourceAsStream("testScripts/test1.txt"));
        for (int i = 0; i < STD.length; i++) {
            assertEquals(STD[i], commandReader.nextCommandString());
        }
    }

    @Test
    public void recursiveReadTest(){
        String[] std = {
                "#timeview{\n" +
                        "    line(0,0,45,0)\n" +
                        "    text(0,3,\"10:15\")\n" +
                        "}",
                "#lineview{\n" +
                        "    color(20)\n" +
                        "    line(0,0,22,22)\n" +
                        "    !timeview(20,20)\n" +
                        "}",
                "!lineview(0,0)"
        };
        CommandReader commandReader = new CommandReader(getClass().getClassLoader().getResourceAsStream("testScripts/test2.txt"));
        for (int i = 0; i < std.length; i++) {
            assertEquals(std[i], commandReader.nextCommandString());
        }
    }

}
