package com.yzg.dianxinyun;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author yzg
 * @create 2019/9/18
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine()
                .split(";");
        String s1 = str[0];
        String s2 = str[1];

        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();

        if (b1.length != b2.length || b1.length == 0){
            System.out.println("False");
            return;
        }

        Map<Byte,Byte> map = new HashMap<>();
        Set<Byte> set = new HashSet<>();
        byte a1;
        byte a2;

        for (int i = 0; i < b1.length; i++){
            a1 = b1[i];
            a2 = b2[i];
            if (!map.containsKey(a1)){
                if (set.contains(a2)){
                    System.out.println("False");
                    return;
                }else {
                    map.put(a1,a2);
                    set.add(a2);
                }
            }else {
                if (map.get(a1) != a2){
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");
    }
}
