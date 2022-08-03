package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 46
 * Problem statement:
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

public class Permutations {

    //Time complexity: O()
    //Space complexity: O()

    //backtrack solution
    //explanation: blob:https://leetcode.com/20a59d32-8271-49d1-8af0-2f3ccf3a2a72

    List<List<Integer>> results;
    int[] nums;
    int expectedSize;

    public List<List<Integer>> permute(int[] nums) {

        results = new ArrayList();
        this.nums = nums;
        this.expectedSize = nums.length;

        List<Integer> current = new ArrayList();
        for(int n:nums)
            current.add(n);

        backtrack(current, 0);

        return results;
    }

    public void backtrack(List<Integer> current, int start){

        List<List<Integer>> rl = results;

        if(start==expectedSize){
            results.add(new ArrayList(current));
            return;
        }

        for(int i=start; i<expectedSize; i++){
            Collections.swap(current, start, i);
            backtrack(current, start+1);
            Collections.swap(current, start, i);
        }
    }

}
