package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 322
 * Problem statement:
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */

public class CoinChange {

    //Time complexity: O(C*N) for every 0-N we iterate on all coins
    //Space complexity: O(N) space for dp[]

    public int coinChange(int[] coins, int amount) {

        //coins 1,2,5
        //minimum coins for making amount 1 = 1 i.e. f(1)=1 (1 coin)
        //f(2)=min(2,1)=1 i.e. 2(1s) or 1(2s)
        //f(3)=min(2,3)=2 i.e. 1(1s)+1(2s) or 3(1s)
        //f(4)=min(2,4)=2 i.e. 2(2s) or 4(1s)
        //f(5)=min(3,5,1)=1 i.e. 2(2s)+1(1s) or 5(1s) or 1(5s)
        //f(6)=min(3,6,2)=2 i.e. 3(2s) or 6(1s) or 1(5s)+1(1s)

        //amount +1 because we will start from base case 0
        int[] dp = new int[amount+1];
        //initialize dp values to be max so we pick min from iteration
        Arrays.fill(dp,amount+1);

        //how many coints do we need to get 0 amount, 0
        //base case
        dp[0] = 0;

        //iterate from 1 until amount
        for(int i=1; i<dp.length; i++){
            //check all available coins to see which gives amount in min coins
            for(int j=0; j<coins.length; j++){
                //if coin is greater than amount, we can't use
                //so take coins smaller than or equal to amount
                int coinValue = coins[j];
                if(coinValue<=i)
                    //e.g. coinValue=2, dp[7] = min(Integer.MAX_VALUE, 1+dp[7-2])
                    dp[i] = Math.min(dp[i], 1+dp[i-coinValue]);
            }
        }

        //if dp[amount] = amount+1, that means we didnt find the ans and return -1 else return dp[amount]
        return dp[amount]>amount?-1:dp[amount];
    }

}
