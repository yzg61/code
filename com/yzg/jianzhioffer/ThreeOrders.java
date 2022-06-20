package com.yzg.jianzhioffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class ThreeOrders {
    /**
     * 题目描述
     * 分别按照二叉树先序，中序和后序打印所有的节点。
     * 示例1
     * 输入
     * {1,2,3}
     * 返回值
     * [[1,2,3],[2,1,3],[2,3,1]]
     * 备注:
     * n \leq 10^6n≤10
     * 6
     */
    private static final List<Integer> FIRST = new ArrayList<>();
    private static final List<Integer> MIDDLE = new ArrayList<>();
    private static final List<Integer> BEHIND = new ArrayList<>();

    public int[][] threeOrders (TreeNode root) {
        // write code here
        firstOrder(root);
        int[] firsts = FIRST.stream().mapToInt(Integer::intValue).toArray();

        middleOrder(root);
        int[] middles = MIDDLE.stream().mapToInt(Integer::intValue).toArray();

        behindOrder(root);
        int[] behinds = BEHIND.stream().mapToInt(Integer::intValue).toArray();

        int[][] arr = new int[3][];
        arr[0] = firsts;
        arr[1] = middles;
        arr[2] = behinds;

        return arr;
    }
    public static void firstOrder(TreeNode root) {
        if (root != null) {
            FIRST.add(root.val);
            firstOrder(root.left);
            firstOrder(root.right);
        }

    }

    public static void middleOrder(TreeNode root) {
        if (root != null) {
            middleOrder(root.left);
            MIDDLE.add(root.val);
            middleOrder(root.right);
        }
    }

    public static void behindOrder(TreeNode root) {
        if (root != null) {
            behindOrder(root.left);
            behindOrder(root.right);
            BEHIND.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        ThreeOrders main = new ThreeOrders();
        System.out.println(Arrays.deepToString(main.threeOrders(root)));;
    }
}
