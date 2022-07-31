package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 33
 * Problem statement:
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -104 <= target <= 104
 */

public class SearchInRotatedSortedArray {

    //Time complexity: O(logN) due to binary search
    //Space complexity: O(1)

    public int search(int[] nums, int target) {

        //initialize pointers
        int start = 0;
        int end = nums.length-1;

        //iterate until we reach same indexes
        while(start<=end){
            //get middle index
            int middle = (start+end)/2;
            int s = nums[start];
            int m = nums[middle];
            int e = nums[end];

            //if number at middle index matches target, we found answer
            if(m==target)
                return middle;
                //if m>=s, that means pivot is not on left and left side is ordered
            else if(m>=s){
                //if target is between mid and start, go left, else go right
                if(target<m && target>=s)
                    end = middle-1;
                else
                    start = middle+1;
            }
            //if m<s, means pivot is on left, and right side is ordered
            else{
                //if target is between mid and end, go right, else go left
                if(target<=e && target>m)
                    start = middle+1;
                else
                    end = middle-1;
            }
        }
        return -1;

    }

}
