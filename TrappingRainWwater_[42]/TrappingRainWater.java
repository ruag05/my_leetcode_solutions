import java.util.Collections;

public class TrappingRainWater {

    //PROBLEM: Trapping Rain Water
    //  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
    //  water it can trap after raining.
    //Constraints:
    //  n == height.length
    //  0 <= n <= 3 * 104
    //  0 <= height[i] <= 105

    public static void main(String[] args) {
        int[] height = {5,2,1}; // {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(height));
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    //took 85 ms (5 percentile) and 40.3 MB (10 percentile)
    //brute force - for each node, finds the max height left and right to it, by iterating in both the directions
    public static int trap(int[] height){
        int leftMax, rightMax, water = 0;
        for(int i = 0; i < height.length; i++){
            leftMax = 0;
            rightMax = 0;
            int pointer = i;
            while(pointer >= 0){
                leftMax = Math.max(leftMax, height[pointer]);
                pointer--;
            }
            pointer = i;
            while(pointer < height.length) {
                rightMax = Math.max(rightMax, height[pointer]);
                pointer++;
            }
            water += (Math.min(leftMax, rightMax) - height[i]);
        }
        return water;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //took 1 ms (86 percentile) and 40.7 MB (7 percentile)
    //Secondary arrays - Using 2 arrays to keep track of the max height observed in both, left and right of the element
    public static int trap2(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i > -1; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);

        int water = 0;
        for(int i = 0; i < height.length; i++)
            water += Math.min(leftMax[i], rightMax[i]) - height[i];

        return water;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //took 1 ms (85 percentile) and 38.8 MB (40 percentile)
    //Secondary Arrays - Optimized the 2 arrays approach used above
    public static int trap3(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int water = 0;
        for(int i = 0; i < height.length; i++){
            if(i == 0){
                leftMax[0] = height[0];
                rightMax[height.length - 1] = height[height.length - 1];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
                rightMax[height.length - 1 - i] = Math.max(rightMax[height.length - i], height[height.length - 1 - i]);
            }
        }

        for(int i = 0; i < height.length - 1; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    //took 1 ms (85 percentile) and 38.6 MB (51 percentile)
    //2 Pointers - Uses pointers to keep track of the max height observed till the element
    public static int trap4(int[] height){
        int water = 0, maxLeft = 0, maxRight = 0, i = 0, j = height.length - 1;
        while(i < j){
            if(height[i] < height[j]){
                maxLeft = Math.max(maxLeft, height[i]);
                water += maxLeft - height[i];
                i++;
            } else{
                maxRight = Math.max(maxRight, height[j]);
                water += maxRight - height[j];
                j--;
            }
        }
        return water;
    }
}
