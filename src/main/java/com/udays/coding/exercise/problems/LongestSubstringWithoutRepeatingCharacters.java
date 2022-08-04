package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 3
 * Problem statement:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    //Time complexity: O(N) as we visit each char by left and right pointers once so O(2N)=O(N)
    //Space complexity: O(1) as char array always remains same size

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int max = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            chars[c]++;
            //keep moving left until we move left pointer to the place where freq of c becomes 1
            while(chars[c]>1){
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }

}
