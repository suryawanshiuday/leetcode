package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 1135
 * Problem statement:
 * There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.
 *
 * Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,
 *
 * The cost is the sum of the connections' costs used.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 *
 *
 * Input: n = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation: There is no way to connect all cities even if all edges are used.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * 1 <= connections.length <= 104
 * connections[i].length == 3
 * 1 <= xi, yi <= n
 * xi != yi
 * 0 <= costi <= 105
 */

public class ConnectingCitiesWithMinimumCost {

    //Time Complexity: O(NlogN) due to sorting, find/union operations are O(logN)
    //Space complexity: O(N) due to root and rank arrays

    private int[] root;
    private int[] rank;

    public int minimumCost(int n, int[][] connections) {

        root = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<n; i++){
            root[i]=i;
            rank[i]=1;
        }

        //sort the cities by their cost of connecting, ascending
        //so we start connecting cities following shorter paths
        Arrays.sort(connections, (a, b)->a[2]-b[2]);

        int cost = 0;
        int connectedCities = 0;

        for(int[] conn: connections){
            int rootX = find(conn[0]);
            int rootY = find(conn[1]);
            //if cities are already connected, skip
            //else connect then and increase cost and count of connected cities
            if(rootX!=rootY){
                union(rootX,rootY);
                cost+=conn[2];
                connectedCities++;
            }
        }

        return (connectedCities==n-1) ? cost : -1;
    }

    private int find(int x){
        while(root[x]!=x)
            x = root[x];
        return x;
    }

    private void union(int rootX, int rootY){
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        } else if(rank[rootY] > rank[rootX]){
            root[rootX] = rootY;
        } else{
            rank[rootX]++;
            root[rootY] = root[rootX];
        }
    }

    private boolean isConnected(int x, int y){
        return find(x)==find(y);
    }
}
