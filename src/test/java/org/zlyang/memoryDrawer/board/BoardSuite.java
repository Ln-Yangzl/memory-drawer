package org.zlyang.memoryDrawer.board;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.zlyang.memoryDrawer.board.boardTestCase.BinaryBoardTest;
import org.zlyang.memoryDrawer.board.boardTestCase.GreyBoardTest;

/**
 * @author: zlyang
 * @date: 2022-05-09 14:58
 * @description:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BinaryBoardTest.class, GreyBoardTest.class})
public class BoardSuite {
}
