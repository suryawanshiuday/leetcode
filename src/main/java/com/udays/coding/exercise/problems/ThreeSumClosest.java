package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 16
 * Problem statement:
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */

public class ThreeSumClosest {

    //Time complexity: O(N^2) as inner and outer loop go over n times
    //Space complexity: O(logN) to O(N) depending on sorting algorithm

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(lo<hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if(Math.abs(target-sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                if(sum<target)
                    lo++;
                else
                    hi--;
            }
        }
        return target-diff;
    }


}
