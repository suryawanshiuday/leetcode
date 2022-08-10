package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 145
 * Problem statement:
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class BinaryTreePostOrderTraversal {


    //Time complexity: O(N) as we visit each node max twice, once to locate the node and other to find successor
    //Space complexity: O(1)

    public static List<Integer> postorderTraversal(TreeNode root){
        //output array not considered towards space complexity
        //we will be building postorder from end to start in reverse order, hence we will keep adding elements to front of queue
        Deque<Integer> res = new ArrayDeque<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            //if current.right is null, read the value and make current as current.left
            //current.right is null, so we visit root which is current and add to deque in front
            //make curr=curr.left so we visited root->right(null)->left in reverse order of expected postorder
            //this makes it inorder traversal
            if (curr.right == null) {
                res.addFirst(curr.val);
                curr = curr.left; // assign current to left node
            }
            //if current.right is not null, we need to store the nodes somehow to traverse back to root
            //1. from current.right, traverse to leftmost node (successor)
            //2. make leftmost.left = current.left
            //3. make current = current.right (as we stored the pointer to current.left as leftmost.left, we don't lose the left node of this right)
            else {
                //1. from current.right, traverse to leftmost node
                pre = curr.right;
                while (pre.left != null) { // find leftmost
                    pre = pre.left;
                }
                //2. make leftmost.left = current.left
                pre.left = curr.left;
                //3. read the value or right which is current
                res.addFirst(curr.val);
                //3. make current = current.right
                curr = curr.right;
            }
        }
        return new ArrayList<>(res);
    }

    /*
    //Iterative solution
    //Time complexity: O(N)
    //Space complexity: O(N)

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> returnList = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        TreeNode tmp = null;

        while(!stack.isEmpty() || current!=null){
            //keep pushing left nodes to stack until we have reached leftmost leaf node
            if(current!=null){
                stack.push(current);
                current = current.left;
            } else{
                //if current node is null, meaning left leaf node
                //get right node of top from stack and store in tmp
                //to continue pushing left nodes, if present, of this right node until we reach left leaf
                tmp = stack.peek().right;
                //if right of top of stack is also null, then push the root which is top of stack to returnList
                if(tmp==null){
                    //this should be root, push to returnList as we visited left and right nodes already
                    tmp = stack.pop();
                    returnList.add(tmp.val);
                    //if tmp is right leaf node, so next node to add to returnList will be its root
                    //so check if stack has elements and tmp is right of root, root is at top in that case
                    while(!stack.isEmpty() && tmp == stack.peek().right){
                        //pop root of visited right
                        tmp = stack.pop();
                        returnList.add(tmp.val);
                    }
                }
                //if tmp is not null, means right node has further left nodes which should be pushed to stack
                else
                    current = tmp;

            }
        }
        return returnList;
    }
    */

}
