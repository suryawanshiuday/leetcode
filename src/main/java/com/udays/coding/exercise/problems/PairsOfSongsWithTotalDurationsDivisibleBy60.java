package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 1010
 * Problem statement:
 * ou are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 *
 * Constraints:
 *
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 */

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    //Time complexity: O(N) as we iterate through all times
    //Space complexity: O(1) as remainders array is constant size

    public int numPairsDivisibleBy60(int[] time) {
        //remainder array to store remainders for each time
        int remainders[] = new int[60];

        //answer
        int count = 0;

        for (int t: time) {
            //number exactly divisible by 60, we can increment the answer directly
            if (t % 60 == 0) {
                count += remainders[0];
            }
            //number not exactly divisible by 60, we need to find if its complement (60-t) is present
            //if present,count=count+remainder[60-t] e.g. 20,20,20,40, we can make 3 pairs
            else {
                count += remainders[60 - t % 60];
            }
            // remember to update the remainders
            remainders[t % 60]++;
        }
        return count;
    }

}
