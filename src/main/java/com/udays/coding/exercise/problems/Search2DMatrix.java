package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 74
 * Problem statement:
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */

public class Search2DMatrix {

    //Time complexity: O(log(MN)), binary search in m rows and n cols
    //Space complexity: O(1)

    public boolean searchMatrix(int[][] matrix, int target) {
        //set the start pointer to last row, col 0
        //smart solution O(m+n)
        int row = matrix.length-1;
        int col = 0;

        while(row>=0 && col<matrix[0].length){
            int current = matrix[row][col];
            //found target, return true
            if(current == target)
                return true;
                //if current value is greater, go to row above
            else if(current>target)
                row--;
                //if current value is smaller, go to highter column
            else
                col++;
        }

        return false;
    }

}
