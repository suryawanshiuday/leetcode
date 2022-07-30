package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 14
 * Problem statement:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        //if empty input, return
        if(strs.length==0){
            return "";
        }

        //initialize prefix to be first string
        //reduce based on further matches
        String prefix = strs[0];

        //match next strings from strs with prefix
        for(int i=1; i<strs.length; i++){
            //if string starts with prefix, indexOf will be 0, so no action needed
            //if doesn't match, then reduce prefix by 1 char from end
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
                //if prefix becomes empty while reducing, return
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

}
