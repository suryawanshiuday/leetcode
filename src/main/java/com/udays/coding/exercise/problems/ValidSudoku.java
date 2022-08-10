package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 36
 * Problem statement:
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */

public class ValidSudoku {

    //Time complexity: O(N) as we iterate whole board in worst case
    //Space complexity: O(1) as max size of sets remain constant

    public boolean isValidSudoku(char[][] board) {

        int n = board[0].length;

        //store distinct numbers for each row/col/box
        //if duplicate, return false
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> boxes = new ArrayList<>();
        for(int i=0; i<n; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<board.length; c++){
                char current = board[r][c];

                //if current char is ., its empty so skip
                if(current=='.')
                    continue;

                //check if no exists in row
                if(rows.get(r).contains(current))
                    return false;
                else
                    rows.get(r).add(current);

                //check if no exists in col
                if(cols.get(c).contains(current))
                    return false;
                else
                    cols.get(c).add(current);

                //check if no exists in row
                //interesting equation
                //r=4, c=7 boxIndex=(4/3)*3+(7/3)=(1)*3+2=5
                int boxIndex = (r/3)*3 + (c/3);
                if(boxes.get(boxIndex).contains(current))
                    return false;
                else
                    boxes.get(boxIndex).add(current);
            }
        }

        return true;
    }

}
