package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 503
 * Problem statement:
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */

public class NextGreaterElementII {

    //Time complexity: O(n) as we iterate on nums twice max
    //Space complexity: O(n) size of hashmap

    //incremental solution from next greate element I

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack();
        //map of index and next greater for that index
        HashMap<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                map.put(stack.pop(), nums[i]);
            }
            stack.push(i);
        }

        //for remaining elements in stack, we need to do circular check
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                map.put(stack.pop(), nums[i]);
            }
        }

        //build answer from map
        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            answer[i] = map.getOrDefault(i,-1);
        }

        return answer;

    }

}
