package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode problem: 207
 * Problem statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */

public class CourseSchedule {

    //topological sort with indegree
    //Kahn's algo
    //Time complexity: O(E+V) where V=number of courses E=number of dependencies, worst case, we might have bidirectional dependency leading to O(2(E+V)) = O(E+V)
    //Space complexity: O(E+2V)=O(E+V), 2V because queue has V courses worst case, plus indegree[]

    public boolean canFinish(int n, int[][] edges) {

        if(edges.length==0)
            return true;

        //calculate indegree for each course
        //[0,1] -> take 1 first and then 0, 1->0, indegree[0]=1
        int[] indegree = new int[n];
        for(int[] edge: edges)
            indegree[edge[0]]++;

        //add course with 0 indegree in queue
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }

        //mark visited courses not to visit again
        int[] visited = new int[n];

        while(!queue.isEmpty()){
            //get the course with 0 indegree for queue
            int course = queue.poll();
            //if visited already, return
            if(visited[course]==1)
                continue;
            //for all the courses dependent on course, reduce their indegree
            for(int[] edge: edges){
                if(edge[1]==course)
                    indegree[edge[0]]--;
                //if indegree of dependent course becomes zero, add to queue
                if(indegree[edge[0]]==0)
                    queue.offer(edge[0]);
            }
            //mark visited
            visited[course]=1;
        }

        //if indegree of some course still remains non zero, means there is some cyclic dependency
        for(int i: indegree){
            if(i!=0)
                return false;
        }

        return true;
    }

}
