package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 138
 * Problem statement:
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 *
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 *
 *
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */

public class CopyListWithRandomPointer {

    //Time complexity: O(N) as we visit every node exactly once
    //Space complexity: O(N) for visited array

    //keep track of all newly clones nodes
    //key, value = oldNode, newNode
    HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {

        if(head==null){
            return head;
        }

        Node current = head;

        //create new head node and add to visited
        Node newNode = new Node(current.val);
        visited.put(current, newNode);

        //iterate on head to clone next and random nodes
        while(current != null){
            newNode.random = cloneNode(current.random);
            newNode.next = cloneNode(current.next);

            current = current.next;
            newNode = newNode.next;
        }

        return visited.get(head);

    }

    public Node cloneNode(Node node){
        if(node==null){
            return null;
        }
        //if given node is already created, return from visited
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        //if not created, create from node value and add to visited and return
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        return newNode;
    }

    private class Node {

        public int val;
        public Node next;
        public Node prev;
        public Node child;
        public Node random;
        Node() {}
        public Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }

    }

}
