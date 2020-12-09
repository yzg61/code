package com.yzg.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {
    /**
     * 855. 考场就座
     * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
     * <p>
     * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
     * <p>
     * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
     * 输出：[null,0,9,4,2,null,5]
     * 解释：
     * ExamRoom(10) -> null
     * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
     * seat() -> 9，学生最后坐在 9 号座位上。
     * seat() -> 4，学生最后坐在 4 号座位上。
     * seat() -> 2，学生最后坐在 2 号座位上。
     * leave(4) -> null
     * seat() -> 5，学生最后坐在 5 号座位上。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= N <= 10^9
     * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
     * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
     */

    private final TreeSet<Integer> seats;
    private final int size;

    public ExamRoom(int N) {
        seats = new TreeSet<>();
        size = N;
    }

    public int seat() {
        if (seats.size() == 0) {
            //没有人在考场里，那么学生坐在 0 号座位上。
            seats.add(0);
            return 0;
        }
        //遍历所有有学生的座位
        Iterator<Integer> iterator = seats.iterator();
        //head表示第一有学生的座位编号
        //pre表示上一个有学生的座位编号
        //cur表示当前有学生的座位编号
        //seat表示下一个学生可能坐的座位编号
        int head = iterator.next(), pre = head, cur = head, seat = 0;
        //maxSpace表示 (cur - pre)/2 的最大值，如果maxSpace有更大的值，更新seat = (cur + pre)/2
        //maxSpace初始值 = head，表示在head != 0的情况下，优先假设放在0号座位，
        // 在遍历过程中，如果没有更大的maxSpace出现，那么假设放在0号座位成立，返回seat = 0；
        int maxSpace = head;
        while (iterator.hasNext()) {
            cur = iterator.next();
            int d;
            if ((d = (cur - pre) >> 1) > maxSpace) {
                maxSpace = d;
                seat = (cur + pre) >> 1;
            }
            pre = cur;
        }
        //假设放末尾的座位
        if ((size - 1 - pre) > maxSpace) {
            seat = size - 1;
        }
        seats.add(seat);
        return seat;
    }

    public void leave(int p) {
        seats.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(4);
        int seat = room.seat();
        System.out.println(seat);
        seat = room.seat();
        System.out.println(seat);
        seat = room.seat();
        System.out.println(seat);
        seat = room.seat();
        System.out.println(seat);

        room.leave(1);
        room.leave(3);
        seat = room.seat();
        System.out.println(seat);
    }
}
