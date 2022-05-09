import board.Board;
import board.impl.BinaryBoard;
import board.impl.GreyBoard;
import command.Command;
import command.Executable;
import command.impl.ColorCommand;
import service.CommandExecutor;
import service.CommandParser;
import service.CommandReader;

import java.io.*;

/**
 * @author: zlyang
 * @date: 2022-04-30 15:39
 * @description:
 */
public class Main {

    public static void main(String[] args) throws IOException {
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

        String path = System.getProperty("java.class.path");
        path = path.split("target")[0] + "src\\main\\resources\\out\\" + inputFile;
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        System.setOut(new PrintStream(path));

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


        while(commandParser.hasNextCommand()){
            Command nextCommand = commandParser.nextCommand();
            if(nextCommand instanceof Executable){
                commandExecutor.execute(nextCommand);
                if(!(nextCommand instanceof ColorCommand)){
                    System.out.println(nextCommand);
                    System.out.println(board);
                }
            }

        }


    }
}
