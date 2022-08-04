package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 739
 * Problem statement:
 */

public class DailyTemperatures {

    //answer similar to Next Greate ElementI but with indexes
    //Time complexity: O(n) as we iterate on temperatures twice
    //Space complexity: O(n) size of hashmap

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack();
        //map will maintain index,answer
        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                map.put(stack.peek(), i-stack.peek());
                stack.pop();
            }
            stack.push(i);
        }

        int[] answer = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            answer[i] = map.getOrDefault(i,0);
        }

        return answer;

    }

}
