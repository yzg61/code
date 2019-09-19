package com.yzg.test.test;

/**
 * @author yzg
 * @create 2019/8/15
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * /*
 * * 【例】 如何得到346987521的下一个
 * *      * 1，从尾部往前找第一个P(i-1) < P(i)的位置
 * *      * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
 * *      * 最终找到6是第一个变小的数字，记录下6的位置i-1
 * *      *
 * *      * 2，从i位置往后找到最后一个大于6的数
 * *      * 3 4 6 -> 9 -> 8 -> 7 5 2 1
 * *      * 最终找到7的位置，记录位置为m
 * *      *
 * *      * 3，交换位置i-1和m的值
 * *      * 3 4 7 9 8 6 5 2 1
 * *      * 4，倒序i位置后的所有数据
 * *      * 3 4 7 1 2 5 6 8 9
 * *      * 则347125689为346987521的下一个排列
 */
public class Test15 {

    public int MoreThanHalfNum_Solution(int [] array) {
        int num = 0;
        int [] arr = new int[array.length];
        for(int i = 0;i<array.length;i++){
            arr[i] = array[i];
        }

        for(int i =0;i<arr.length;i++){
            if(arr[i] == 0)
                continue;
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] != arr[j] && arr[j] != 0){
                    arr[i]=0;
                    arr[j]=0;
                    break;
                }
            }
        }
        int result = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0)
            {
                result = arr[i];
                break;
            }


        }
        if(result == 0)
            return 0;
        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == result)
                count++;
        }
        if(count*2 >= array.length)
            return count;
        return 0;


    }

    public static void main(String[] args) {
        Test15 t = new Test15();
        System.out.println(t.MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] chars,int k){
        if(chars==null || chars.length<=k)
            return;
        int len = chars.length;
        for(int i=0;i<(len-k)/2;i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
            }
        }

    }


    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
