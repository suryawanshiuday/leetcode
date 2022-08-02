package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 211
 * Problem statement:
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 3 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 */

public class DesignAddAndSearchWordsDataStructure {

    //Time complexity: O()
    //Space complexity: O()

    class WordDictionary {

        class TrieNode{
            boolean isWord;
            HashMap<Character, TrieNode> children = new HashMap();
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode current = root;
            for(char c: word.toCharArray()){
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            return searchInNode(word, root);
        }

        public boolean searchInNode(String word, TrieNode node){
            TrieNode current = node;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                //if char is not present in trie, return false
                //if input is ., it won't be present, so try all chars
                if(!current.children.containsKey(c)){
                    if(c=='.'){
                        //try every char at this level
                        for(char x: current.children.keySet()){
                            if(searchInNode(word.substring(i+1), current.children.get(x)))
                                return true;
                        }
                    }
                    return false;
                }
                else{
                    current = current.children.get(c);
                }
            }
            return current.isWord;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
