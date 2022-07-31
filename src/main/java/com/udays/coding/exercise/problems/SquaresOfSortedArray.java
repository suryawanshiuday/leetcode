package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 977
 * Problem statement:
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */

public class SquaresOfSortedArray {

    //Time complexity: O(N)
    //Space complexity: O(N)

    /*
    Algorithm:
    1. calculate square and note down index of start of positive numbers
    2. merge 2 arrays, left as startOfPositive->0 and right as startOfPositive->end
     */
    public int[] sortedSquares(int[] nums) {
        //note the start of first positive number in input
        int startOfPositive = 0;
        //calculate squares, update in input array
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0)
                startOfPositive++;
            nums[i]=nums[i]*nums[i];
        }
        //iterate
        //left array from startOfPositive to 0
        //right array from startOfPositive to end
        //merge
        int start=startOfPositive-1, end=startOfPositive, index = 0;
        int[] result = new int[nums.length];
        while(start>=0 || end<nums.length){
            int left = start<0 || start>nums.length-1 ? Integer.MAX_VALUE : nums[start];
            int right = end<0 || end>nums.length-1 ? Integer.MAX_VALUE : nums[end];
            if(left<=right){
                result[index++]=left;
                start--;
            }
            if(left>right){
                result[index++]=right;
                end++;
            }
        }
        return result;
    }

}
