import board.Board;
import service.CommandExecutor;
import service.CommandParser;
import service.CommandReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author: zlyang
 * @date: 2022-04-30 15:39
 * @description:
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = null;
        Board board = null;

        //TODO: 解析args参数

        InputStream inputStream = System.in;
        if(inputFile != null){
            inputStream = new FileInputStream(inputFile);
        }

        CommandParser commandParser = new CommandParser(new CommandReader(inputStream));
        CommandExecutor commandExecutor = new CommandExecutor(board);

        while(commandParser.hasNextCommand()){
            commandExecutor.addCommand(commandParser.nextCommand());
        }

        commandExecutor.executeAll();

        System.out.println(board);

    }
}
