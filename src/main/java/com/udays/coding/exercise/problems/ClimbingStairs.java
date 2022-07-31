package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 70
 * Problem statement:
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */

public class ClimbingStairs {

    //Time complexity: O(N)
    //Space complexity: O(N)

    //memoization
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        //start climbing from step 0 until you reach n
        //answer = answer (1 step) + answer (2 steps)
        return climb(0, n);
    }

    public int climb(int step, int n){
        if(cache.containsKey(n))
            return cache.get(n);
        //if we have less steps than top, you can take further step
        if(step>n)
            return 0;
        //if we can reach top in exact step, return 1
        if(step==n)
            return 1;

        //calculate combinations to climb 1 step at a time
        int step1Count = climb(step+1, n);
        //calculate combinations to climb 2 steps at a time
        int step2Count = climb(step+2, n);
        int result = step1Count + step2Count;
        cache.put(n,step1Count);
        return result;

    }

}
