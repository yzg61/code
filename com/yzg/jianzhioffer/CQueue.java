package com.yzg.jianzhioffer;

import java.util.Stack;

public class CQueue {

    /**
     * 剑指 Offer 09. 用两个栈实现队列
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * 示例 2：
     * <p>
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     * 提示：
     * <p>
     * 1 <= values <= 10000
     * 最多会对 appendTail、deleteHead 进行 10000 次调用
     */

    Stack<Integer> input;
    Stack<Integer> out;

    public CQueue() {
        this.input = new Stack<>();
        this.out = new Stack<>();
    }

    public void appendTail(int value) {
        input.push(value);
    }

    public int deleteHead() {
        if (out.empty()) {
            while (!input.empty()) {
                out.push(input.pop());
            }
        }

        return out.empty() ? -1 : out.pop();
    }


}
