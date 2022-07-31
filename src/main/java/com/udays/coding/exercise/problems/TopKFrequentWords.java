package com.udays.coding.exercise.problems;

import java.util.*;

/**
 * Leetcode problem: 692
 * Problem statement:
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 500
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 *
 *
 * Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */

public class TopKFrequentWords {

    //Time complexity: O(NlogK), heap has complexity O(NlogN) but we can no of elements in heap to k so O(NlogK)
    //Space complexity: O(n)

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();
        for(String word: words)
            freq.put(word, freq.getOrDefault(word,0)+1);

        //using a heap with lowest freq items in front
        //so when we poll, lowest freq items will get removed first leaving top k
        Queue<String> heap = new PriorityQueue<>((s1, s2)->{
            //if same frequency, sort lexographically
            if(freq.get(s1).equals(freq.get(s2))){
                return s2.compareTo(s1);
            }
            //else lower freq first
            else{
                return freq.get(s1).compareTo(freq.get(s2));
            }
        });

        //while adding elements, if size exceeds k, remove lowest freq item
        for(String each: freq.keySet()){
            heap.add(each);
            if(heap.size()>k)
                heap.poll();
        }

        List<String> answer = new ArrayList<>();
        while(!heap.isEmpty()){
            answer.add(0,heap.poll());
        }

        return answer;
    }

}
