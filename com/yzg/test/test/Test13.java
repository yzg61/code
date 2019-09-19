package com.yzg.test.test;

/**
 * @author yzg
 * @create 2019/8/14
 * <p>
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Test13 {
    public static void main(String[] args) {
        Test13 t = new Test13();
        int[] sequence = {7, 4, 6, 5};
        System.out.println(t.VerifySquenceOfBST(sequence));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1) {
            return true;
        }


        return ju(sequence, 0, sequence.length - 1);
    }

    public boolean ju(int[] arr, int start, int root) {
        if (start >= root)
            return true;
        //右子树从后往前都比root大
        int i = root;
        while (i > start && arr[i - 1] > arr[root]) {
            i--;
        }
        //左子树从前往后到i - 1都比root小
        for (int j = start; j < i - 1; j++) {
            if (arr[j] > arr[root])
                return false;
        }

        return ju(arr, start, i - 1) && ju(arr, i, root - 1);

    }
}
