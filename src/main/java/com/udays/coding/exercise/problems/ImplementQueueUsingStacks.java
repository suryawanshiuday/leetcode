package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 232
 * Problem statement:
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */

public class ImplementQueueUsingStacks {

    //Time complexity: O()
    //Space complexity: O()

    class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;
        int head;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(s1.isEmpty()){
                head=x;
            }
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            //empty everything from s1 into s2
            //return top element from s2
            //reverse step 1
            int retVal=-1;
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            if(!s2.isEmpty()){
                retVal = s2.pop();
                //if s2 has only 1 element, it will be empty after pop
                if(!s2.isEmpty()){
                    head = s2.peek();
                }
            }
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            //System.out.println("peek s1:"+s1.size()+", s2:"+s2.size());
            return retVal;
        }

        /** Get the front element. */
        public int peek() {
            return head;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}
