package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 1344
 * Problem statement:
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
 *
 * Answers within 10-5 of the actual value will be accepted as correct.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: hour = 12, minutes = 30
 * Output: 165
 * Example 2:
 *
 *
 * Input: hour = 3, minutes = 30
 * Output: 75
 * Example 3:
 *
 *
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 *
 *
 * Constraints:
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 */

public class AngleBetweenHands {

    //Time complexity: O(1)
    //Space complexity: O(1)

    public double angleClock(int hour, int minutes) {
        //total angle 360
        //minute angle = 360/60=6 degree
        //hour angle = 360/12=30 degree
        //on 12th hour, angle is zero so hour angle = (hour%12)*30

        //when min moves 30min, hour moves by 50% between 2 hour marks (i.e. 30/60=minute/60)
        //so hour movement= (hour%12 + minute/60)*30
        double minAngle = minutes*6;
        double hourAngle = (hour%12 + minutes/60.0)*30;
        double diff = Math.abs(hourAngle-minAngle);
        return Math.min(diff, 360-diff);
    }

}
