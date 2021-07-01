package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //
    //  -You want to maximize your profit by choosing a single day to buy one stock and choosing a
    //  different day in the future to sell that stock.
    //
    //  -Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
    //  return 0.

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,1,4};
        System.out.println(maxProfit(nums));
    }

    //took 1 ms (100 percentile) and 52.3 MB (52 percentile)
    public static int maxProfit(int[] prices){
        int profit = 0;
        int cp = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < cp){
                cp = prices[i];
            } else{
                profit = Math.max(profit, (prices[i] - cp));
            }
        }
        return profit;
    }
}
