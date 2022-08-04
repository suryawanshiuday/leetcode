package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 91
 * Problem statement:
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */

public class DecodeWays {

    //DP iteration with tabulization

    //Time complexity: O(N) as we iterate N+1 times on dp array
    //Space complexity: O(N) size of dp array

    public int numDecodings(String s) {

        //dp array with +1 length
        int[] dp = new int[s.length()+1];
        //intial value
        dp[0] = 1;
        //evaluate char at 0, if it is not zero and number of ways to decode this is 1 which is dp[0]
        dp[1] = s.charAt(0)=='0'? 0 : dp[0];

        for(int i=2; i<dp.length; i++){
            //evaluate if char at index i-1 can be decoded as single digit and store at i
            //if it is not zero, it can be decoded
            //so to reach this digit at i, we have dp[i-1] ways
            if(s.charAt(i-1)!='0'){
                dp[i] = dp[i] + dp[i-1];
            }
            //evaluate char can be decoded as double digits with char at i-2
            //if it can, then total number of ways to reach i-1 is dp[i-1]+dp[i-2]
            //we already added dp[i-1] when we checked single difit way above
            //we can add dp[i-2] only if 2 digit decode is possible
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(10<=twoDigit && twoDigit<=26){
                dp[i] = dp[i]+dp[i-2];
            }
        }
        return dp[dp.length-1];
    }


}
