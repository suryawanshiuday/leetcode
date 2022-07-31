package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 1636
 * Problem statement:
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 *
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */

public class SortArrayByIncreasingFrequency {

    //Time complexity: O(NlogN) due to sorting
    //Space complexity: O(N)

    public int[] frequencySort(int[] nums) {

        //frequency array
        Map<Integer, Integer> freq = new HashMap();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        //sort the hashmap by values ascending, if values match then keys descending
        List<Map.Entry<Integer,Integer>> sortedEntries = new ArrayList<>(freq.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> n1, Map.Entry<Integer, Integer> n2){
                if(n1.getValue()==n2.getValue()){
                    return n2.getKey().compareTo(n1.getKey());
                }
                return n1.getValue().compareTo(n2.getValue());
            }
        });
        int index = 0;
        //read hashmap to build output
        for(Map.Entry<Integer, Integer> each: sortedEntries){
            for(int i=0; i<each.getValue(); i++)
                nums[index++]=each.getKey();
        }
        return nums;
    }

}
