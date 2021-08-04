public class FindMinimuminRotatedSortedArray {

    //PROBLEM: Find Minimum in Rotated Sorted Array
    //  Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
    //  Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
    //  [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    //  Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    //  You must write an algorithm that runs in O(log n) time.
    //Constraints:
    //  n == nums.length
    //  1 <= n <= 5000
    //  -5000 <= nums[i] <= 5000
    //  All the integers of nums are unique.
    //  nums is sorted and rotated between 1 and n times.

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2};
        System.out.println(findMin2(nums));
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    //Modified Binary search approach - Place pointers at the end and keep checking whether the value at middle
    //element is greater than the end element and accordingly modify the start/end pointers.
    //took 0 ms (100 percentile) and 38.6 MB (38 percentile)
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        int mid = 0;
        while(start != end){
            mid = (start + end) / 2;
            if(start == mid){
                if(nums[start] > nums[end]) return nums[end];
                return nums[start];
            }
            if(nums[mid] > nums[end]) start = mid;
            else end = mid;
        }
        return nums[start];
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    //Optimized above approach - Check if the value at the mid element is greater than its next element (if so, then
    //next element is the smallest). Similarly, check if the value at the mid element is less than its prev element (if
    //so, then mid element is the smallest)
    //took 0 ms (100 percentile) and 38.3 MB (65 percentile)
    public static int findMin2(int[] nums) {
        if(nums.length == 1) return nums[0];

        int start = 0;
        int end = nums.length - 1;

        int mid = 0;
        while(start < end){
            mid = (start + end) / 2;

            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];

            if(start == mid){
                if(nums[start] > nums[end]) return nums[end];
                return nums[start];
            }
            if(nums[mid] > nums[end]) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }
}
