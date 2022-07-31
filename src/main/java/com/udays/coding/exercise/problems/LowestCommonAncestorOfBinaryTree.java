package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 236
 * Problem statement:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */

public class LowestCommonAncestorOfBinaryTree {

    //Time complexity: O(N) worst case if we need to traverse all nodes to find p and q
    //Space complexity: O(N) worst case when we need to traverse all nodes and store parents

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack();
        //childNode -> parent node
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        parents.put(root, null);
        stack.push(root);

        //iterate till you get parents for both p and q
        while(!parents.containsKey(p) || !parents.containsKey(q)){

            TreeNode current = stack.pop();

            if(current.left!=null){
                parents.put(current.left, current);
                stack.push(current.left);
            }

            if(current.right!=null){
                parents.put(current.right, current);
                stack.push(current.right);
            }
        }

        //add all parents of P in a set to do contains lookup later
        Set<TreeNode> parentsOfP = new HashSet<>();
        while(p!=null){
            parentsOfP.add(p);
            p = parents.get(p);
        }

        //backtrack parents of q, and see if that parent is also a parent of p
        //first such true lookup is LCA
        while(!parentsOfP.contains(q)){
            q = parents.get(q);
        }

        return q;
    }

}
