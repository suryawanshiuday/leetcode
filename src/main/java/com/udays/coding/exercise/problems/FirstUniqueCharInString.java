package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 387
 * Problem statement:
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */

public class FirstUniqueCharInString {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public int firstUniqChar(String s) {

        //store index of all chars
        //initial value=length of s, which can never be answer
        //if we find dups, make that char as not an answer by setting to max
        //get lowest index as answer
        int[] indexes = new int[26];
        Arrays.fill(indexes, s.length());

        for(int i=0; i<s.length(); i++){
            int chari = s.charAt(i)-'a';
            //if first occurrence, save index for char
            if(indexes[chari]==s.length())
                indexes[chari]=i;
                //if duplicate occurrence, set char as not an answer candidate
            else if(indexes[chari]<s.length())
                indexes[chari]=Integer.MAX_VALUE;
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            answer = Math.min(answer, indexes[i]);
        }

        return (answer==s.length() || answer==Integer.MAX_VALUE)?-1:answer;


    }

}
