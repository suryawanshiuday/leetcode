package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 240
 * Problem statement:
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 */

public class SearchIn2DMatrix {

    //Time complexity: O(m+n) i.e. visit each cell
    //Space complexity: O(1)

    public boolean searchMatrix(int[][] matrix, int target) {

        //set the start pointer to last row, col 0
        //smart solution O(m+n)
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            int current = matrix[row][col];
            //found target, return true
            if (current == target)
                return true;
                //if current value is greater, go to row above
            else if (current > target)
                row--;
                //if current value is smaller, go to highter column
            else
                col++;
        }

        return false;

        /*
        //brut force
        //slow O(n2), O(1)
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col]==target)
                    return true;
            }
        }
        return false;
        */
    }
}
