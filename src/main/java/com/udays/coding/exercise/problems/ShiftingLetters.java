package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 848
 * Problem statement:
 * You are given a string s of lowercase English letters and an integer array shifts of the same length.
 *
 * Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 *
 * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 * Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
 *
 * Return the final string after all such shifts to s are applied.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shifts = [3,5,9]
 * Output: "rpl"
 * Explanation: We start with "abc".
 * After shifting the first 1 letters of s by 3, we have "dbc".
 * After shifting the first 2 letters of s by 5, we have "igc".
 * After shifting the first 3 letters of s by 9, we have "rpl", the answer.
 * Example 2:
 *
 * Input: s = "aaa", shifts = [1,2,3]
 * Output: "gfd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * shifts.length == s.length
 * 0 <= shifts[i] <= 109
 */

public class ShiftingLetters {

    //Time complexity: O(n+s) where n=length of s and s=length of shifts
    //Space complexity: O(1) as we are not using any auxiliary space than building answer

    public String shiftingLetters(String s, int[] shifts) {

        //build shifts such that every index will have exactly required shifts
        //[3,5,9] <-> [17,14,9]
        int total = 0;
        for(int i=shifts.length-1; i>=0; i--){
            total+=shifts[i];
            //after 26 shifts, next shift will be same char
            //so we need to circle back and count again from a
            if(total>=26){
                total%=26;
            }
            shifts[i]=total;
        }

        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            //get ascii value of char at index
            int src = (int)s.charAt(i);
            //get target ascii of char at index
            int tgt = src+shifts[i];
            //if ascii value > 122 (z) then roll it up
            if(tgt>122)
                tgt = tgt-122+96;
            //answer at index
            answer.append((char)tgt);
        }

        return answer.toString();
    }

}
