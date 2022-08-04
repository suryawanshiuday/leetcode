package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 133
 * Problem statement:
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */

public class CloneGraph {

    //Time complexity: O(E+V) we visit each vertex and edge once
    //Space complexity: O(V) for visited hashmap for vertex

    Map<Integer, Node> visited = new HashMap<>();

    //recursion with DFS
    public Node cloneGraph(Node node) {

        Map<Integer,Node> lvisited = visited;

        //if inout is null, return null;
        if(node==null){
            return null;
        }

        //for every input, create new node and return that at the end
        Node n = new Node(node.val);
        //add new node to visited map
        visited.put(n.val, n);

        //iterate neighbors from original node (as new node will not have any)
        //create neighbors for new node
        for(Node each: node.neighbors){
            //if neighbor node is not visited, we found first neighbor
            //create a neighbor node and add to list of new node
            //no need to add explicitely to visited here as line 45 recusrion will take care of that
            if(visited.get(each.val)==null){
                Node newNeighbor = cloneGraph(each);
                n.neighbors.add(newNeighbor);
            }
            //if neighbor node is already visited
            //no need to create new and recurse as it will cause infinite loop
            //simply get the new node from map and add the neighbor for new node
            //if we do n.neighbors.add(each); that will not be clone
            else{
                n.neighbors.add(visited.get(each.val));
            }
        }
        return n;
    }


}
