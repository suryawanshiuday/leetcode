package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 704
 * Problem statement:
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

public class BinarySearch {

    //Time complexity: O(logN)
    //Space complexity: O(1)

    public int search(int[] nums, int target) {
        //initialize pointers
        int start = 0;
        int end = nums.length-1;

        //iterate until we reach same indexes
        while(start<=end){
            //get middle index
            int middle = (start+end)/2;

            //if number at middle index matches target, we found answer
            if(nums[middle]==target)
                return middle;
                //if number is less, go high
            else if(nums[middle]<target)
                start = middle+1;
                //if number is greater, go low
            else
                end = middle-1;
        }
        return -1;
    }

}
