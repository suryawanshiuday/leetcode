package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 430
 * Problem statement:You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
 *
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
 *
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation: The multilevel linked list in the input is shown.
 * After flattening the multilevel linked list it becomes:
 *
 * Example 2:
 *
 *
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation: The multilevel linked list in the input is shown.
 * After flattening the multilevel linked list it becomes:
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 * Explanation: There could be empty list in the input.
 *
 *
 * Constraints:
 *
 * The number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 105
 *
 */

public class FlattenMultilevelDoublyLinkedList {

    //Time complexity: O(N) as we iterate all nodes
    //Space complexity: O(N) worst case stack will have all nodes

    //logic is to evaluate only the node with children
    //if a node has children, push the next of that to stack (if not null)
    //reassign next to children node
    //set child to null and follow along

    public Node flatten(Node head) {

        //output node
        Node out = new Node(-1);
        out.next = head;

        //stack to store next nodes of nodes with children
        Stack<Node> stack = new Stack();
        Node current = out;
        Node prev = out;
        while(current!=null){
            //evaluate nodes with child only, others just go along as there will be no changes
            if(current.child!=null){
                //push next on stack, if next is not already null
                //e.g. [1,null,2,null,3,null]
                if(current.next!=null)
                    stack.push(current.next);
                //reassing next to child
                current.next = current.child;
                //reassign prev of child to current
                current.child.prev = current;
                ///reset child
                current.child = null;
            }
            prev = current;
            current = current.next;
        }
        //join the nodes from stack at the end
        current = prev;
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            current.next = pop;
            pop.prev = current;
            while(current.next!=null)
                current = current.next;
        }

        return out.next;
    }

    private class Node {

        public int val;
        public Node next;
        public Node prev;
        public Node child;
        Node() {}
        public Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }

    }

}
