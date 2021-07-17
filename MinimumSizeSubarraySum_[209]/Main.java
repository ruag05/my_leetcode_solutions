package com.company;

import java.util.*;

public class Main {

    //PROBLEM
    //  -Given an array of positive integers nums and a positive integer target, return the minimal length
    //  of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than
    //  or equal to target. If there is no such subarray, return 0 instead
    //
    //  -Constraints:
    //
    //  1 <= target <= 109
    //  1 <= nums.length <= 105
    //  1 <= nums[i] <= 105

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen3(11, nums));
    }

    //took 117 ms (9 percentile) and 38.8 MB (83 percentile)    //brute force
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                if(sum + nums[j] >= target){
                    found = true;
                    min = Math.min(min, j - i + 1);
                    break;
                }
                else sum += nums[j];
            }
        }
        if(found) return min;
        else return 0;
    }

    //took 171 ms (5 percentile) and 38.8 MB (83 percentile) //brute force - uses secondary array to keep track of sums
    public static int minSubArrayLen2(int target, int[] nums){
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];

        int min = Integer.MAX_VALUE;
        boolean found = false;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int sum = sums[j] - sums[i] + nums[i];
                if(sum >= target){
                    found = true;
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        if(found) return min;
        else return 0;
    }

    //took 1 ms (99.98 percentile) and 38.8 MB (83 percentile)  //optimized way - using two pointers
    public static int minSubArrayLen3(int target, int[] nums){
        int sum = 0, left = 0, minLen = Integer.MAX_VALUE;
        boolean found = false;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                found = true;
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left++];
            }
        }
        if(found) return minLen;
        else return 0;
    }
}
