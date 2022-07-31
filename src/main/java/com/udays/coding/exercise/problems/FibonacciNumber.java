package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 509
 * Problem statement:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 30
 */

public class FibonacciNumber {

    //Time complexity: O(N)
    //Space complexity: O(N)

    //memoization reduced the runtime from 11ms to 0ms

    HashMap<Integer, Integer> cache = new HashMap();

    public int fib(int n) {

        //if result was calculated before, return
        if(cache.containsKey(n))
            return cache.get(n);

        int result = 1;
        if(n<=1)
            result = n;
        else
            result = fib(n-1)+fib(n-2);

        cache.put(n, result);

        return result;
    }

}
