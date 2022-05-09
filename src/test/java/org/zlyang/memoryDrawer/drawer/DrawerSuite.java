package org.zlyang.memoryDrawer.drawer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.zlyang.memoryDrawer.drawer.drawerTestCase.BitMapTest;
import org.zlyang.memoryDrawer.drawer.drawerTestCase.DrawerTest;

/**
 * @author: zlyang
 * @date: 2022-05-09 15:01
 * @description:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DrawerTest.class, BitMapTest.class})
public class DrawerSuite {
}
