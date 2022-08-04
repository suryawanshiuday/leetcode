package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 300
 * Problem statement:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

public class LongestIncreasingSubsequence {

    //Dynamic programming
    //Time Complexity: O(N^2) due to 2 nested loops
    //Space Complexity: O(N) for dp[]

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        //fill the array with 1 as every element can be part of increasing subseq in itself
        //this also becomes the base case
        Arrays.fill(dp,1);

        int longest = -1;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    longest = Math.max(dp[i], longest);
                }
            }
        }

        //if longest=-1, it means it never identified an increasing subseq with more than 1 num, so return 1
        return longest ==-1 ? 1: longest;
    }

}
