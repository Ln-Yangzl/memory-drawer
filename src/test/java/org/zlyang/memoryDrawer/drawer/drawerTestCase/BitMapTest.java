package org.zlyang.memoryDrawer.drawer.drawerTestCase;

import org.junit.Test;
import org.zlyang.memoryDrawer.utils.BitMap;

import static org.junit.Assert.assertEquals;

/**
 * @author: zlyang
 * @date: 2022-05-03 18:59
 * @description:
 */
public class BitMapTest {

    @Test
    public void bitMapTest(){
        BitMap bitMap = new BitMap(10);
        bitMap.set(2, 1);
        bitMap.set(8, 1);
        assertEquals("  1     1 ", bitMap.toString());
    }

    @Test
    public void bitMapGetSetTest(){
        BitMap bitMap = new BitMap(100);
        assertEquals(0, bitMap.get(50));
        bitMap.set(33, 1);
        assertEquals(1, bitMap.get(33));
    }

    @Test
    public void bitMapCloneTest(){
        BitMap bitMap = new BitMap(5);
        BitMap clone = new BitMap(bitMap);
        clone.set(0, 1);
        assertEquals("     ", bitMap.toString());
        assertEquals("1    ", clone.toString());
    }

}
