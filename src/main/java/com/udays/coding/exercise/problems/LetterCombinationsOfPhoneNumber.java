package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 17
 * Problem statement:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */

public class LetterCombinationsOfPhoneNumber {

    //Time complexity: O(4^N*N) where N=length of digits, worst case it will be cartesian product of 7*9 (N times) which has 4 chars each
    //Space complexity: O(4^N) worst case we will have cartesian product of 4*4 chars on queue

    public List<String> letterCombinations(String digits) {

        //push all chars of first digit first
        //then read all chars of second digit and join with every char from queue
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty())
            return ans;

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //push empty string first to join with chars from first digit
        ans.add("");

        for(int i =0; i<digits.length();i++){
            //get single digit from input
            int x = Character.getNumericValue(digits.charAt(i));
            //only iterate chars from current queue length
            //e.g. 23 -> first iteration of queue will have a,b,c
            //on second iteration queue will have new answers at the end which we dont want to join
            //e.g. a,b,c -> b,c,ad,ae,af (we only want to read b,c next and end loop)
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}
