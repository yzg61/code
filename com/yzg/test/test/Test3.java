package com.yzg.test.test;

import org.junit.Test;

import java.util.Stack;

/**
 * @author yzg
 * @create 2019/7/19
 */
public class Test3 {
    /**
     * 使用栈结构实现队列结构
     */

    public static class TwoStacksQueue{
        private Stack<Integer> pop = new Stack<>();
        private Stack<Integer> push = new Stack<>();

        public void push(int pushInt){
            push.push(pushInt);
        }

        public void dao(){
            if (!pop.isEmpty()){
                return;
            }
            while (!push.isEmpty()){
                pop.push(push.pop());
            }
        }

        public int poll(){
            if (pop.empty() && push.empty()){
                throw new RuntimeException("Queue is empty");
            }
            dao();
            return pop.pop();
        }
        public int peek(){
            if (pop.empty() && push.empty()){
                throw new RuntimeException("Queue is empty");
            }
            dao();
            return pop.peek();
        }
    }
    
    @Test
    public void test(){
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.peek() = " + queue.peek());
    }
}
