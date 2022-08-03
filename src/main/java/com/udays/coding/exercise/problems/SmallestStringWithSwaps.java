package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 1202
 * Problem statement:
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */

public class SmallestStringWithSwaps {

    //Time complexity: O()
    //Space complexity: O()

    //union find with rank soultion

    private int[] root;
    private int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        root = new int[s.length()]; //[0,1,2,3,4]
        rank = new int[s.length()]; //[1,1,1,1,1]
        for(int i=0; i<root.length; i++){
            root[i]=i;
            rank[i]=1;
        }

        //union edges and populate ranks
        for(List<Integer> pair: pairs){
            union(pair.get(0), pair.get(1));
        }
        int[] lrt = root;
        int[] lrk = rank;

        //group the characters which can be swapped together as a group
        //<root, [indexes of root]>
        //storing indexes instead of chars from s at those indexes, to keep it small and quick
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i=0; i<root.length; i++){
            //find ultimate root of index
            int rootOfIndex = find(i);
            map.putIfAbsent(root[rootOfIndex], new ArrayList());
            map.get(rootOfIndex).add(i);
        }

        //build the answer
        char[] answer = new char[s.length()];
        for(List<Integer> indices: map.values()){
            //get the chars at indices which can be grouped together and sorted
            List<Character> chars = new ArrayList();
            for(int index: indices)
                chars.add(s.charAt(index));
            //sort
            Collections.sort(chars);
            //put each character at its index in answer array
            for(int index=0; index<indices.size(); index++){
                answer[indices.get(index)] = chars.get(index);
            }
        }

        return new String(answer);

    }

    // The find function here is the same as that in the disjoint set with path compression.
    //O(alpha)=O(1), alpha is inverse ackerman function regarded as constant
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }


    // The union function with union by rank
    //O(alpha)=O(1), alpha is inverse ackerman function regarded as constant
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

}
