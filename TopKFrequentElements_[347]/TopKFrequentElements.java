import java.util.*;

public class TopKFrequentElements {

    //PROBLEM:
    //  Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in
    //  any order.
    //Constraints:
    //  1 <= nums.length <= 105
    //  k is in the range [1, the number of unique elements in the array].
    //  It is guaranteed that the answer is unique.
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        for(int num : topKFrequent(nums, 2))
            System.out.println(num);
    }

    // time complexity: O(n^2)
    // space complexity: O(n)
    //[HashMap, QuickSelect(Hoare's selection algorithm)] Build hashmap for storing each element and its frequency. Then,
    //fetch all the keys and store them in an array. Next, apply QuickSelect where we randomly select a pivot and apply
    //a partition algorithm to get its correct place such that all elements to its left have smaller freq and all elements
    //to the right have equal/higher freq. We keep doing this until that pivot index equals to n - k (as we have to find
    //k most frequent elements
    //took 9 ms (83 percentile) and 41.6 MB (57 percentile)
    static Map<Integer, Integer> map;
    public static int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        int n = map.size();
        int[] unique = new int[n];
        int i = 0;
        for(int num : map.keySet()){
            unique[i] = num;
            i++;
        }

        quickSelect(unique, 0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }
    public static void quickSelect(int[] arr, int start, int end, int neededPivotIndex){
        if(start == end) return;

        Random rand = new Random();
        int pivotIndex = start + rand.nextInt(end - start);

        pivotIndex = partition(arr, start, end, pivotIndex);

        if(pivotIndex == neededPivotIndex) return;
        else if(neededPivotIndex < pivotIndex) quickSelect(arr, start, pivotIndex - 1, neededPivotIndex);
        else quickSelect(arr,pivotIndex + 1, end, neededPivotIndex);
    }
    public static int partition(int[] arr, int start, int end, int pivotIndex){
        int pivotFreq = map.get(arr[pivotIndex]);

        swap(arr, pivotIndex, end);

        int smallElementsBoundary = start;
        for(int i = smallElementsBoundary; i < end; i++){
            if(map.get(arr[i]) < pivotFreq){
                swap(arr, smallElementsBoundary, i);
                smallElementsBoundary++;
            }
        }

        swap(arr, smallElementsBoundary, end);

        return smallElementsBoundary;
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
