package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 20
 * Problem statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

public class ValidParentheses {

    public boolean isValid(String s) {

        //for valid parentheses, it has to be >=2
        if(s.length()<2){
            return false;
        }

        //keep pushing open parenthese to stack and popping when we found corrosponding close parentheses
        Stack<Integer> stack = new Stack();

        for(int i=0; i<s.length(); i++){

            int c=s.charAt(i);

            //if first char itself is close parentheses, return false
            if((c==41 || c==93 || c==125) && stack.isEmpty()){
                return false;
            }
            //if open parentheses, push to stack
            if(c==40 || c==91 || c==123){
                stack.push(c);
            } else{
                //else pop from stack and match with current close parentheses
                //if matches, then pop as that parentheses is complete
                int peek = stack.peek();
                if((c==41 && peek==40)
                        || (c==93 && peek==91)
                        || (c==125 && peek==123)){
                    stack.pop();
                }else{
                    //else return as open parenthese doesn't match to open one from stack top
                    return false;
                }
            }
        }

        //e.g. ({[]})(
        if(stack.size()>0){
            return false;
        }
        return true;
    }

}
