package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 49
 * Problem statement:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

public class GroupAnagrams {

    //Time complexity: O(NlogN)
    //Space complexity: O(N)

    public List<List<String>> groupAnagrams(String[] strs) {

        //Sort each String, every anagram will match when sorted
        //put in map to group anagrams together based on sorted strings

        //key=sorted string, value=list of original strings
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String each: strs){

            char[] eachArray = each.toCharArray();
            Arrays.sort(eachArray);
            String sortedString = new String(eachArray);

            anagrams.putIfAbsent(sortedString,new ArrayList<String>());
            anagrams.get(sortedString).add(each);
        }

        //list of values is the answer
        return new ArrayList(anagrams.values());

    }

}
