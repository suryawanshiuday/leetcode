package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 344
 * Problem statement:
 * 344. Reverse String
 * Easy
 *
 * 5606
 *
 * 977
 *
 * Add to List
 *
 * Share
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

public class ReverseString {

    //Time complexity: O(N)
    //Space complexity: O(1)

    //use 2 pointers and it will be better than recursion for space complexity
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start<end){
            //swap
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

}
