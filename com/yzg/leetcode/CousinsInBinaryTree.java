package com.yzg.leetcode;

import com.yzg.jianzhioffer.TreeNode;

public class CousinsInBinaryTree {
    /**
     * 993. 二叉树的堂兄弟节点
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     * <p>
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     * <p>
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     * <p>
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,2,3,4], x = 4, y = 3
     * 输出：false
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
     * 输出：true
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,null,4], x = 2, y = 3
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 二叉树的节点数介于 2 到 100 之间。
     * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
     */

    int depthX = 0;
    int depthY = 0;
    int parentX = 0;
    int parentY = 0;

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(0,root, root.left, x, y);
        dfs(0,root, root.right, x, y);

        return depthX == depthY && parentX != parentY;
    }

    private void dfs(int depth, TreeNode parent, TreeNode node, int x, int y) {
        if (node != null) {
            depth++;

            if (node.val == x) {
                depthX = depth;
                parentX = parent.val;
            }
            if (node.val == y) {
                depthY = depth;
                parentY = parent.val;
            }
            dfs(depth, node, node.left, x, y);
            dfs(depth, node, node.right, x, y);
        }
    }
}
