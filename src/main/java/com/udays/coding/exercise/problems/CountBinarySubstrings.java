package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 696
 * Problem statement:
 * Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 *
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either '0' or '1'.
 */

public class CountBinarySubstrings {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public int countBinarySubstrings(String s) {

        /*
        Algorithm

        Let's create groups as defined above.
        The first element of s belongs in it's own group.
        From then on, each element either doesn't match the previous element, so that it starts a new group of size 1;
            or it does match, so that the size of the most recent group increases by 1.
        Afterwards, we will take the sum of min(groups[i-1], groups[i]).
        */

        //make the groups of consecutive digits
        //0011000111 = 2,2,3,3
        int[] groups = new int[s.length()];
        //initialize first with 1 for starter
        groups[0]=1;

        //variable to store index of groups
        int counter=0;

        //iterate over string to populate groups
        for(int i=1; i<s.length(); i++){
            //if i-1 and i char matches, increment counter at same index
            //else increment index of group
            if(s.charAt(i-1)==s.charAt(i)){
                groups[counter]++;
            } else{
                groups[++counter]=1;
            }
        }

        //answer = min of (i and i+1)
        //If we have groups[i] = 2, groups[i+1] = 3, then it represents either "00111" or "11000".
        //We clearly can make min(groups[i], groups[i+1]) valid binary strings within this string.
        int answer = 0;
        for(int i=1; i<=counter; i++){
            answer += Math.min(groups[i-1],groups[i]);
        }

        return answer;
    }

}
