package com.yzg.leetcode;

public class SurroundedRegions {
    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
     * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * 示例 2：
     * <p>
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     *  
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 200
     * board[i][j] 为 'X' 或 'O'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public void solve(char[][] board) {

        // 从矩阵的4边出发，替换所有的相邻的 'O' 为 'E';
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board,0, i);
            dfs(board, board.length - 1, i);
        }
        //遍历矩阵，'E'替换为 'O'， 剩下的都是'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                if ('E' == board[i][j]) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return;
        }
        if ('O' == board[i][j]) {
            board[i][j] = 'E';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }

    }
}
