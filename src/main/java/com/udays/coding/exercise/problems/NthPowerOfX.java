package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 50
 * Problem statement:
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 */

public class NthPowerOfX {

    //Fast power algorithm
    //e.g. 3^8 = 3^4*3^4
    //3^9 = 3^4*3^4*3

    //Time complexity: O(logN) as we are dividing n into half for each iteration
    //Space complexity: O(1) in place calculation

    //iterative
    public double myPow(double x, int n) {
        long N = n;
        double ans = 1;
        double current = x;
        for(long i=Math.abs(N); i>0; i/=2){
            if((i%2)==1)
                ans = ans*current;
            current = current * current;
        }
        if(n<0)
            return 1.0/ans;
        return ans;
    }

    //recursive

    /*public double myPow(double x, int n) {

        double answer = raise(x, Math.abs(n));

        if(n<0)
            answer = 1/answer;

        return answer;
    }

    public double raise(double x, int n){

        if(n==0)
            return 1;

        double half = raise(x, n/2);

        if(n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
    */


    /*
    //naive recursion causes stack overflow for very large n

    public double myPow(double x, int n) {
        double answer = raise(x, Math.abs(n), 1);
        if(n<0)
            answer = 1/answer;
        return answer;
    }

    public double raise(double x, int target, int current){
        if(current > target)
            return 1;
        current++;
        return x * raise(x, target, current);
    }

    */


}
