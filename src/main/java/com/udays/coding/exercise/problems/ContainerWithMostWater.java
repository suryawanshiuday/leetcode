package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 11
 * Problem statement:
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */

public class ContainerWithMostWater {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public int maxArea(int[] height) {

        //one pointer for start
        int start=0;

        //one pointer for end
        int end=height.length-1;

        //answer
        int maxArea = 0;

        while(start<end){
            //calculate area between points
            int area = (end-start)*Math.min(height[start], height[end]);

            //if new area is greater than previous max, update maxArea
            if(area>maxArea){
                maxArea=area;
            }

            //increment/decrement counter for smaller number
            //if height[start]<height[end], start++
            //if height[start]=height[end], start++
            //if height[end]<height[start], end--
            if(height[start]<=height[end]){
                start++;
            } else{
                end--;
            }
        }
        return maxArea;
    }

}
