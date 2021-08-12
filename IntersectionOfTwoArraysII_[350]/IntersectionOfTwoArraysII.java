import java.util.List;
import java.util.ArrayList;

public class IntersectionOfTwoArraysII {
    //PROBLEM: Intersection of Two Arrays II
    //  Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
    //  appear as many times as it shows in both arrays and you may return the result in any order.
    //Constraints:
    //  1 <= nums1.length, nums2.length <= 1000
    //  0 <= nums1[i], nums2[i] <= 1000

    public static void main(String[] args){

    }

    // time complexity: O(n + m)
    // space complexity: O(n + m)
    //[Array and ArrayList] Store the freq of the first string in an array. Traverse the other string and check if the
    //fre of that element in array is greater than 1. Finally, fetch all the list elements to final array
    //took 0 ms (100 percentile) and 39.1 MB (61 percentile)
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] seen = new int[1001];
        for(int i = 0; i < nums1.length; i++)
            seen[nums1[i]]++;

        List<Integer> finList = new ArrayList<>();
        for(int num : nums2){
            if(seen[num] > 0){
                finList.add(num);
                seen[num]--;
            }
        }

        int[] res = new int[finList.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = finList.get(i);

        return res;
    }
}
