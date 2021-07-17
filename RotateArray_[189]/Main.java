package com.company;

public class Main {

    //PROBLEM
    //  -Given an array, rotate the array to the right by k steps, where k is non-negative.
    //
    //  -Constraints:
    //  1 <= nums.length <= 105
    //  -231 <= nums[i] <= 231 - 1
    //  0 <= k <= 105

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        rotate5(nums, 2);
        for(int num : nums){
            System.out.println(num);
        }
    }

    //threw Time Limit Exceeded error (simply shifting 0 to n-1 elements to 1 place right and last element to start
    public static void rotate(int[] nums, int k) {
        if(k > 0){
            while (k > 0) {
                int temp = nums[nums.length - 1];
                for (int i = nums.length - 2; i >= 0; i--)
                    nums[i + 1] = nums[i];
                nums[0] = temp;
                k--;
            }
        }
    }

    //threw Time Limit Exceeded error (moving elements with their last one by swapping, using a temp variable)
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;
        while(k > 0){
            int prev = nums[nums.length - 1];
            int temp;
            for(int i = 0; i < nums.length; i++){
                temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
            k--;
        }
    }

    //took 2 ms (38 percentile) and 56 MB (79 percentile) (uses secondary array to place elements at correct position)
    public static void rotate3(int[] nums, int k) {
        int[] tempArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            tempArr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(tempArr, 0 , nums, 0, tempArr.length);
    }

    //took 2 ms (38 percentile) and 56.1 MB (60 percentile) (swapping elements in cyclic replacements fashion)
    public static void rotate4(int[] nums, int k){
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start ++){
            int prevVal = nums[start];
            int currentIndex = start;
            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int tempVal = nums[nextIndex];
                nums[nextIndex] = prevVal;
                prevVal = tempVal;
                currentIndex = nextIndex;
                count++;
            } while(currentIndex != start);
        }
    }

    //took 0 ms (100 percentile) and 56.2 MB (60 percentile) (reverses array once as a whole, then again reverses
    // the subarrays around k)
    public static void rotate5(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0 , nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k , nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
