import java.util.*;

public class SingleNumber {

    //PROBLEM: Single Number
    //  Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    //  You must implement a solution with a linear runtime complexity and use only constant extra space.
    //Constraints:
    //  1 <= nums.length <= 3 * 104
    //  -3 * 104 <= nums[i] <= 3 * 104
    //  Each element in the array appears twice except for one element which appears only once.

    public static void main(String[] args){
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber4(nums));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[2 pointers] Sort the array and place one pointer at the start and other pointer next to it. If the values at
    //these two pointer match, then move both these pointer ahead by 2 and keep doing until the ahead pointer exceeds
    //array bounds.
    //took 5 ms (53 percentile) and 39 MB (75 percentile)
    public static int singleNumber(int[] nums){
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];

        int i = 0;
        int j = 1;

        while(j < nums.length){
            if(nums[i] != nums[j]){
                return nums[i];
            } else{
                i += 2;
                j += 2;
            }
        }
        return nums[i];
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //Traverse and find the minimum & maximum values and also, declare a checker array of size max - min + 1 to store
    //each element freq. Then, again traverse through the array and see if the value at checker array position
    //[num - min] is already greater than 0 (this would mean that we have already seen the value)
    //took 2 ms (56 percentile) and 39.3 MB (54 percentile)
    public static int singleNumber2(int[] nums){
        if(nums.length == 1) return nums[0];

        int max = nums[0];
        int min = nums[0];

        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] checker = new int[max - min + 1];
        for(int i = 0; i < nums.length; i++){
            if(checker[nums[i] - min] != 0) checker[nums[i] - min] = 0;
            else checker[nums[i] - min] = nums[i];
        }

        for(int num : checker)
            if(num != 0) return num;

        return 0;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap] Uses hashmap to store number and its frequency.
    //took 9 ms (32 percentile) and 39.4 MB (37 percentile)
    public static int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int num : nums) {
            if (map.get(num) < 2) return num;
        }
        return -1;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashSet] Uses two variables, one to sum distinct numbers (using HashSet) and one to sum all numbers. Then, just
    //subtract 2*distinct sum - all sum
    //took 6 ms (46 percentile) and 39.5 MB (31 percentile)
    public static int singleNumber4(int[] nums){
        int sumSet = 0, sum = 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
                sumSet += num;
            }
            sum += num;
        }
        return 2*sumSet - sum;
    }
}
