package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 739
 * Problem statement:
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
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
