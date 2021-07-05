package com.leetcode_solutions.ruchir;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{7,3,9,0, 10,1,-9};
        selectionSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }

    public static void selectionSort(int[] nums){
        int j = 0;

        while(j < nums.length - 1) {
            int minIndex = j;

            //find smallest element in unsorted sub-array
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            if(minIndex != j) { //skipping the swap when the first element is already the smallest value

                //swap first element of unsorted sub-array with smallest element found
                int temp = nums[minIndex];
                nums[minIndex] = nums[j];
                nums[j] = temp;
            }
            j++;
        }
    }
}
