package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 116
 * Problem statement:
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 *
 *
 * Follow-up:
 *
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */

public class PopulatingNextRightPointersInEachNode {

    //Time complexity: O(N)
    //Space complexity: O(1)

    //Note: BFS with queue is simpler but space complexity becomes O(N). In order to reduce it to O(1), this solution.

    public Node connect(Node root) {
        if(root==null){
            return root;
        }

        Node leftmost = root;

        while(leftmost.left!=null){

            //root as head
            Node head = leftmost;

            //work on current level, update leftmost only when current level is done
            //which is when last node.next stays null
            while(head!=null){

                //setup next pointer for left and right ndoes of root
                //left node of root->next->right node of root
                head.left.next = head.right;

                //if we have more nodes in current level, set the next of child nodes of different parent nodes
                //if head.next is not null, we can set head.right->next->head.next.left
                if(head.next!=null){
                    head.right.next = head.next.left;
                }

                //iterate until we reach end of current level
                head = head.next;
            }

            //update leftmost to point to next level
            leftmost = leftmost.left;

        }

        return root;
    }

    private class Node {

        public Node next;
        public Node left;
        public Node right;
        Node() {}

    }

}
