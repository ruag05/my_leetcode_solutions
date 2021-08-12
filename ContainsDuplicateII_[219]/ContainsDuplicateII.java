import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicateII {

    //PROBLEM: Contains Duplicate II
    //  Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
    //  such that nums[i] == nums[j] and abs(i - j) <= k.
    //Constraints:
    //  1 <= nums.length <= 105
    //  -109 <= nums[i] <= 109
    //  0 <= k <= 105

    public static void main(String[] args) {

    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap] Store the digits along with their index, in HashMap. If a digit is encountered twice, then check whether
    //the previous index of occurrence is within the specific range
    //took 19 ms (29 percentile) and 47.9 MB (74 percentile)
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.getOrDefault(nums[i], 0) > 0 && i + 1 - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i + 1);
        }
        return false;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashSet] Traverse the array and store the digits in a HashSet. If the current index has passed k, then remove the
    //kth digit in left direction from that index
    //took 13 ms (92 percentile) and 47.3 MB (85 percentile)
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
