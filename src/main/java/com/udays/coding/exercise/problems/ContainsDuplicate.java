package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode problem: 217
 * Problem statement:
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> values = new HashSet();
        for(int num: nums){
            if(values.contains(num))
                return true;
            values.add(num);
        }
        return false;

        /*
        Option 1
        //without sort, complexity becomse O(n2) due to 2 pointers
        //with sort, it becomes O(NlogN)
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]==nums[i])
                return true;
        }
        return false;
        */
    }

}
