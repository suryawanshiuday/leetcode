package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 567
 * Problem statement:
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */

public class PermutationInString {

//Time complexity: O(l1+l2)
    //Space complexity: O(1)

    //one string will be a permutation of another string only if both of them contain the same characters with the same frequency.

    public boolean checkInclusion(String s1, String s2) {

        //store freq of chars from s1
        int[] chars1 = new int[26];
        int uniq1 = 0;
        for(char c: s1.toCharArray()){
            if(chars1[c-'a']==0)
                uniq1++;
            chars1[c-'a']++;
        }

        //store freq of chars from s2
        int[] chars2 = new int[26];
        int start = 0;
        int end = 0;
        int uniq2 = 0;

        while(end<s2.length()){
            char c = s2.charAt(end);
            int ci = c-'a';
            chars2[ci]++;
            if(chars1[ci]<chars2[ci]){
                chars2 = new int[26];
                start++;
                end=start-1;
                uniq2=0;
            }
            //if s1 and s2 freq of given char matches, then return true
            if(chars1[ci]==chars2[ci] && chars1[ci]!=0)
                uniq2++;
            if(uniq1==uniq2)
                return true;
            end++;
        }
        return false;
    }

}
