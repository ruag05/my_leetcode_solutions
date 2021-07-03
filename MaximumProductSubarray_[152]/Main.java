package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums, find a contiguous non-empty subarray within the
    //  array that has the largest product, and return the product.
    //
    //  -It is guaranteed that the answer will fit in a 32-bit integer.
    //
    //  -A subarray is a contiguous subsequence of the array.
    //
    //  -Constraints:
    //
    //  - 1 <= nums.length <= 2 * 104
    //  - -10 <= nums[i] <= 10
    //  - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    public static void main(String[] args) {
        int[] nums = new int[]{0,-1,2,3,0,-7};
        System.out.println(maxProduct(nums));
    }

    //took 1 ms (93 percentile) and 38.7 MB (82 percentile)
    public static int maxProduct(int[] nums){
        int max = nums[0], maxLocal = nums[0], minLocal = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = minLocal;
                minLocal = maxLocal;
                maxLocal = temp;
            }
            maxLocal = Math.max(maxLocal * nums[i], nums[i]);
            minLocal = Math.min(minLocal * nums[i], nums[i]);

            max = Math.max(max, maxLocal);
        }

        return max;
    }
}
