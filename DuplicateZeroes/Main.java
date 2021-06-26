package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given a fixed length array arr of integers, duplicate each occurrence of zero,
    //  shifting the remaining elements to the right.
    //
    //  -Note that elements beyond the length of the original array are not written.
    //
    //  -Do the above modifications to the input array in place, do not return anything from your function.

    public static void main(String[] args){
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeroes(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    public static void duplicateZeroes(int[] arr) {
        int zeroCount = 0;
        for(int i : arr){
            if(i == 0){
                zeroCount++;
            }
        }

        for(int i = arr.length - 1, j = arr.length + zeroCount -1; i < j; i--, j--){
            if(arr[i] != 0){
                if(j < arr.length)
                    arr[j] = arr[i];
            } else{
                if(j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if(j < arr.length)
                    arr[j] = arr[i];
            }
        }
    }
}
