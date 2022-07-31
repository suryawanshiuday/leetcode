package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 56
 * Problem statement:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

public class MergeIntervals {

    //Time complexity: O(NlogN) due to sorting
    //Space complexity: O(logN) as sorting takes this space

    public int[][] merge(int[][] intervals) {

        //sort by ascending starttime, descending endtime
        Arrays.sort(intervals, (a, b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        //assign first interval as last memory
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];

        //answer array of max size as of intervals in worst case
        int[][] answer = new int[intervals.length][2];
        //counter to add values in answer
        int counter = 0;

        for(int i=0; i<intervals.length; i++){
            int[] each = intervals[i];
            //e.g. [1,4],[2,3] or [1,4],[2,6]
            //basically start of next interval should be between start-end of previous interval
            //only update lastEnd as lastStart doesn't change
            if(each[0]<=lastEnd && each[0]>=lastStart)
                lastEnd = Math.max(lastEnd, each[1]);
                //else we can't merge intervals and update lastStart/lastEnd to new non overlapping internval found
            else{
                answer[counter][0] = lastStart;
                answer[counter][1] = lastEnd;
                lastStart = each[0];
                lastEnd = each[1];
                counter++;
            }
            //last iteration, if it is new interval, needs to be added explicitely
            //because we can't compare this with next interval
            if(i==intervals.length-1){
                answer[counter][0] = lastStart;
                answer[counter][1] = lastEnd;
                counter++;
            }
        }

        //remove empty elements from answer array
        return Arrays.copyOfRange(answer,0,counter);
    }

}
