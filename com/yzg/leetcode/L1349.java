package com.yzg.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

public class L1349 {
    /**
     * 1349. 参加考试的最大学生数
     * 给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
     * <p>
     * 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
     * <p>
     * 学生必须坐在状况良好的座位上。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：seats = [['#','.','#','#','.','#'],
     * ['.','#','#','#','#','.'],
     * ['#','.','#','#','.','#']]
     * 输出：4
     * 解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。
     * 示例 2：
     * <p>
     * 输入：seats = [['.','#'],
     * ['#','#'],
     * ['#','.'],
     * ['#','#'],
     * ['.','#']]
     * 输出：3
     * 解释：让所有学生坐在可用的座位上。
     * 示例 3：
     * <p>
     * 输入：seats = [['#','.','.','.','#'],
     * ['.','#','.','#','.'],
     * ['.','.','#','.','.'],
     * ['.','#','.','#','.'],
     * ['#','.','.','.','#']]
     * 输出：10
     * 解释：让学生坐在第 1、3 和 5 列的可用座位上。
     * <p>
     * <p>
     * 提示：
     * <p>
     * seats 只包含字符 '.' 和'#'
     * m == seats.length
     * n == seats[i].length
     * 1 <= m <= 8
     * 1 <= n <= 8
     */

    char[][] Seat;
    int max = 0;

    public int maxStudents(char[][] seats) {
        Seat = seats;
        int x = seats.length;
        int y = seats[0].length;
        dfs(new boolean[x][y], 0, 0, 0);

        return max;
    }

    private void dfs(boolean[][] seats, int i, int j, int num) {
        int x = seats.length;
        int y = seats[0].length;
        //超出边界
        if (j >= y) {
            dfs(seats, i + 1, 0, num);
            return;
        }
        //完成一次
        if (i >= x) {
            if (num > max) {
                max = num;
            }
            return;
        }

        //当前位置不能有人
        if (Seat[i][j] != '.'||
                ((i - 1 >= 0) && (j - 1 >= 0) && seats[i - 1][j - 1]) ||
                ((i - 1 >= 0) && (j + 1 < y) && seats[i - 1][j + 1]) ||
                ((j - 1 >= 0) && seats[i][j - 1])) {
            dfs(seats, i, j + 1, num);
        } else {
            //当前位置有人
            boolean[][] clone = seats.clone();
            clone[i][j] = true;
            dfs(clone, i, j + 1, num + 1);

            //当前位置没人
            dfs(seats, i, j + 1, num);
        }

    }

    public static void main(String[] args) {
        L1349 main = new L1349();

        int i = main.maxStudents(new char[][]
                {
                        {'#','.','.','.','#'},
                        {'.','#','.','#','.'},
                        {'.','.','#','.','.'},
                        {'.','#','.','#','.'},
                        {'#','.','.','.','#'}
                });
        System.out.println(i);
    }
}
