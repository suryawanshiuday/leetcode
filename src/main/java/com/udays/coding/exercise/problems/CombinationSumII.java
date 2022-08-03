package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 40
 * Problem statement:
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */

public class CombinationSumII {

    //only difference from combination sum problem is we can use candidate only once

    //Time complexity: O(2^N) i.e. for all possible combinations from input
    //Space complexity: O(N) worst case, recursion will consider all numbers

    List<List<Integer>> results;
    int[] candidates;
    int target;
    int size;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        this.results = new ArrayList();
        this.candidates = candidates;
        this.target = target;
        this.size = candidates.length;

        backtrack(new ArrayList<Integer>(), 0, 0);
        return results;
    }

    public void backtrack(List<Integer> current, int start, int sum){

        //if sum exceeds target, backtrack and try next candidate
        if(sum>target)
            return;

        //answer
        if(sum==target){
            results.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i=start; i<size; i++){
            //start from next number onwards than last completed so result won't have dup entries
            //started from same number as completed will cause dups
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            //optimization for early stopping
            //if input is 1,1,6,7,9 target 8, no point in checking next numbers after 6 with combination of 1,1
            //as array is sorted, that will be greater for sure
            if(sum+candidates[i]>target)
                break;
            current.add(candidates[i]);
            backtrack(current, i+1, sum+candidates[i]);
            current.remove(current.size()-1);
        }
    }


}
