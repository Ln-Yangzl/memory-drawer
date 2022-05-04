package command;

import org.junit.Test;
import service.CommandParser;
import service.CommandReader;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-03 16:31
 * @description:
 */
public class ParserTest {

    @Test
    public void simpleParserTest(){
        String[] std = {"line(0,0,19,19)",
                "text(11,0,\"!\")",
                "#timeview{\n" +
                        "    line(0,0,45,0)\n" +
                        "    text(0,3,\"10:15\")\n" +
                        "}",
                "!timeview(50,50)"};
        CommandReader commandReader = new CommandReader(getClass().getClassLoader().getResourceAsStream("scripts/script1.txt"));
        CommandParser commandParser = new CommandParser(commandReader);
        for (int i = 0; i < std.length; i++) {
            assertEquals(std[i], commandParser.nextCommand().toString());
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
        CommandReader commandReader = new CommandReader(getClass().getClassLoader().getResourceAsStream("scripts/script2.txt"));
        CommandParser commandParser = new CommandParser(commandReader);
        for (int i = 0; i < std.length; i++) {
            assertEquals(std[i], commandParser.nextCommand().toString());
        }
    }
}
