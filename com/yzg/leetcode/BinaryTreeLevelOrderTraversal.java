package com.yzg.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.yzg.jianzhioffer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * 102. 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层序遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        } else {
            ArrayDeque<TreeNode> queueFrom = new ArrayDeque<>(200);
            ArrayDeque<TreeNode> queueTo = new ArrayDeque<>(200);

            queueFrom.add(root);

            dfs(queueFrom, queueTo, list);

        }

        return list;
    }

    private void dfs(ArrayDeque<TreeNode> queueFrom,
                     ArrayDeque<TreeNode> queueTo,
                     List<List<Integer>> list) {
        if (!queueFrom.isEmpty()) {
            List<Integer> valList = new ArrayList<>();
            while (!queueFrom.isEmpty()) {
                TreeNode node = queueFrom.poll();
                valList.add(node.val);
                if (node.left != null) {
                    queueTo.add(node.left);
                }
                if (node.right != null) {
                    queueTo.add(node.right);
                }
            }
            list.add(valList);
            dfs(queueTo, queueFrom, list);
        }

    }
}
