package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an array arr, replace every element in that array with the greatest element
    //  among the elements to its right, and replace the last element with -1.
    //
    //  -After doing so, return the array.

    public static void main(String[] args){
        int[] nums = new int[]{17, 18, 5, 4, 6, 1};
        for(int element : replaceElements(nums)){
            System.out.print(element + " ");
        }
    }

    public static int[] replaceElements(int[] arr){
        int max = -1;
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, arr[i]);
        }
        return arr;
    }
}
