package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 246
 * Problem statement:
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num.length <= 50
 * num consists of only digits.
 * num does not contain any leading zeros except for zero itself.
 */

public class StrobogrammaticNumber {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public boolean isStrobogrammatic(String num) {

        //valid after rotate 1,8,0
        //invalid after rotate 2,3,4,5,7
        //changes 6,9

        Map<Character, Character> valid = new HashMap(Map.of('0','0','1','1','6','9','8','8','9','6'));

        //compare first and last number and go inwards
        int start = 0;
        int end = num.length()-1;
        while(start<=end){
            //if number is invalid, return false right away
            if(!valid.containsKey(num.charAt(start)) || !valid.containsKey(num.charAt(end)))
                return false;
            //if numers are not valid transpose, return false. e.g. start=6, end=6
            if(num.charAt(start)!=valid.get(num.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;

    }

}
