package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 953
 * Problem statement:
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

public class VerifyingAlienDictionary {

    //Time complexity: O(M+N) where M=total no of chars in all words. but N is constant at 26 chars so O(M)
    //Space complexity: O(1) as dictionary will always have size as 26

    public boolean isAlienSorted(String[] words, String order) {

        //build dictionary of order of chars for O(1) lookup
        Map<Character, Integer> dict = new HashMap();
        int index = 1;
        for(char c: order.toCharArray())
            dict.put(c,index++);

        for(int i=1; i<words.length; i++){
            String first = words[i-1];
            String second = words[i];
            //e.g. [hello, hello] should return true, hence first check needed
            //e.g. [hello, hell] should return false, hence second check needed
            if(!first.equals(second) && first.startsWith(second))
                return false;
            //e.g. [hell, hello], no need to compare as they are already sorted
            if(second.startsWith(first))
                continue;
            //iterate only for length of smaller string
            int size = Math.min(first.length(), second.length());
            for(int j=0; j<size; j++){
                //if char at j matches in both, continue
                //find the first occurrence where char at j do not match, if they are sorted, no need to check rest of the word
                if(first.charAt(j)==second.charAt(j))
                    continue;
                else if(dict.get(first.charAt(j))<dict.get(second.charAt(j)))
                    break;
                else if(dict.get(first.charAt(j))>dict.get(second.charAt(j)))
                    return false;
            }
        }
        return true;
    }

}
