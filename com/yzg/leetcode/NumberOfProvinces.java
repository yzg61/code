package com.yzg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    /**
     * 547. 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * <p>
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * <p>
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回矩阵中 省份 的数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     * <p>
     * <p>
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] 为 1 或 0
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        Set<Integer> existeds = new HashSet<>(isConnected.length << 1);
        for (int i = 0; i < isConnected.length; i++) {
            if (!existeds.contains(i)) {
                dfs(existeds, isConnected, i);
                res++;
            }
        }

        return res;
    }

    private void dfs(Set<Integer> existeds, int[][] isConnected, int i) {
        if (existeds.contains(i)) {
            return;
        }
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1) {
                existeds.add(i);
                dfs(existeds, isConnected, j);
            }
        }
    }
}
