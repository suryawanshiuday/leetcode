package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode problem: 210
 * Problem statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */

public class CourseScheduleII {

    //topological sort
    //Kahn's algo
    //Time complexity: O(E+V) where V=number of courses E=number of dependencies, worst case, we might have bidirectional dependency leading to O(2(E+V)) = O(E+V)
    //Space complexity: O(E+2V)=O(E+V), 2V because queue has V courses worst case, plus indegree[]

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //store the result as each visited course in queue
        int[] result = new int[numCourses];

        //calculate indegree of each course
        //0,1 means take 1 first and then 0, 1->0, indegree of 0 is 1
        int[] indegree = new int[numCourses];
        for(int[] each: prerequisites)
            indegree[each[0]]++;

        //Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        //add courses with zero indegree in queue
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }

        //visited array to avoid revisiting same courses
        int[] visited = new int[numCourses];
        //to store visited course in result at index
        int index = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            //if course visited before, skip
            if(visited[course]==1)
                continue;
            //store result of visited course with zero indegree
            result[index++]=course;
            //check all prereq and reduce indegree for courses dependent on this course
            for(int[] prereq: prerequisites){
                if(prereq[1]==course)
                    indegree[prereq[0]]--;
                //add to queue, if indegree becomes 0
                if(indegree[prereq[0]]==0)
                    queue.offer(prereq[0]);
            }
            //mark visited
            visited[course]=1;
        }

        //if indegree for certain nodes is not 0, means there was some sort of cyclic dependency
        //return empty
        for(int i: indegree){
            if(i!=0)
                return new int[0];
        }

        return result;
    }

}
