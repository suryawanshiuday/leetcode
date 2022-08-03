package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 15
 * Problem statement:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

public class ThreeSum {

    //Time complexity: O(N^2), O(NlogN) for sorting, O(N) for 2sum and we run it for N numbers so O(N^2)
    //O(NlogN+N2) asymtotically equals O(N^2)
    //Space complexity: O(logN) for sorting

    public List<List<Integer>> threeSum(int[] nums) {

        //sort the array first so we can keep iterate on nums with pivot number
        //and applying 2 sum for remaining numbers which complement pivot to be 0
        Arrays.sort(nums);

        //result
        List<List<Integer>> result = new ArrayList<>();

        //pivot iteration
        //only iterate until negative numbers, not needed for all positive numbers, it will never be 0
        for(int i=0; i<nums.length && nums[i]<=0; i++){
            //if pivot number is same as previous, no need to calculate 2 sum
            if(i==0 || nums[i-1]!=nums[i]){
                twoSum(result, i, nums);
            }
        }

        return result;

    }

    public void twoSum(List<List<Integer>> result, int pivot, int[] nums){
        //low is one greater than pivot
        int low = pivot+1;
        //high is last number
        int high = nums.length-1;
        while(low<high){
            int total = nums[pivot] + nums[low] + nums[high];
            if(total<0){
                ++low;
            } else if(total>0){
                --high;
            } else{
                //low++ and high-- will increment/decrement after adding one result
                //it is possible to have more 2 sum numbers with same pivot in same iteration
                result.add(Arrays.asList(nums[pivot], nums[low++], nums[high--]));
                //keep incrementing low until we skip all dups equal to low from above result and until it reaches high
                while(low<high && nums[low]==nums[low-1]){
                    ++low;
                }
            }
        }
    }


}
