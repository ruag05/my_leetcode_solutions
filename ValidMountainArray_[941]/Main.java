package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an array of integers arr, return true if and only if it is a valid mountain array.
    //
    //  -Recall that arr is a mountain array if and only if:
    //
    //  - arr.length >= 3
    //  -There exists some i with 0 < i < arr.length - 1 such that:
    //  - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    //  - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

    public static void main(String[] args){
        int[] nums = new int[] {1,2,3};
        System.out.println(validMountainArray2(nums));
    }

    //took 2 ms & 40 MB
    public static boolean validMountainArray(int[] arr){
        if(arr == null || arr.length < 3){
            return false;
        }
        if(arr[0] >= arr[1])
            return false;
        boolean uphill = true;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                return false;
            } else if(uphill && arr[i] > arr[i+1]){
                uphill = false;
            } else if(!uphill && arr[i] < arr[i+1]){
                return false;
            }
        }
       return !uphill;
    }

    //took 1 ms (100 percentile) & 40 MB (68 percentile)
    public static boolean validMountainArray1(int[] arr) {
        int i = 0, j = arr.length -1;
        while(i < arr.length - 1 && arr[i] < arr[i+1]){
            i++;
        }
        while(j > 0 && arr[j - 1] > arr[j]){
            j--;
        }
        if(i > 0 && j < arr.length -1 && i == j)
            return true;
        else
            return false;
    }

    //took 1ms (100 percentile) & 39.9 MB (78 percentile)
    public static boolean validMountainArray2(int[] arr){
      int i = 0;
      while(i < arr.length - 1 && arr[i] < arr[i + 1]){
          i++;
      }

      if(i == 0 || i == arr.length - 1)
          return false;

      while(i < arr.length - 1 && arr[i] > arr[i + 1]){
          i++;
      }

      return i == arr.length - 1;
    }
}
