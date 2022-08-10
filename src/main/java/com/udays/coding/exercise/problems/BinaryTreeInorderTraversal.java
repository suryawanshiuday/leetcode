package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 94
 * Problem statement:
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal {

    //Morris traversal algorithm
    //Time complexity: O(N) as we visit each node max twice, once to locate the node and other to find predecessor
    //Space complexity: O(1)

    public List<Integer> inorderTraversal(TreeNode root) {
        //output array not considered towards space complexity
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            //if current.left is null, read the value and make current as current.right
            //current.left is null, so we visit root which is current and then assign current.right to be visited
            //this makes it inorder traversal
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // assign current to right node
            }
            //if current.left is not null, we need to store the nodes somehow to traverse back to root
            //1. from current.left, traverse to rightmost node (predecessor)
            //2. make rightmost.right = current
            //3. make current = current.left (as we stored the pointer to current as rightmost.right, we don't lose the parent node of this left)
            //4. (optimization) original cur left be null, avoid infinite loops
            else {
                //1. from current.left, traverse to rightmost node
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                //2. make rightmost.right = current
                pre.right = curr;
                //3. make current = current.left
                //4. (optimization) original cur left be null, avoid infinite loops
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null;
            }
        }
        return res;
    }

    /*
    //Time complexity: O(N)
    //Space complexity: O(N)

    //Iterative Solution

    public List<Integer> inorderTraversal(TreeNode root) {

        //answer
        List<Integer> returnList = new ArrayList();

        //null check
        if(root==null){
            return returnList;
        }

        //stack to hold nodes to traverse
        Stack<TreeNode> nodeStack = new Stack();

        //preorder left->root->right
        //so don't push root to stack yet, first element to be on top of stack should be leftmost
        TreeNode current = root;

        //idea is to keep pushing left, so stack has left nodes and its roots already
        //so no need to visit root seperately
        while(!nodeStack.isEmpty() || current!=null){

            //while loop to keep pushing left elements to stack
            while(current!=null){
                //hold the current element to trace back
                nodeStack.push(current);
                //traverse left subtree first
                current = current.left;
            }

            //when we reach leaf node in left
            //pop the element, because that would be left most, that would have null left node
            //so make it current being evaluated and add the value to output
            //this becomes root as leftmost node will have null left/right nodes
            current = nodeStack.pop();
            returnList.add(current.val);
            //now visit right node
            //for leftmost node,this will be null and we will pop root of leftmost in next iteration
            current = current.right;
        }

        return returnList;
    }

    /*

    //recursive solution

    public List<Integer> inorderTraversal(TreeNode root) {
        //answer
        List<Integer> returnList = new ArrayList<>();
        return recurse(root, returnList);
    }

    public List<Integer> recurse(TreeNode root, List<Integer> returnList){

        //null check and leaf check
        if(root == null){
            return returnList;
        }

        //visit left nodes first in recursive order
        recurse(root.left, returnList);
        //visit node
        returnList.add(root.val);
        //visit right nodes later in recursive order
        recurse(root.right, returnList);

        return returnList;

    }
    */

}
