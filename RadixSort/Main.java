package com.company;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.log;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{432,8,530,90,88,231,11,45,677,199};
        radixSort(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void radixSort(int[] nums){
        //find max element
        int maxElement = Integer.MIN_VALUE;
        for(int num : nums){
            maxElement = Math.max(num, maxElement);
        }

        //find #digits in max element
        int digitCount = 0;
        while(maxElement > 0){
            digitCount++;
            maxElement /= 10;
        }

        //perform the logic for each digit place
        int[] countArr;
        int[] sortedArr;
        for(int i = 0 ; i < digitCount; i++){
            countArr = new int[10];
            sortedArr = new int[nums.length];

            //build count array for storing the frequency of the element by the specific digit
            for(int j = 0; j < nums.length; j++) {
                int digitAtPlace = (int)(nums[j] / Math.pow(10,i)) % 10;
                countArr[digitAtPlace]++;
            }

            //modify count array to calculate the correct position (not index)
            for(int j = 1; j < countArr.length; j++){
                countArr[j] += countArr[j-1];
            }

            //build sorted array for the specific digit
            for(int j = nums.length - 1; j >= 0; j--) {
                int digitAtPlace = (int)(nums[j] / Math.pow(10,i)) % 10;
                sortedArr[countArr[digitAtPlace] - 1] = nums[j];
                countArr[digitAtPlace]--;
            }

            //copy the sorted array back in original array
            System.arraycopy(sortedArr, 0, nums,0,sortedArr.length);
        }
    }
}
