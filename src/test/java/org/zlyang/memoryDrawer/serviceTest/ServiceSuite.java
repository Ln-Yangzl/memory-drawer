package org.zlyang.memoryDrawer.serviceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.zlyang.memoryDrawer.serviceTest.serviceTestCase.CommandTest;
import org.zlyang.memoryDrawer.serviceTest.serviceTestCase.ExecutorTest;
import org.zlyang.memoryDrawer.serviceTest.serviceTestCase.ParserTest;
import org.zlyang.memoryDrawer.serviceTest.serviceTestCase.ReaderTest;

/**
 * @author: zlyang
 * @date: 2022-05-09 14:59
 * @description:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CommandTest.class, ExecutorTest.class, ParserTest.class, ReaderTest.class})
public class ServiceSuite {
}
