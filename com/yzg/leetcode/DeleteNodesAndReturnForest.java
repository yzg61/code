package com.yzg.leetcode;

import com.yzg.jianzhioffer.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    /**
     * 1110. 删点成林
     * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
     * <p>
     * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
     * <p>
     * 返回森林中的每棵树。你可以按任意顺序组织答案。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
     * 输出：[[1,2,null,4],[6],[7]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 树中的节点数最大为 1000。
     * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
     * to_delete.length <= 1000
     * to_delete 包含一些从 1 到 1000、各不相同的值。
     */
    public static void main(String[] args) {
        DeleteNodesAndReturnForest main = new DeleteNodesAndReturnForest();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        List<TreeNode> treeNodes = main.delNodes(node, new int[]{2});
        System.out.println(treeNodes);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> delSet = new HashSet<>();
        for (int i : to_delete) {
            delSet.add(i);
        }

        first(null, root, delSet, list);

        return list;
    }

    private void first(TreeNode par, TreeNode node, Set<Integer> delSet, List<TreeNode> list) {

        if (node != null) {
            if (delSet.contains(node.val)) {
                if (par != null) {
                    par.right = par.right == node ? null : par.right;
                    par.left = par.left == node ? null : par.left;
                }
                first(null,node.left, delSet, list);
                first(null, node.right, delSet, list);

            } else {
                if (par == null) {
                    list.add(node);
                }
                first(node,node.left, delSet, list);
                first(node, node.right, delSet, list);
            }

        }
    }
}
