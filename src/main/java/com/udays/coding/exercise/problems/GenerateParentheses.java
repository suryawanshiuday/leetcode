package com.udays.coding.exercise.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 22
 * Problem statement:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */

public class GenerateParentheses {

    //Time complexity: O()
    //Space complexity: O()

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        //int open, close=remaining count of available parentheses
        backtrack(ans, new StringBuilder(), 0, 0, n);
        System.out.println(ans.size());
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        //when we form string of 2n, that is answer
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        //first add n open, moving to next loop to add n close
        //then backtrack by removing one every time
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
