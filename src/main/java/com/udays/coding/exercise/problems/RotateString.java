package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 796
 * Problem statement:
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 *
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * Example 2:
 *
 * Input: s = "abcde", goal = "abced"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, goal.length <= 100
 * s and goal consist of lowercase English letters.
 */

public class RotateString {

    //Time complexity: O(N2)
    //Space complexity: O(N)

    public boolean rotateString(String s, String goal) {
        return (s.length()==goal.length()) && (goal+goal).contains(s);
    }

}
