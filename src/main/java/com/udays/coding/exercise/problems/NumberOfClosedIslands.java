package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 1254
 * Problem statement:
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */

public class NumberOfClosedIslands {

    //Time complexity: O(MxN)
    //Space complexity: O(MxN) worst case we might have MxN stack recursion

    //DFS approach

    int rows;
    int cols;
    int[][] grid;

    public int closedIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        this.grid = grid;

        //flip the islands connected to edges because they are not closed so should not be calculated in result
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(r==0 || c==0 || r==rows-1 || c==cols-1 && grid[r][c]==0){
                    dfs(r, c);
                }
            }
        }

        int islands = 0;

        //iterate grid columnwise to find first occurrence of land/0
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(this.grid[r][c]==0){
                    //how can we increment this even before running through dfs?
                    //starting from boundary inwards, all non closed islands have been turned to water using DFS in above loop
                    //so this has to be a closed island
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
        if(r>=rows || r<0 || c>=cols || c<0 || grid[r][c]==1)
            return;

        //found adjucent land, flip to water so dont have to maintain extra visited ds
        grid[r][c]=1;

        //check if adjucent cells are water in all 4 directions
        dfs(r, c+1);
        dfs(r+1, c);
        dfs(r, c-1);
        dfs(r-1, c);
    }

}
