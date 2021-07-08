package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0,-6,5,4,3,2,1,-10,0};
        bubbleSort(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            boolean flag = false;
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] >= nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag)
                return;
        }
    }
}
