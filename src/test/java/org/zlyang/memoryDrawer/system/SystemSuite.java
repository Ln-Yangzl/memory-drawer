package org.zlyang.memoryDrawer.system;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.zlyang.memoryDrawer.system.commandTest.*;

/**
 * @author: zlyang
 * @date: 2022-05-09 15:02
 * @description:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ColorTest.class, LineTest.class, MacroTest.class, RedoTest.class, TextTest.class,UndoTest.class})
public class SystemSuite {
}
