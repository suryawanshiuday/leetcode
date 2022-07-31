package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 283
 * Problem statement:
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */

public class MoveZeroes {

    //Time complexity: O()
    //Space complexity: O()

    public void moveZeroes(int[] nums) {

        //if single element, no changes
        if(nums.length==1)
            return;

        //x will point to index where we need to write the non zero element
        //y will keep incrementing till we find non zero element to write at x
        int x=0;

        for(int y=0; y<nums.length; y++){
            //if x is zero, find next non zero number
            if(nums[x]==0){
                while(y<nums.length && nums[y]==0){
                    y++;
                }
                //once we find non zero number, copy that to x location
                //set non zero number to zero at y
                if(y<=nums.length-1){
                    nums[x]=nums[y];
                    nums[y]=0;
                }
            }
            x++;
        }
    }

}
