package com.yzg.leetcode;

public class LongestPalindrome {

    String max = "";

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            getLongest(s, i, i);
            getLongest(s, i, i + 1);
        }

        return max;
    }

    private void getLongest(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                if ((r + 1 - l) >= max.length()) {
                    max = s.substring(l, r + 1);
                }
            } else {
                break;
            }
            l--;
            r++;
        }
    }

    public static void main(String[] args) {
        LongestPalindrome main = new LongestPalindrome();
        String a = main.longestPalindrome("ccc");
        System.out.println(a);
    }

}
