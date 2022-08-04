package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode problem: 128
 * Problem statement:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

public class LongestConsecutiveSequence {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet();
        for(int n: nums)
            numbers.add(n);

        int longest = 0;

        for(int n: numbers){
            //only build longest sequence from lowest number in that seq
            if(!numbers.contains(n-1)){
                //so we store incremental n in while loop
                int num = n;
                int current = 1;
                while(numbers.contains(num+1)){
                    current+=1;
                    num = num+1;
                }
                longest = Math.max(longest, current);
            }
        }

        return longest;
    }

}
