package com.yzg.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

public class ThreePathSum {
    /**
     * 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
     * 例如：
     * 给出如下的二叉树，\ sum=22 sum=22，
     * <p>
     * 返回
     * [
     * [5,4,11,2],
     * [5,8,9]
     * ]
     */
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    private static final ArrayList<ArrayList<Integer>> LIST = new ArrayList<>();

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // write code here
        List<Integer> s = new ArrayList<>();
        firstPathSum(root, sum, s);
        return LIST;
    }

    private void firstPathSum(TreeNode root, int sum, List<Integer> s) {
        //空节点退出
        if (root == null) {
            return;
        }
        s.add(root.val);
        //是叶子节点 && 满足根节点到叶子节点的节点值之和等于sum
        if (root.left == null && root.right == null && (sum - root.val == 0)) {

            //添加到结果集（拷贝满足条件的list）
            LIST.add(new ArrayList<>(s));
            //从list移除当前(最后一个)节点，回溯
            s.remove(s.size() - 1);
            return;
        }
        //先序遍历
        firstPathSum(root.left, sum - root.val, s);
        firstPathSum(root.right, sum - root.val, s);
        s.remove(s.size() - 1);
    }


    /**
     * test
     */
    public static void main(String[] args) {
        ThreePathSum main = new ThreePathSum();
        TreeNode node = new TreeNode();
        node.val = 1;
        ArrayList<ArrayList<Integer>> arrayLists = main.pathSum(node, 0);
        System.out.println(arrayLists);
    }
}
