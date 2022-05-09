package org.zlyang.memoryDrawer.board;

import org.zlyang.memoryDrawer.utils.Point;

import java.util.List;

/**
 * @author: zlyang
 * @date: 2022-04-30 15:54
 * @description:
 */
public interface Board {

    /**
     * 通过点列表进行绘制
     * @param points 点列表
     */
    void draw(List<Point> points);

    /**
     * 获取当前状态，用于undo
     * @return  当前的board状态
     */
    Object getState();

    /**
     * 设置当前状态，用于undo
     * @param state 将当前board的状态更新为
     */
    void setState(Object state);

    /**
     * 获取当前设置颜色值
     * @return 颜色值
     */
    int getColor();

    /**
     * 设置新的颜色值
     * @param color 新颜色值
     * @return      原来的颜色值
     */
    int setColor(int color);

}
