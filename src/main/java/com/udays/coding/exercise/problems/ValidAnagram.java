package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 242
 * Problem statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

public class ValidAnagram {

    //Time complexity: O(M+N)
    //Space complexity: O(1) as hashmap will always be of constant size to character set

    public boolean isAnagram(String s, String t) {

        //anagrams have equal length
        if(s.length()!=t.length())
            return false;

        //count freq of each char in s
        HashMap<Character, Integer> count = new HashMap<>();
        for(char c: s.toCharArray())
            count.put(c, count.getOrDefault(c,0)+1);

        //iterate over t and reduce freq of each char
        //anagram will eventually reduce map to zero
        for(char c: t.toCharArray()){
            if(!count.containsKey(c))
                return false;
            count.put(c, count.get(c)-1);
            if(count.get(c)==0){
                count.remove(c);
            }
        }
        return count.isEmpty();
    }

}
