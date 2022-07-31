package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 697
 * Problem statement:
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */

public class DegreeOfAnArray {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public int findShortestSubArray(int[] nums) {
        //store degree for input
        int degree = 0;
        //int[3] value = {firstOcc of num, lastOcc of num, freq of num}
        Map<Integer, int[]> data = new HashMap();
        for(int i=0; i<nums.length; i++){
            //default value, for new number, {i,i,0}
            int[] val = (data.containsKey(nums[i]))? data.get(nums[i]) : new int[]{i,i,0};
            //set last occurrence as i e.g. 1,2,2,1, last occurrence of 1 needs to be updated
            val[1] = i;
            //increase freq
            val[2] = val[2]+1;
            //get max degree until now
            degree = Math.max(degree, val[2]);
            data.put(nums[i], val);
        }
        //iterate on data map
        //for each num with freq=degree, return smallest length of subarray
        int answer = Integer.MAX_VALUE;
        for(int[] each: data.values()){
            if(each[2]==degree)
                answer = Math.min(answer, each[1]-each[0]+1);
        }
        return answer;
    }

}
