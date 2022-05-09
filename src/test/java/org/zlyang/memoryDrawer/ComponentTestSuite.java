package org.zlyang.memoryDrawer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.zlyang.memoryDrawer.board.BoardSuite;
import org.zlyang.memoryDrawer.drawer.DrawerSuite;
import org.zlyang.memoryDrawer.serviceTest.ServiceSuite;

/**
 * @author: zlyang
 * @date: 2022-05-09 14:57
 * @description:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BoardSuite.class, DrawerSuite.class, ServiceSuite.class})
public class ComponentTestSuite {
}
