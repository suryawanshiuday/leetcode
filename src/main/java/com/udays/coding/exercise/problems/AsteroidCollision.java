package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 735
 * Problem statement:
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 *
 * Constraints:
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */

public class AsteroidCollision {

    //Time complexity: O(N)
    //Space complexity: O(N) worst case, we will have all asteroids in stack

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack();
        int total = 0;
        for(int a: asteroids){
            boolean push = true;
            //if we get negative number and stack has elements
            //compare stack elements until we have a winner or stack becomes empty
            while(!s.isEmpty() && a<0 && s.peek()>0){
                //Case1: same weight, both destroyed
                //pop stack
                //no need to push a to stack
                //break loop as both are destroyed, go to next element
                if(Math.abs(a)==s.peek()){
                    s.pop();
                    push=false;
                    break;
                }
                //Case2: top of stack if smaller
                //destroy from top of stack
                //push a to stack
                //dont break loop until we find an element in stack to be greater or stack is empty
                else if(s.peek()<Math.abs(a)){
                    s.pop();
                    continue;
                }
                //Case3: top of stack is greater, destroy a
                //don't push a to stack
                //break the loop as we have a winner from stack
                else{
                    push=false;
                    break;
                }
            }
            if(push)
                s.push(a);
        }

        int[] ans = new int[s.size()];
        for(int i=s.size()-1; i>=0; i--){
            ans[i]=s.pop();
        }
        return ans;
    }

}
