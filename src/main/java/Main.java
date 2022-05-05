import board.Board;
import board.impl.BinaryBoard;
import board.impl.GreyBoard;
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
        int color = 2;

        //TODO: 解析args参数
        if(args.length == 1){
            inputFile = args[0];
        } else if(args.length == 3){
            color = Integer.parseInt(args[1]);
            inputFile = args[2];
        } else {
            System.out.println("Wrong args!");
            return;
        }

        InputStream inputStream = null;
        if(inputFile != null){
            inputStream = Main.class.getClassLoader().getResourceAsStream(inputFile);
        }

        if(color == 2){
            board = new BinaryBoard();
        } else {
            board = new GreyBoard();
        }

        CommandParser commandParser = new CommandParser(new CommandReader(inputStream));
        CommandExecutor commandExecutor = new CommandExecutor(board);

        commandParser.getAllCommand().forEach(commandExecutor::addCommand);

        commandExecutor.executeAll();

        System.out.println(board);

    }
}
