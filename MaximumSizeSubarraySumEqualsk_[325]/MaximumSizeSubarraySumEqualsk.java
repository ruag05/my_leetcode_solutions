import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {

    //PROBLEM :
    //  Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k.
    //  If there isn't one, return 0 instead.
    //Constraints:
    //  1 <= nums.length <= 2 * 105
    //  -104 <= nums[i] <= 104
    //  -109 <= k <= 109

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,2,1};
        System.out.println(maxSubArrayLen2(nums, 1));
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    // brute force - for each element we traverse the elements to its right and see, if the sum equals k
    // throws RTE
    public static int maxSubArrayLen(int[] nums, int k) {
        int maxLength = 0, sum = 0, left = 0;
        while(left < nums.length) {
            sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
            left++;
        }
        return maxLength;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //Uses HashMap - to store the total sum at each element and to keep checking whether at any of the previous elements
    //the sum was 'current sum - k' (logic : if at current element, the sum is 'sum' and at a specific element the sum
    //was 'sum - k' then it means that from that element to current element, the sum was k
    //took 279 ms (lintcode: 82 percentile) and 18 MB
    public static int maxSubArrayLen2(int[] nums, int k) {
        int max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            if(sum == k) max = right + 1;
            else if(map.containsKey(sum - k)){
                max = Math.max(max, right - map.get(sum - k));
            }
            if(!map.containsKey(sum)) map.put(sum, right);
        }
        return max;
    }
}
