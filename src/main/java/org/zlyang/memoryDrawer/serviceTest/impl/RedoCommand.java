package org.zlyang.memoryDrawer.serviceTest.impl;

import org.zlyang.memoryDrawer.serviceTest.Command;
import org.zlyang.memoryDrawer.serviceTest.Executable;

/**
 * @author: zlyang
 * @date: 2022-05-05 8:03
 * @description:
 */
public class RedoCommand extends Command implements Executable {
    @Override
    protected void executeCommand() {
        throw new RuntimeException("Redo org.zlyang.memoryDrawer.command execute!");
    }

    @Override
    public String toString() {
        return "redo";
    }
}
