package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 680
 * Problem statement:
 */

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            //if start and end is equal check start++ end--
            //so no action on equal
            //if not equal, try removing start once and then end once and see if we can make it palindrome
            if(s.charAt(start) != s.charAt(end)){
                return isPalindrome(s, start, end-1)
                        || isPalindrome(s, start+1, end);
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}
