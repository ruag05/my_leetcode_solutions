package com.company;

import java.util.Arrays;

public class Main {

    //PROBLEM
    //  -Given an integer array nums of 2n integers, group these integers into n pairs
    //  (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized.
    //  Return the maximized sum.
    //
    //  -Constraints:
    //  1 <= n <= 104
    //  nums.length == 2 * n
    //  -10^4 <= nums[i] <= 10^4

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        System.out.println(arrayPairSum2(nums));
    }

    //took 10 ms (97 percentile) and 41.3 MB (39 percentile)
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i = i + 2){
            sum += nums[i];
        }
        return sum;
    }

    //too 4 ms (99.8 percentile) and 41.1 MB (48 percentile)
    public static int arrayPairSum2(int[] nums) {
        int[] temp = new int[20001];
        for(int i = 0; i < nums.length; i++){
            temp[10000 + nums[i]]++;
        }
        int sum = 0;
        boolean isOdd = true;
        for(int i = 0; i < temp.length; i++) {
            while(temp[i] > 0) {
                if (isOdd) {
                    sum += i - 10000;
                }
                isOdd = !isOdd;
                temp[i]--;
            }
        }
        return sum;
    }
}
