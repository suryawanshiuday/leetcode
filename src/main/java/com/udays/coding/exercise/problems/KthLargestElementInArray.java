package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode problem: 215
 * Problem statement:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * You must solve it in O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */

public class KthLargestElementInArray {

    //Time complexity: O(NlogK), N-number of elements, k-size of heap at anytime
    //Space complexity: O(N) for heap

    //always keep size of heap at this capacity=k so first element is our kth largest
    int capacity;
    //min heap
    PriorityQueue<Integer> heap;

    public int findKthLargest(int[] nums, int k) {
        capacity=k;
        heap = new PriorityQueue();
        for(int num:nums)
            add(num);
        return heap.peek();
    }

    public int add(int val) {
        heap.offer(val);
        //if heap increases beyond capacity k, then remove element to maintain capacity
        if(heap.size() > capacity)
            heap.poll();
        //return first element from heap which is kth largest
        return heap.peek();
    }

}
