import java.util.*;

public class IntersectionOfTwoArrays {

    //PROBLEM: Intersection of Two Arrays
    //  Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
    //  must be unique and you may return the result in any order.
    //Constraints:
    //  1 <= nums1.length, nums2.length <= 1000
    //  0 <= nums1[i], nums2[i] <= 1000

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        for(int num : intersection2(nums1, nums2))
            if(num != 0) System.out.println(num);
    }

    // time complexity: O(n + m)
    // space complexity: O(n + m)
    //[HashSet] Store input arrays in two different HashSet and for any these of these HashSets, check if that element
    //is present in other input array (input array that was used to create the other hashset
    //took 2 ms (95 percentile) and 39.4 MB (31 percentile)
    public static int[] intersection(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1)
            set1.add(num);

        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2)
            set2.add(num);

        Set<Integer> finalSet = new HashSet<>();
        for(int num : set1){
            if(set2.contains(num)) finalSet.add(num);
        }

        int[] res = new int[finalSet.size()];
        int index = 0;
        for(int num : finalSet){
            res[index] = num;
            index++;
        }

        return res;
    }

    // time complexity: O(n + m)
    // space complexity: O(n)
    //[Secondary array and List] Add all elements of first/any input array to a secondary array at the position equal to the value and then
    //for the other input array keep checking whether there exists a value at that position in the secondary array.
    //took 0 ms (100 percentile) and 39.1 MB (59 percentile)
    public static int[] intersection2(int[] nums1, int[] nums2){
        int[] temp = new int[1001];

        for(int num : nums1)
            temp[num] = num + 1;

        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(temp[num] > 0){
                list.add(num);
                temp[num] = 0;
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }
}
