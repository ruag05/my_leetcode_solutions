package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{432,8,530,90,88,231,11,45};
        heapSort(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void heapSort(int[] nums){

        //build the max-heap (starting from the first non-leaf node
        // (which is (n/2) - 1), in right to left order
        for(int i = ((nums.length - 1)/2) - 1; i >= 0; i--){
            maxHeapify(nums,nums.length, i);
        }

        //start removing the elements (since it is max-heap, the root element will be max,
        //so, swap it with the last element and reduce the size by 1(so we don't consider the largest
        //element now placed at the end
        int counter = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            counter ++;
            maxHeapify(nums, nums.length - counter, 0);
        }
    }

    //to ensure that the sub-tree follows max-heap properties (that is,
    //1. Parent be greater than any of its child
    //2. Tree is complete binary tree, and the data in the last level should be as left as possible
    public static void maxHeapify(int[] nums, int k, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        //check if left child is greater than the node
        while(left <= k - 1 && nums[left] > nums[largest]){
           largest = left;
        }

        //check if right child is greater than the node
        while(right <= k - 1 && nums[right] > nums[largest]){
            largest = right;
        }

        //check if node is not already the largest among it's children
        if(i != largest) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            maxHeapify(nums, k, largest);
        }
    }
}
