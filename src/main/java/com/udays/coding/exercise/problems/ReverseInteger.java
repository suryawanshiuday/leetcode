package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 7
 * Problem statement:
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */

public class ReverseInteger {

    //Time complexity: O(N) where n=number of digits in x
    //Space complexity: O(1)

    public int reverse(int x) {

        //Int max= 2147483647
        //Int min = -2147483648

        //Algorithm
        //pop one digit from end of x (x%10), x becomes x/10
        //push that digit to back of answer (ans*10+pop)

        /*
        pop=x%10
        x = x/10;
        rev = rev*10+pop; (stating rev=0)

        Overflow conditions
        1. if tmp equation above causes overflow, then it must be >= int max/10
        2. so we can say, if rev>int max/10, it will cause overflow
        3. or if rev=max/10, then it will cause overflow if pop>7 (look at int max value above)
        */

        int rev = 0;
        while(x!=0){
            int pop = x%10;
            x = x/10;
            if(rev > Integer.MAX_VALUE/10
                    || (rev==Integer.MAX_VALUE && pop>7))
                return 0;
            if(rev < Integer.MIN_VALUE/10
                    || (rev==Integer.MIN_VALUE && pop<-8))
                return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }

}
