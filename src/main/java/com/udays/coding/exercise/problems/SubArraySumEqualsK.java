package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 560
 * Problem statement:
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */

public class SubArraySumEqualsK {

    //Time complexity: O(N)
    //Space complexity: O(N)

    /*
    Example
    input     [-2, 1, 2, -2, 5, -2, 1]
    prefixSum [-2, -1, 1, -1, 4, 2, 3]
    sum(nums[2,6]) = prefixSum[6] - prefixSum[1]
    4 = 3 - (-1)
    sum(nums[i,j]) = prefixSum[j] - prefixSum[i-1]
                k  = prefixSum[j] - prefix[i-1]
    prefixSum[i-1] = prefixSum[j] - k
    */

    public int subarraySum(int[] nums, int k) {

        //map of count of occurrences of prefixSum <prefixSum, count>
        Map<Integer, Integer> hits = new HashMap<>();
        hits.put(0,1);

        //answer to be returned
        int answer = 0;

        //running sum of the nums
        int prefixSum = 0;

        for(int i=0; i<nums.length; i++){
            //run cumulative sum
            prefixSum+=nums[i];

            //if hits already contains, prefixSum-k means there is a subarray with required sum=k
            if(hits.containsKey(prefixSum-k)){
                answer+=hits.get(prefixSum-k);
            }

            //if its new prefixSum, create new entry
            hits.put(prefixSum, hits.getOrDefault(prefixSum,0)+1);

        }

        return answer;

    }

}
