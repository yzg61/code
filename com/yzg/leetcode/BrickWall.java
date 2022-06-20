package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    /**
     * 554. 砖墙
     * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
     * <p>
     * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
     * <p>
     * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：wall = [[1],[1],[1]]
     * 输出：3
     * <p>
     * 提示：
     * <p>
     * n == wall.length
     * 1 <= n <= 104
     * 1 <= wall[i].length <= 104
     * 1 <= sum(wall[i].length) <= 2 * 104
     * 对于每一行 i ，sum(wall[i]) 是相同的
     * 1 <= wall[i][j] <= 231 - 1
     *
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        int maxGap = 0;
        Map<Integer, Integer> res = new HashMap<>();
        for (List<Integer> rows : wall) {
            int i = 0;

            for (int j = 0; j < rows.size() - 1; j++) {
                i += rows.get(j);
                res.merge(i, 1, Integer::sum);
                maxGap = Math.max(res.get(i), maxGap);
            }
        }
        return wall.size() - maxGap;
    }

    public static void main(String[] args) {
        BrickWall main = new BrickWall();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        main.leastBricks(wall);
    }
}
