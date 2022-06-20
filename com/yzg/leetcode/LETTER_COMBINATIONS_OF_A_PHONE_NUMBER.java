package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LETTER_COMBINATIONS_OF_A_PHONE_NUMBER {
    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     */
    List<String> res = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<Character, List<Character>>(){
        {
            put('2', Arrays.asList('a','b','c'));
            put('3', Arrays.asList('d','e','f'));
            put('4', Arrays.asList('g','h','i'));
            put('5', Arrays.asList('j','k','l'));
            put('6', Arrays.asList('m','n','o'));
            put('7', Arrays.asList('p','q','r','s'));
            put('8', Arrays.asList('t','u','v'));
            put('9', Arrays.asList('w','x','y','z'));
        }
    };
    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            char[] chars = new char[digits.length()];
            dfs(0, digits, chars);
        }
        return res;
    }

    private void dfs(int i, String digits, char[] chars) {
        if (i > digits.length() - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        char c = digits.charAt(i);
        List<Character> characters = map.get(c);
        for (Character ch : characters) {
            chars[i] = ch;
            dfs(i+1, digits, chars);
        }
    }

    public static void main(String[] args) {
        LETTER_COMBINATIONS_OF_A_PHONE_NUMBER main = new LETTER_COMBINATIONS_OF_A_PHONE_NUMBER();
        List<String> strings = main.letterCombinations("23");
        System.out.println(strings);
    }
}
