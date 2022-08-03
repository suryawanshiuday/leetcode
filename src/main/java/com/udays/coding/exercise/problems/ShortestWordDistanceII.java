package com.udays.coding.exercise.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 244
 * Problem statement:
 * Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
 *
 * Implement the WordDistance class:
 *
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 *
 *
 * Example 1:
 *
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 *
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 *
 *
 * Constraints:
 *
 * 1 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 * At most 5000 calls will be made to shortest.
 */

public class ShortestWordDistanceII {

    //Time complexity: O()
    //Space complexity: O()

    class WordDistance {

        Map<String, List<Integer>> indexMap;

        //store index of each word, repeating word will have multiple indexes
        public WordDistance(String[] wordsDict) {
            indexMap = new HashMap();
            for(int i=0; i<wordsDict.length; i++){
                indexMap.putIfAbsent(wordsDict[i], new ArrayList<Integer>());
                indexMap.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            //initializa answer to max
            int answer = Integer.MAX_VALUE;
            //iterate over indexes for both words and calculate minimum distance
            for(int index1 : indexMap.get(word1)){
                for(int index2: indexMap.get(word2)){
                    answer = Math.min(answer, Math.abs(index1-index2));
                }
            }
            return answer;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */

}
