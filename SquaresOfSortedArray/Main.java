package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums sorted in non-decreasing order,
    //  return an array of the squares of each number sorted in non-decreasing order.

    public static void main(String[] args){
        int[] nums = new int[]{ -7, -3, -2, -1, 4, 8, 10};
        for(int i : sortedSquares(nums)){
            System.out.println(i);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int splitIndex = searchFirstPositiveNumber(nums);
        int[] finalArr = new int[nums.length];

        if(splitIndex == 0){
            int k = 0;
            for(int i = 0; i< nums.length; i++){
                finalArr[k] = nums[i] * nums[i];
                k++;
            }
        } else {
            int i = splitIndex - 1, j = splitIndex, k = 0;

            while (i >= 0 && j < nums.length) {
                if (nums[i] * nums[i] < nums[j] * nums[j]) {
                    finalArr[k] = nums[i] * nums[i];
                    i--;
                } else {
                    finalArr[k] = nums[j] * nums[j];
                    j++;
                }
                k++;
            }
            while (i >= 0) {
                finalArr[k] = nums[i] * nums[i];
                i--;
                k++;
            }
            while (j < nums.length) {
                finalArr[k] = nums[j] * nums[j];
                j++;
                k++;
            }
        }
        return finalArr;
    }
    public static int searchFirstPositiveNumber(int[] arr){
        int low =0, high = arr.length -1;
        while(low != high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
