package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    /**
     * 901. 股票价格跨度
     * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
     * <p>
     * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
     * <p>
     * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
     * 输出：[null,1,1,1,2,1,4,6]
     * 解释：
     * 首先，初始化 S = StockSpanner()，然后：
     * S.next(100) 被调用并返回 1，
     * S.next(80) 被调用并返回 1，
     * S.next(60) 被调用并返回 1，
     * S.next(70) 被调用并返回 2，
     * S.next(60) 被调用并返回 1，
     * S.next(75) 被调用并返回 4，
     * S.next(85) 被调用并返回 6。
     * <p>
     * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
     * (包括今天的价格 75) 小于或等于今天的价格。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
     * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
     * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
     * 此问题的总时间限制减少了 50%。
     */

    public StockSpanner() {
        dec = new Stack<>();
        num = new Stack<>();
    }

    /**
     * 存放非递增股票价格的栈
     */
    private final Stack<Integer> dec;
    /**
     * 存放股票价格对应的股票跨度的站
     */
    private final Stack<Integer> num;

    public int next(int price) {
        //当天的股票跨度，初始为 1
        int res = 1;
        /**
         * 控制股票价格栈为非递增
         * 从价格栈中弹出比当天价格少的元素，
         * 同时从 股票跨度栈 弹出 股票跨度 累加到 当天的 股票跨度
         */
        while (!dec.isEmpty() && dec.peek() <= price) {
            dec.pop();
            res += num.pop();
        }
        //当天价格和跨度添加到栈顶
        dec.push(price);
        num.push(res);
        return res;
    }

    public static void main(String[] args) {
        StockSpanner main = new StockSpanner();
        System.out.println(main.next(85));
        System.out.println(main.next(76));
        System.out.println(main.next(43));
        System.out.println(main.next(26));
        System.out.println(main.next(52));
        System.out.println(main.next(75));
        System.out.println(main.next(85));

    }
}
