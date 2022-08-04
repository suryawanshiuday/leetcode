package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode problem: 1091
 * Problem statement:
 *
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */

public class ShortestPathInBinaryMatrix {

    //Algorithm
    //BFS where calculate distance for each neighboring zero in all 8 directions
    //when we reach end, we return max path
    //visualize: blob:https://leetcode.com/c681da34-59c0-4edc-a1c3-7b512be76eb9

    //Time complexity: O(N) as we visit each cell at most once
    //Space complexity: O(N) as queue might contain max N elements

    public int shortestPathBinaryMatrix(int[][] grid) {

        int end = grid.length-1;

        //if 0,0 or n,n is not zero, return -1
        if(grid[0][0]!=0 || grid[end][end]!=0)
            return -1;

        //directions to reach neighbors
        //R,L,D,U,RD,RU,LD,LU
        int[] rows = new int[]{0,0,1,-1,1,-1,1,-1};
        int[] cols = new int[]{1,-1,0,0,1,1,-1,-1};

        //initialize 0,0 to 1 as first counted node in path
        grid[0][0] = 1;

        //BFS
        //queue will hold positions on grid
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            //get first from queue
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            int distance = grid[row][col];
            //if we have already reached n,n, return distance
            if(row==end && col==end)
                return distance;
            //else iterate neighbors and set the distance to distance+1
            for(int i=0; i<8; i++){
                //neighbor position
                int nr = row+rows[i];
                int nc = col+cols[i];
                //not eligible neighbor
                if(nr<0 || nr>end || nc<0 || nc>end || grid[nr][nc]!=0)
                    continue;
                //add to queue
                queue.add(new int[]{nr, nc});
                //increase distance for this neighbor
                grid[nr][nc]=distance+1;
            }
        }

        return -1;
    }


}
