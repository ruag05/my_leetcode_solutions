package com.leetcode_solutions.ruchir;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{7,3,9,5,4,8,0,-11};
        mergeSort(nums); //takes O(n) space and O(nlogn) time
        for (int num : nums){
            System.out.println(num);
        }
    }

    public static void mergeSort(int[] nums){
        mergeSort(nums, 0 , nums.length - 1);
    }

    public static void mergeSort(int[] nums, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;

            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] sortedArr = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end ){
            if(arr[i] <= arr[j]){
                sortedArr[k] = arr[i];
                i++;
            } else{
                sortedArr[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            sortedArr[k] = arr[i];
            k++;
            i++;
        }
        while(j <= end){
            sortedArr[k] = arr[j];
            k++;
            j++;
        }

        System.arraycopy(sortedArr, 0,arr,start, end - start + 1);
    }
}
