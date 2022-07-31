package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 150
 * Problem statement:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 *
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */

public class EvaluateReversePolishNotation {

    //Time complexity: O(N) as we iterate all numbers
    //Space complexity: O(N) worst case, stack will have all numbers

    public int evalRPN(String[] tokens) {

        Set<String> signs = new HashSet<>();
        signs.add("+");
        signs.add("-");
        signs.add("*");
        signs.add("/");

        Stack<Integer> s = new Stack();
        for(String token: tokens){
            //if it is sign, pop top 2 evaluate and push result back
            //if not sign, just push numbers
            if(signs.contains(token)){
                int val2 = s.pop();
                int val1 = s.pop();
                int result = 0;
                if(token.equals("+")){
                    result = val1+val2;
                }
                if(token.equals("-")){
                    result = val1-val2;
                }
                if(token.equals("*")){
                    result = val1*val2;
                }
                if(token.equals("/")){
                    result = val1/val2;
                }
                s.push(result);
            } else{
                s.push(Integer.valueOf(token));
            }
        }

        return s.pop();
    }

}
