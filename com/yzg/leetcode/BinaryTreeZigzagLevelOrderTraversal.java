package com.yzg.leetcode;

import com.yzg.jianzhioffer.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 103. 二叉树的锯齿形层序遍历
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层序遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        } else {
            ArrayDeque<TreeNode> queueFrom = new ArrayDeque<>(200);
            ArrayDeque<TreeNode> queueTo = new ArrayDeque<>(200);

            queueFrom.add(root);

            dfs(queueFrom, queueTo, list, true);

        }

        return list;
    }

    private void dfs(ArrayDeque<TreeNode> queueFrom,
                     ArrayDeque<TreeNode> queueTo,
                     List<List<Integer>> list, boolean positive) {
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
            if (!positive) {
                Collections.reverse(valList);
            }
            list.add(valList);
            dfs(queueTo, queueFrom, list, !positive);
        }

    }
}
