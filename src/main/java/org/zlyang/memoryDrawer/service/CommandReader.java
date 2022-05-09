package org.zlyang.memoryDrawer.service;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-05-03 15:45
 * @description:
 */
public class CommandReader {

    private final Scanner scanner;

    private String nextLine;

    public CommandReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public String nextCommandString() {
        String next = null;
        if (hasNextCommand()) {
            next = getNextLine();
        }
        if (!next.contains("#")) {
            return next;
        }
        String s;
        StringBuilder sb = new StringBuilder(next);
        while (!(s = getNextLine()).contains("}")) {
            sb.append("\n").append(s);
        }
        sb.append("\n").append(s);
        return sb.toString();
    }

    public boolean hasNextCommand(){
        return setNextLine();
    }

    private boolean setNextLine(){
        if(nextLine != null){
            return true;
        }
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(!s.isBlank() && !s.contains("//")){
                nextLine = s;
                return true;
            }
        }
        return false;
    }

    private String getNextLine(){
        if(!setNextLine()){
            throw new RuntimeException("setNextLine failed!\n Check input file!");
        }
        String temp = nextLine;
        nextLine = null;
        return temp;
    }


}
