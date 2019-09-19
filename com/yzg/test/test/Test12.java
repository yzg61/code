package com.yzg.test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzg
 * @create 2019/8/8
 */
public class Test12 {
    public static void main(String[] args) {
        List<String> aa = new ArrayList<String>();
        aa.add("F1");
        aa.add("F2");
        aa.add("F3");
        for (String temp : aa) {
            if ("F3".equals(temp)) {
                aa.remove(temp);
            }
        }

        for (String temp : aa){
            System.out.println(temp);
        }

    }
}
