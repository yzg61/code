package com.yzg.leetcode;

import java.util.Arrays;

public class Cheapest_flights_within_k_stops {

    /**
     * 787. K 站中转内最便宜的航班
     * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
     * <p>
     * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 1
     * 输出: 200
     * 解释:
     * 城市航班图如下
     * <p>
     * <p>
     * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
     */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //DP[i][k]表示从城市src到城市j加过k站中转的最便宜价格
        int[][] dp = new int[n + 1][K + 1];
        //初始化为最大值
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        //初始化 k = 0 的价格
        for (int[] flight : flights) {
            //出发城市
            int s = flight[0];
            //目的城市
            int d = flight[1];
            //单程价格
            int p = flight[2];
            if (src == s) {
                dp[d][0] = p;
            }
        }
        dp[src][0] = 0;
        for (int k = 1; k < K + 1; k++) {
            //直接到目的城市价格为0
            dp[src][k] = 0;
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                if (dp[s][k - 1] != Integer.MAX_VALUE) {
                    //k站中转直接到 d，或者 k - 1 站中转到 s(如果存在该路线的话)， 再从 s出发到 d
                    dp[d][k] = Math.min(dp[d][k], dp[s][k - 1] + p);
                }
            }
        }

        return dp[dst][K] != Integer.MAX_VALUE ? dp[dst][K] : -1;
    }
}
