package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 621
 * Problem statement:
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 *
 *
 * Constraints:
 *
 * 1 <= task.length <= 104
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100].
 */

public class TaskScheduler {

    //Algorithm
    //start by getting frequency of most frequent task
    //there need to be (fmax-1)*n idle times between instaces of this most frequent task
    //now fill the gaps with other tasks
    //remaining idle slots+tasks = answer

    //schematic: blob:https://leetcode.com/fd5224a5-ec8a-433c-8630-10ff47baeac9

    //Time complexity: O(N) as we iterate all tasks to build frequencies
    //Space complexity: O(1) as frequncies array is always 26 long

    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
        }

        Arrays.sort(frequencies);

        // max frequency
        int f_max = frequencies[25];
        //f_max-1 because n elements will need n-1 colling periods in between
        int idle_time = (f_max - 1) * n;

        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; --i) {
            int currentFreq = frequencies[i];
            //why fmax-1?
            //we are trying to fill idle slots between most frequent task
            //if there are 2 tasks with same max freq, let's say A-3, B-3, we can only fit 2 Bs between 3 As,
            //last B will come after A and will be accounted for on last line where we do idle+tasks.length
            idle_time -= Math.min(f_max - 1, currentFreq);
        }
        idle_time = Math.max(0, idle_time);

        return idle_time + tasks.length;
    }

}
