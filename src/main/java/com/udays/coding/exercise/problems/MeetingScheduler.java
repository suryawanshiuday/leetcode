package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 1229
 * Problem statement:
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
 *
 * If there is no common time slot that satisfies the requirements, return an empty array.
 *
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 *
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 *
 *
 *
 * Example 1:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= slots1.length, slots2.length <= 104
 * slots1[i].length, slots2[i].length == 2
 * slots1[i][0] < slots1[i][1]
 * slots2[i][0] < slots2[i][1]
 * 0 <= slots1[i][j], slots2[i][j] <= 109
 * 1 <= duration <= 106
 */

public class MeetingScheduler {

    //Time complexity: O(MlogM + NlogN) due to sorting
    //Space complexity: O(1) auxiliary space

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        List<Integer> answer = new ArrayList();
        //sort incrementally
        Arrays.sort(slots1,(a, b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);

        //iterate over smaller slots
        //slot1 as small
        //slot2 as long
        if(slots1.length>slots2.length)
            return minAvailableDuration(slots2, slots1, duration);

        for(int[] slot: slots1){
            int starts1 = slot[0];
            int ends1 = slot[1];
            for(int i=0; i<slots2.length; i++){
                int starts2 = slots2[i][0];
                int ends2 = slots2[i][1];
                //if slots2 are beyond s1 slots, no need to check them
                //so we can break and move on to next slot in s1
                if(ends1<starts2)
                    break;
                //if slot1 and slot2 do not intersect, skip
                if(starts1>ends2){
                    continue;
                }
                int commonEnd = Math.min(ends1,ends2);
                int commonStart = Math.max(starts1, starts2);
                if(commonEnd-commonStart>=duration){
                    answer.add(commonStart);
                    answer.add(commonStart+duration);
                    return answer;
                }
            }
        }
        return answer;
    }

}
