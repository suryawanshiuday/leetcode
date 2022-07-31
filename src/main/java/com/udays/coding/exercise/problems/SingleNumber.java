package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 136
 * Problem statement:
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */

public class SingleNumber {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public int singleNumber(int[] nums) {

        //xor of same numbers is 0
        //4,4,2,2,3 = 3
        //4^4->0 2^2->0 0^0^3->3
        int a = 0;
        for (int i : nums) {
            a =a ^ i;
        }
        return a;
    }

}
