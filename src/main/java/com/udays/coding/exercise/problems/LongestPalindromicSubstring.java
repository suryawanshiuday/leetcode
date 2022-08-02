package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 5
 * Problem statement:
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {

    //Time complexity: O(N^2) because we evaluate each character n times
    //Space complexity: O(1)

    //expand outward approach

    public String longestPalindrome(String s) {

        int max = -1;
        String longest = "";

        //there can be 2 possibilities for each character at i
        //case1: i will be center for odd length palindrome
        //case2: i and i+1 will be center of even length palindrom

        for(int i=0; i<s.length(); i++){

            //check for odd length palindrome, set r=l=i;
            int l=i , r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                //is it longer than previous max?
                if(r-l+1>max){
                    max = r-l+1;
                    longest = s.substring(l,r+1);
                }
                //expand outward
                l-=1;
                r+=1;
            }

            //check for even length palindrome, set l=i, r=i+1;
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                //is it longer than previous max?
                if(r-l+1>max){
                    max = r-l+1;
                    longest = s.substring(l,r+1);
                }
                //expand outward
                l-=1;
                r+=1;
            }
        }

        return longest;

    }

}
