package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 125
 * Problem statement:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        //2 pointers
        int start = 0;
        int end = s.length()-1;

        while(start<=end){
            //char at start
            char cs = s.charAt(start);
            //char at end
            char ce = s.charAt(end);

            //if char is not alphanumeric, skip
            if(!Character.isLetterOrDigit(cs)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(ce)){
                end--;
                continue;
            }

            //if start char and end char do not match, return false; else continue checking
            if(Character.toLowerCase(cs)!=Character.toLowerCase(ce))
                return false;
            if(Character.toLowerCase(cs)==Character.toLowerCase(ce)){
                start++;
                end--;
            }
        }
        return true;
    }

}
