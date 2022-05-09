package org.zlyang.memoryDrawer.drawer;

import org.junit.Test;
import org.zlyang.memoryDrawer.utils.LineDrawer;
import org.zlyang.memoryDrawer.utils.Point;
import org.zlyang.memoryDrawer.utils.TextDrawer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-03 9:38
 * @description:
 */
public class DrawerTest {
    
    @Test
    public void testDrawLine(){
        List<Point> simpleLine = new ArrayList<>();
        simpleLine.add(new Point(0, 0));
        simpleLine.add(new Point(1, 1));
        simpleLine.add(new Point(2, 2));
        List<Point> approximateLine = new ArrayList<>();
        approximateLine.add(new Point(0, 0));
        approximateLine.add(new Point(1, 0));
        approximateLine.add(new Point(2, 1));
        approximateLine.add(new Point(3, 1));
        approximateLine.add(new Point(4, 2));
        approximateLine.add(new Point(5, 2));

        assertEquals(simpleLine, LineDrawer.drawLine(0, 0, 2, 2));
        assertEquals(approximateLine, LineDrawer.drawLine(0, 0, 5, 2));
    }

    @Test
    public void testDrawText(){
        ArrayList<Point> singleChar = new ArrayList<>();
        singleChar.add(new Point(3, 7));
        singleChar.add(new Point(3, 6));
        singleChar.add(new Point(3, 5));
        singleChar.add(new Point(3, 4));
        singleChar.add(new Point(3, 3));
        singleChar.add(new Point(3, 1));
        List<Point> text = TextDrawer.drawText(0, 0, "!");
        assertEquals(singleChar, text);


        ArrayList<Point> simpleText = new ArrayList<>();
        simpleText.addAll(singleChar);

        /**
         * 0000 0000
         * 0000 0000
         * 0111 0000
         * 0000 1000
         * 0011 1000
         * 0100 1000
         * 0011 0100
         * 0000 0000
         */
        simpleText.add(new Point(9, 5));
        simpleText.add(new Point(10, 5));
        simpleText.add(new Point(11, 5));
        simpleText.add(new Point(12, 4));
        simpleText.add(new Point(10, 3));
        simpleText.add(new Point(11,3));
        simpleText.add(new Point(12, 3));
        simpleText.add(new Point(9, 2));
        simpleText.add(new Point(12, 2));
        simpleText.add(new Point(10, 1));
        simpleText.add(new Point(11, 1));
        simpleText.add(new Point(13, 1));
        assertEquals(simpleText, TextDrawer.drawText(0, 0, "!a"));
    }
    
}
