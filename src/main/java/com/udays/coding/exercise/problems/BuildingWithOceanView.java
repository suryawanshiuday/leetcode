package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode problem: 1762
 * Problem statement:
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 *
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 *
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [4,2,3,1]
 * Output: [0,2,3]
 * Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
 * Example 2:
 *
 * Input: heights = [4,3,2,1]
 * Output: [0,1,2,3]
 * Explanation: All the buildings have an ocean view.
 * Example 3:
 *
 * Input: heights = [1,3,2,4]
 * Output: [3]
 * Explanation: Only building 3 has an ocean view.
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 109
 */

public class BuildingWithOceanView {

    //Time complexity: O(N) iterating over all heights, O(logN) for queue so effectively O(N)
    //Space complexity: O(N) size of queue

    public int[] findBuildings(int[] heights) {

        //hold the indexes of buildings with view
        PriorityQueue<Integer> pq = new PriorityQueue();
        //last element in array will have ocean view, so add last index first
        pq.offer(heights.length-1);
        //tallest will be last building when we start from end
        int tallest = heights[heights.length-1];

        for(int i=heights.length-2; i>=0; i--){
            //if height of i-1>i, it has ocean view, add to queue and update tallest
            if(heights[i]>tallest){
                pq.offer(i);
                tallest = Math.max(heights[i], tallest);
            }
        }

        //build answer from queue
        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty())
            answer[index++]=pq.poll();

        return answer;
    }

}
