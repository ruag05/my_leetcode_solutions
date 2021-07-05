package com.leetcode_solutions.ruchir;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{7,3,9,5};
        insertionSorting(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }

    public static void insertionSorting(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] >= temp){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }
}
