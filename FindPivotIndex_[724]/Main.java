package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,-1,0,1};
        System.out.println(pivotIndex3(nums));
    }

    //took 500ms (highly inefficient)
    public static int pivotIndex(int[] nums){
        int pIndex = 0, i, j, sumLeft, sumRight;
        while(pIndex <= nums.length - 1){
            sumLeft = 0;
            sumRight = 0;
            for(i = 0; i < pIndex; i++){
                sumLeft += nums[i];
            }
            for(j = nums.length - 1; j > pIndex; j--){
                sumRight += nums[j];
            }
            if(sumLeft == sumRight)
                return pIndex;
            else
                pIndex ++;
        }
        return -1;
    }

    //took 2ms (32 percentile) and 49 MB (15 percentile)
    public static int pivotIndex2(int[] nums){
        int sum = 0;
        for(int num : nums)
            sum += num;
        int leftSum = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(leftSum == (sum - nums[i] - leftSum))
                return i;
            else
                leftSum += nums[i];
        }

        return -1;
    }

    //took 1ms (100 percentile) and 39.6 MB (54 percentile)
    public int pivotIndex3(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;

        int rsum = sum;
        int lsum = 0;
        for(int i = 0; i < nums.length; i++){
            rsum -= nums[i];

            if(rsum == lsum)
                return i;
            lsum += nums[i];
        }
        return -1;
    }


}
