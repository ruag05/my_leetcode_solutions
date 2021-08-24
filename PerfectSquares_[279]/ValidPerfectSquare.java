public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }

    // time complexity: O(logn)
    // space complexity: O(logn)
    //[binary search]
    //took 0 ms (100 percentile) and 35.5 MB (84 percentile)
    public static boolean isPerfectSquare(int num) {
      if(num == 1) return true;
        long low = 0, high = num;
        while(low <= high){
            long mid = (low + high) / 2;
            long sq = mid * mid;
            if(sq == num) return true;
            if(sq < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
