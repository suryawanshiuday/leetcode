package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 198
 * Problem statement:
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */

public class HouseRobber {

    //Time complexity: O(N) since we visit all nums only once and use DP array to avoid recalculation
    //Space complexity: O(N) for DP array

    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];

        int[] money = new int[nums.length];
        //money at first house, if you decide to rob will be money in that house
        money[0] = nums[0];
        //make a choise between house 1 and 2, choose the max to make max money
        money[1] = Math.max(nums[0], nums[1]);

        //iterate from next house until last house
        for( int i=2; i<nums.length; i++){
            //by choosing max, you either
            //choose to skip the house, so money will be same as the house before
            //or choose to rob, so money will be current house+the house before
            money[i] = Math.max(money[i-1],money[i-2]+nums[i]);
        }
        return money[nums.length-1];
    }

}
