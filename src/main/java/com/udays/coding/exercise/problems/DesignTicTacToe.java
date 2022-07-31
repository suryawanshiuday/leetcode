package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 348
 * Problem statement:
 * Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
 *
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves are allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * Implement the TicTacToe class:
 *
 * TicTacToe(int n) Initializes the object the size of the board n.
 * int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
 *
 *
 * Example 1:
 *
 * Input
 * ["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
 * [[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
 * Output
 * [null, 0, 0, 0, 0, 0, 0, 1]
 *
 * Explanation
 * TicTacToe ticTacToe = new TicTacToe(3);
 * Assume that player 1 is "X" and player 2 is "O" in the board.
 * ticTacToe.move(0, 0, 1); // return 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 *
 * ticTacToe.move(0, 2, 2); // return 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 *
 * ticTacToe.move(2, 2, 1); // return 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 *
 * ticTacToe.move(1, 1, 2); // return 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 *
 * ticTacToe.move(2, 0, 1); // return 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 *
 * ticTacToe.move(1, 0, 2); // return 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 *
 * ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 *
 *
 * Constraints:
 *
 * 2 <= n <= 100
 * player is 1 or 2.
 * 0 <= row, col < n
 * (row, col) are unique for each different call to move.
 * At most n2 calls will be made to move.
 *
 *
 * Follow-up: Could you do better than O(n2) per move() operation?
 */

public class DesignTicTacToe {

    //Time complexity: O(1) because with every move we record values in arrays and check winning condition
    //Space complexity: O(n) for size of rows/cols=n

    class TicTacToe {

        int[] rows;
        int[] cols;
        int diag;
        int antidiag;
        int board;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            board = n;
        }

        //Algorithm
        //treat player1 as 1 and player2 as -1
        //maintain 2 arrays (cols, rows) where we count no of moves made by players
        //a move made by player1 will cancel out move made by player2 in same row/col/diagonal/antidiagonal
        //so when a player makes move, add player value to value in that field
        //WIN: when row/col/diagonal/antidiagonal=4
        public int move(int row, int col, int player) {
            int currentPlayer = (player==1)?1:-1;
            rows[row] += currentPlayer;
            cols[col] += currentPlayer;
            if(row==col)
                diag += currentPlayer;
            //anti diagonal is (2,0),(1,1),(0,2) in 3x3 board
            //4x4 (3,0),(2,1),(1,2),(0,3)
            if(col == (board-row-1))
                antidiag += currentPlayer;
            if(Math.abs(rows[row]) == board
                    || Math.abs(cols[col]) == board
                    || Math.abs(diag) == board
                    || Math.abs(antidiag) == board)
                return player;
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

}
