package org.zlyang.memoryDrawer.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-04-30 16:58
 * @description:
 */
public class LineDrawer {

    private LineDrawer() {
    }

    public static List<Point> drawLine(int x0, int y0, int x1, int y1) {
        List<Point> line = new ArrayList<>();

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx-dy;
        int e2;

        while (true) {
            line.add(new Point(x0, y0));

            if (x0 == x1 && y0 == y1){
                break;
            }
            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x0 = x0 + sx;
            }
            if (e2 < dx) {
                err = err + dx;
                y0 = y0 + sy;
            }
        }

        return line;
    }
}
