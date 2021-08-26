import java.util.Arrays;

public class TargetSum {

    //PROBLEM: Target Sum
    //  You are given an integer array nums and an integer target.
    //  You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums
    //  and then concatenate all the integers.
    //  For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
    //  expression "+2-1".
    //  Return the number of different expressions that you can build, which evaluates to target.
    //Constraints:
    //  1 <= nums.length <= 20
    //  0 <= nums[i] <= 1000
    //  0 <= sum(nums[i]) <= 1000
    //  -1000 <= target <= 1000
    public static void main(String[] args){
        int[] nums = new int[]{1,0};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
    }

    // time complexity: O(2^n) (size of recursion tree will be 2^n, n: size of nums[])
    // space complexity: O(n) (depth of recursion tree can go up to n)
    //[Recursion - Brute Force] For each digit, there are two possibilities +, -. So, keep moving forward with these two
    //possibilities for each digit while keeping track of the count
    //took 444 ms (33 percentile) and 38.8 MB (39 percentile)
    public static int findTargetSumWays(int[] nums, int target){
        if(nums.length == 1 && (nums[0] == target || nums[0] == -target)) return 1;
        int count = 0;
        count += doSum(nums, 0, -nums[0], target);
        count += doSum(nums, 0, nums[0], target);
        return count;
    }
    public static int doSum(int[] arr, int index, int sum, int target){
        int count = 0;
        if(++index >= arr.length) return 0;
        if(index == arr.length - 1){
            if(sum + arr[index] == target)
                count++;
            if(sum - arr[index] == target)
                count++;
            return count;
        }
        count += doSum(arr, index, sum + arr[index], target);
        count += doSum(arr, index, sum - arr[index], target);
        return count;
    }

    // time complexity: O(l⋅n). The memo array of size l*nl∗n has been filled just once. Here, ll refers to the range
    //                      of sumsum and nn refers to the size of nums array.
    // space complexity: O(l⋅n). The depth of recursion tree can go upto n. The memo array contains l⋅n elements.
    //[Recursion - with memoization] For each digit, there are two possibilities +, -. So, keep moving forward with
    //these two possibilities for each digit while keeping track of the count and also storing the results in memo so if
    //we encounter them again, we can simply use it and not recalculate it
    //took 23 ms (56 percentile) and 51 MB (5 percentile)
    public static int findTargetSumWays2(int[] nums, int target){
        int[][] memo = new int[nums.length][2001];
        for(int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);

        if(nums.length == 1 && (nums[0] == target || nums[0] == -target)) return 1;

        int count = 0;
        count += doSum2(nums, 0, -nums[0], target, memo);
        count += doSum2(nums, 0, nums[0], target, memo);
        return count;
    }
    public static int doSum2(int[] arr, int index, int sum, int target, int[][] memo){
        int count = 0;
        if(++index >= arr.length) return 0;
        if(index == arr.length - 1){
            if(sum + arr[index] == target)
                count++;
            if(sum - arr[index] == target)
                count++;
            return count;
        }
        if(memo[index][sum + 1000] != Integer.MIN_VALUE) return memo[index][sum + 1000];


        int add = doSum2(arr, index, sum + arr[index], target, memo);
        int subtract = doSum2(arr, index, sum - arr[index], target, memo);
        memo[index][sum + 1000] = add + subtract;
        return memo[index][sum + 1000];
    }
}
