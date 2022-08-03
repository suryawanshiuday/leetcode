package com.udays.coding.exercise.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 39
 * Problem statement:
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */

public class CombinationSum {

    //Time complexity: O(N*N^T/M) for N candidates, we backtrack the function T/M times where T=target, M=value of candidate
    //Space complexity: O(N^T/M) recursion stack for every backtracking iteration

    int[] candidates;
    List<List<Integer>> results;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.results = new ArrayList<>();
        this.target = target;
        backtrack(new ArrayList<Integer>(), 0, 0);
        return results;
    }

    public void backtrack(List<Integer> current, int start, int sum){

        //if sum exceeds target, backtrack and check next candidate
        if(sum>target){
            return;
        }

        //found answer
        if(sum==target){
            results.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            //try adding same candidate every time till sum exceeds target
            current.add(candidates[i]);
            backtrack(current, i, sum+candidates[i]);
            //remove last element as sum exceeded so try next element
            current.remove(current.size()-1);
        }
    }

}
