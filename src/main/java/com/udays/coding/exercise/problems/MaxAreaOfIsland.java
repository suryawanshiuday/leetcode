package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 695
 * Problem statement:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */

public class MaxAreaOfIsland {

    //Time complexity: O(N.4^N), visit all cells and each cell has further DFS in 4 directions
    //Space complexity: O(4^N), recursion stack

    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {

        this.grid = grid;

        int maxArea = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                //find island, occurrence of 1
                if(grid[i][j]==1){
                    int[] area = new int[]{0};
                    //DFS, flip island to water and calculate area for each land
                    flip(i, j, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }

        return maxArea;
    }

    private void flip(int i, int j, int[] area){
        //if i is out of bounds, or is already water, return
        if(i>=grid.length || i<0
                || j>=grid[0].length || j<0
                || grid[i][j]==0
        )
            return;
        //calculate area
        area[0] = area[0]+grid[i][j];
        //flip land to water
        grid[i][j]=0;
        //check in four directions for connected land
        flip(i,j+1,area);
        flip(i,j-1,area);
        flip(i+1,j,area);
        flip(i-1,j,area);
        return;
    }

}
