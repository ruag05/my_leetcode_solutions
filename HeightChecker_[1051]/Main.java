package com.leetcode_solutions.ruchir;

public class Main {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,1,3,4,2,3,1};

        System.out.println(heightChecker(nums));

        countSort(nums);
        for(int element : nums){
            System.out.print(element);
        }
    }

    //took 0 ms (100 percentile) and 36.7 MB (62 percentile)
    public static int heightChecker(int[] height){
        int[] sortedArr = height.clone();
        countSort(sortedArr);
        int faults = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] != sortedArr[i])
                faults++;
        }
        return faults;
    }

    public static void countSort(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int element : nums){
            if(element > max)
                max = element;
        }

        int[] countArr = new int[max+1];
        for (int num : nums) {
            countArr[num] += 1;
        }

        int cPointer = 0, nPointer = 0;
        while(cPointer < countArr.length){
            if(countArr[cPointer] != 0){
                nums[nPointer] = cPointer;
                nPointer++;
                countArr[cPointer] -= 1;
            } else {
                cPointer++;
            }
        }
    }
}
