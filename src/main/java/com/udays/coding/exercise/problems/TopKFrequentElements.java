package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode problem: 347
 * Problem statement:
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

public class TopKFrequentElements {

    //Time complexity: O(NlogK) due to heap always containing K elements and we iterate all nums
    //Space complexity: O(N)

    public int[] topKFrequent(int[] nums, int k) {

        //solution 2 using heap
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums)
            freq.put(num, freq.getOrDefault(num,0)+1);

        //using a heap with lowest freq items in front
        Queue<Integer> heap = new PriorityQueue<>((n1, n2)->freq.get(n1)-freq.get(n2));

        for(int each: freq.keySet()){
            heap.add(each);
            if(heap.size()>k)
                heap.poll();
        }

        int[] answer = new int[k];
        for(int i=0; i<k; i++){
            answer[i] = heap.poll();
        }

        return answer;

        /*
        //solution 1

        //hashmap to store frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums)
            freq.put(num, freq.getOrDefault(num,0)+1);

        //sort the hashmap by values
        List<Map.Entry<Integer,Integer>> sortedEntries = new ArrayList<>(freq.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> n1, Map.Entry<Integer, Integer> n2){
                return n2.getValue().compareTo(n1.getValue());
            }
        });

        //iterate on sortedEntries to select top k elements
        int[] answer = new int[k];
        for(int i=0; i<k; i++){
            answer[i] = sortedEntries.get(i).getKey();
        }

        return answer;
        */
    }

}
