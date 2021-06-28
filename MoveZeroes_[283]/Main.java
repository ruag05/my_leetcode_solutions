package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums, move all 0's to the end of it while maintaining
    //  the relative order of the non-zero elements.
    //
    //  -Note that you must do this in-place without making a copy of the array.

    public static void main(String[] args){
        int[] nums = new int[]{1,1,0,0,1,0,2};
        moveZeroes2(nums);
        for(int element : nums){
            System.out.println(element);
        }
    }

    //took 5 ms (10 percentile) and 39.1 MB (78 percentile)
    public static void moveZeroes(int[] nums){
        int writePointer = 0, readPointer = 0, replacePointer = nums.length -1;
        while(readPointer < replacePointer) {
            if (nums[readPointer] == 0) {
                //shift elements on right, one position by left
                while (writePointer < replacePointer) {
                    nums[writePointer] = nums[writePointer + 1];
                    writePointer++;
                }
                writePointer = readPointer;

                nums[replacePointer] = 0;
                replacePointer--;
            } else {
                writePointer++;
                readPointer++;
            }
        }
    }

    //took 0 ms (100 percentile) and 39.3 MB (53 percentile)
    public static void moveZeroes2(int[] nums){
        int zeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                zeroes++;
            else
            {
                int temp = nums[i - zeroes];
                nums[i - zeroes] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
