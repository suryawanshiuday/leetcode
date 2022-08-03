package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 238
 * Problem statement:
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {

    //Time complexity: O(N) iterate over all nums 3 times so O(3N)=O(N)
    //Space complexity: O(N) size of left/right arrays O(2N)=O(N)

    //for O(1) space, we can treat left array as output and build other array and answer on the fly

    public int[] productExceptSelf(int[] nums) {

        //left and right product lists

        //example
        //input 4,5,1,8,2
        //left  1,4,20,20,160
        //right 80,16,16,2,1

        //left array, left[i+1] = left[i]*nums[i]
        int[] left = new int[nums.length];
        //left of nums[0] is treated as 1
        left[0] = 1;
        for(int i=1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        //right array, right[length-2] = right[length-1]*nums[length-1]
        int[] right = new int[nums.length];
        //right of nums[length-1] is treated as 1
        right[right.length-1] = 1;
        for(int i=nums.length-2; i>=0 ; i--){
            right[i] = right[i+1] * nums[i+1];
            System.out.println("right: "+right[i]);
        }

        //answer = left[i]*right[i]
        int[] answer = new int[right.length];
        for(int i=0; i<right.length; i++){
            answer[i] = right[i] * left[i];
        }

        return answer;
    }

}
