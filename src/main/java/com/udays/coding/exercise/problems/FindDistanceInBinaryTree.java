package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 1740
 * Problem statement:
 * Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.
 *
 * The distance between two nodes is the number of edges on the path from one to the other.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
 * Output: 3
 * Explanation: There are 3 edges between 5 and 0: 5-3-1-0.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
 * Output: 2
 * Explanation: There are 2 edges between 5 and 7: 5-2-7.
 * Example 3:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
 * Output: 0
 * Explanation: The distance between a node and itself is 0.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 109
 * All Node.val are unique.
 * p and q are values in the tree.
 */

public class FindDistanceInBinaryTree {

    //Time complexity: O(N)
    //Space complexity: O(logN) as stack will have O(H) elements max for a balanced tree

    public int findDistance(TreeNode root, int p, int q) {

        //Answer is calculating LCA and then counting height of p and q from LCA, adding both is answer

        //to traverse tree
        Stack<TreeNode> stack = new Stack();
        //store parent-child for all nodes as child->parent
        Map<Integer, Integer> parents = new HashMap();
        stack.push(root);

        //put root of parent as Integer.MIN_VALUE to break loop later
        parents.put(root.val,Integer.MIN_VALUE);

        //traverse stack and build parents hashmap
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null){
                parents.put(node.left.val, node.val);
                stack.push(node.left);
            }
            if(node.right!=null){
                parents.put(node.right.val, node.val);
                stack.push(node.right);
            }
        }

        //get all parents of p and their height from p
        Map<Integer, Integer> parentsOfP = new HashMap();
        int height=0;
        while(p!=Integer.MIN_VALUE){
            parentsOfP.put(p,height++); //p can be parent of q so start from p
            p = parents.get(p);
        }

        //reset height to calculate height of q from LCA
        height=0;
        //get parents of q until we get LCA- first common root of p and q
        //calculate height of q from this
        while(!parentsOfP.containsKey(q)){
            q = parents.get(q);
            height++;
        }

        //q now holds lca
        //add height of q with height p from lca
        return height+parentsOfP.get(q);
    }

}
