package org.zlyang.memoryDrawer;

import org.zlyang.memoryDrawer.board.Board;
import org.zlyang.memoryDrawer.board.impl.BinaryBoard;
import org.zlyang.memoryDrawer.board.impl.GreyBoard;
import org.zlyang.memoryDrawer.serviceTest.Command;
import org.zlyang.memoryDrawer.serviceTest.Executable;
import org.zlyang.memoryDrawer.serviceTest.impl.ColorCommand;
import org.zlyang.memoryDrawer.service.CommandExecutor;
import org.zlyang.memoryDrawer.service.CommandParser;
import org.zlyang.memoryDrawer.service.CommandReader;

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
