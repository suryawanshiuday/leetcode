package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 200
 * Problem statement:
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */

public class NumberOfIslands {

    //Time complexity: O(MxN)
    //Space complexity: O(MxN) worst case we might have MxN stack recursion

    //DFS approach

    int rows;
    int cols;
    char[][] grid;

    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;

        int islands = 0;

        //iterate grid columnwise to find first occurrence of land/1
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(this.grid[r][c]=='1'){
                    ++islands;
                    dfs(r, c);
                }
            }
        }

        return islands;
    }

    public void dfs(int r, int c){

        //check bounds
        //if row/col index is out of bounds or its already water, return
        if(r>=rows || r<0 || c>=cols || c<0 || grid[r][c]=='0')
            return;

        //found adjucent land, flip to water so dont have to maintain extra visited ds
        grid[r][c]='0';

        //check if adjucent cells are water in all 4 directions
        dfs(r, c+1);
        dfs(r+1, c);
        dfs(r, c-1);
        dfs(r-1, c);
    }

}
