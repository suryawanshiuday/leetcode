package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode problem: 253
 * Problem statement:
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */

public class MeetingRoomsII {

    //Time complexity: O(nLogN) due to sorting
    //Space complexity: O(N), there can be all intervals in heap at a time in worst case

    public int minMeetingRooms(int[][] intervals) {
        //if no intervals, 0 rooms
        if(intervals.length==0)
            return 0;

        //keeping track of meeting end times
        PriorityQueue<Integer> allocator = new PriorityQueue<>();

        //sort array based on start time
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));

        //add end time of first meeting to allocator
        //means ongoing 1 meeting which will end at this time
        allocator.add(intervals[0][1]);


        for(int i=1; i<intervals.length; i++){
            //if new meeting is going to start at/after current latest ending meeting
            //we can use same meeting room
            if(intervals[i][0]>=allocator.peek()){
                allocator.poll();
            }
            //else we just allocate a new meeting room and mark the ending time of the meeting in queue
            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }

}
