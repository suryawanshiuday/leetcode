package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode problem: 994
 * Problem statement:
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */

public class RottingOranges {

    //Time complexity: O(N) first loop to see rotten/fresh oranges and build queue, second loop for BFS, where we run every cell once
    //Space complexity: O(N) for queue

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //start BFS from firstRotten
        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0;
        //find all occurrences of rotten oranges at min 0, add to queue to start BFS for all of them together
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j});
                if(grid[i][j]==1)
                    freshOranges++;
            }
        }

        //if no oranges found
        if(freshOranges==0)
            return 0;

        //if oranges found but no rotten
        if(queue.isEmpty())
            return -1;

        //directions to find neighbors
        //R,L,D,U
        int[] rows = new int[]{0,0,1,-1};
        int[] cols = new int[]{1,-1,0,0};

        //starting from first orange, minute 0
        int minute = 0;

        while(!queue.isEmpty()){
            //increment only when all nodes with rotten oranges are processed at given minute
            boolean newRotten = false;
            //iterate oranges on same level
            int currentLevel = queue.size();
            for(int q=0; q<currentLevel; q++){
                int[] orange = queue.poll();
                int row = orange[0];
                int col = orange[1];
                for(int i=0; i<4; i++){
                    int nr = row+rows[i];
                    int nc = col+cols[i];
                    //if invalid neighbor, empty or already rotten
                    if(nr<0 || nr>=m || nc<0 || nc>=n || grid[nr][nc]!=1)
                        continue;
                    //found neighboring fresh orange which will rott
                    newRotten = true;
                    grid[nr][nc]=2;
                    freshOranges--;
                    queue.add(new int[]{nr, nc});
                }
            }

            if(newRotten)
                minute++;
        }
        return freshOranges==0?minute:-1;
    }

}
