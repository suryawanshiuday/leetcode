package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 252
 * Problem statement:
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
 */

public class MeetingRooms {

    //Time complexity: O(NlogN)
    //Space complexity: O(1)

    public boolean canAttendMeetings(int[][] intervals) {

        //sort the intervals
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));

        //check if any overlap
        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1][1] > intervals[i][0])
                return false;
        }
        return true;
    }

}
