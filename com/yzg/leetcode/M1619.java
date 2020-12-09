package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class M1619 {
    /**
     * 面试题 16.19. 水域大小
     * 你有一个用于表示一片土地的整数矩阵land，
     * 该矩阵中每个点的值代表对应地点的海拔高度。
     * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。
     * 池塘的大小是指相连接的水域的个数。
     * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
     * <p>
     * 示例：
     * <p>
     * 输入：
     * [
     * [0,2,1,0],
     * [0,1,0,1],
     * [1,1,0,1],
     * [0,1,0,1]
     * ]
     * 输出： [1,2,4]
     * 提示：
     * <p>
     * 0 < len(land) <= 1000
     * 0 < len(land[i]) <= 1000
     */

    int area;
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 0) {
                    area =0;
                    findPool(land, i, j);
                    list.add(area);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private void findPool(int[][] land, int i, int j) {
        if (i >= 0 && i < land.length && j >= 0 && j < land[i].length &&
                land[i][j] == 0) {
            land[i][j] = -1;
            area++;
            findPool(land, i + 1, j + 1);
            findPool(land, i + 1, j - 1);
            findPool(land, i + 1, j);
            findPool(land, i, j + 1);
            findPool(land, i, j - 1);
            findPool(land, i - 1, j + 1);
            findPool(land, i - 1, j - 1);
            findPool(land, i - 1, j);
        }
    }

}
