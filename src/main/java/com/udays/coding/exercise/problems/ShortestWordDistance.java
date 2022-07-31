package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 243
 * Problem statement:
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.
 *
 *
 *
 * Example 1:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 2 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 */

public class ShortestWordDistance {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int ans = Integer.MAX_VALUE;
        //store the latest indexes of each word
        int index1 = -1;
        int index2 = -1;

        for(int i=0; i<wordsDict.length; i++){
            if(wordsDict[i].equals(word1))
                index1=i;
            if(wordsDict[i].equals(word2))
                index2=i;
            //evaluate answer only when we found both words
            if(index1>-1 && index2>-1)
                ans = Math.min(ans, Math.abs(index1-index2));
        }

        return ans;

    }

}
