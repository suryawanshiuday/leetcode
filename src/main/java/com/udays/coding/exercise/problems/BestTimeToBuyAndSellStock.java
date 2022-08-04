package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 121
 * Problem statement:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

public class BestTimeToBuyAndSellStock {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public int maxProfit(int[] prices) {

        //maintain 2 variables
        //max profit will only be updated when profit between dip and rise is more than previously calculated
        int maxProfit = 0;
        //minPrice will be updated only for a dip larger than last dip
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            //if found a larger dip than previous, update
            if(prices[i]<minPrice){
                minPrice = prices[i];
            } else{
                //else calculate profit from current rise
                int profit = prices[i]-minPrice;
                //if profit exceeds last max, update maxProfit
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }

}
