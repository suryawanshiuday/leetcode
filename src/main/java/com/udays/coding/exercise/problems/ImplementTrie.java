package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 208
 * Problem statement:
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */

public class ImplementTrie {

    //Time complexity: O(L) length of word to search
    //Space complexity: O(W) no of words in trie

    class Trie {

        class TrieNode{
            boolean isWord;
            HashMap<Character, TrieNode> children = new HashMap<>();
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!current.children.containsKey(c)){
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(!current.children.containsKey(c))
                    return false;
                current = current.children.get(c);
            }
            return current.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for(int i=0; i<prefix.length(); i++){
                char c = prefix.charAt(i);
                if(!current.children.containsKey(c)){
                    return false;
                }
                current = current.children.get(c);
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
