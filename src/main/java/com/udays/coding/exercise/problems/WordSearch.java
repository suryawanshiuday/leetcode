package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 79
 * Problem statement:
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */

public class WordSearch {

    //Time complexity: O(N*4^L) N=number of cells, L=length of word to match. We search every cell and we go in 4 directions to check the next character so it can turn into 4*4 for a single char
    //Space complexity: O(L) recursive stack of length of word to match

    char[][] board;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        //iterate board
        //first match of char will go into recursion-backtracking until we get answer
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(backtrack(r, c, word, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, String word, int index){
        //base case, we reached end of word
        if(index>=word.length())
            return true;

        //check bounds and if char[row][col] matches word.get(index)
        if(row>=rows || row<0 || col<0 || col>=cols
                || board[row][col]!=word.charAt(index))
            return false;

        //at this point, char[row][col] matches word.get(index)
        //so mark it visited by changing it to non char
        board[row][col] = '#';

        //if we iterate whole string and end at last matched char at certain position on board
        //base case is the only one where this will be returned as true and we break searching at that point
        boolean matchComplete = false;

        //proceed to next position in all four directions to see if next char matches
        //visit places in order, right/below/left/above
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        for(int dir=0; dir<rowOffset.length; dir++){
            matchComplete = backtrack(row+rowOffset[dir], col+colOffset[dir], word, index+1);
            if(matchComplete)
                break;
        }

        //we have to reset board because if we find partial match, we need to continue searching to find next first matching letter
        //e.g. word=AAB, small aab is the answer but we dont get that with first matching A at 0,1 or 0,2 or 1,0
        //C,A,A
        //a,a,A
        //b,C,D
        this.board[row][col] = word.charAt(index);
        return matchComplete;
        //return false;
    }

}
