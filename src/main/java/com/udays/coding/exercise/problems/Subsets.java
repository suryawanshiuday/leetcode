package com.udays.coding.exercise.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 78
 * Problem statement:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */

public class Subsets {

    //Time complexity: O(Nx2^N) as there are N numbers and 2 possibilities for each number where we select it or not hence 2^N
    //Space complexity: O(2^N) for backtracking recursion stack

    List<List<Integer>> result;
    int[] nums;
    int n, k;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        this.nums = nums;
        //subsets will be of 0,1,2..k size
        //so incrementally build answer from size 0 upto k
        //every loop will start from 0 index and new arraylist
        for(k=0; k<nums.length+1; k++){
            backtrack(0, new ArrayList<Integer>());
        }
        return result;
    }

    public void backtrack(int start, List<Integer> current){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        //how does this avoid duplicates?
        //i=start
        //this makes it iterate elements incrementally so once we add answer as [1,2] for input [1,2,3]
        //we will never evaluate 2,1
        for(int i=start; i<nums.length; i++){
            current.add(nums[i]);
            backtrack(i+1, current);
            current.remove(current.size()-1);
        }
    }

}
