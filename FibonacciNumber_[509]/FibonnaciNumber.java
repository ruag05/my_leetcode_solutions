public class FibonnaciNumber {
    //PROBLEM: Fibonacci Number
    //  The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each
    //  number is the sum of the two preceding ones, starting from 0 and 1. That is,
    //  F(0) = 0, F(1) = 1
    //  F(n) = F(n - 1) + F(n - 2), for n > 1.
    //  Given n, calculate F(n).

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Memoization] Stores the fibonacci results in an array for reusing them to save further computation
    //took 0 ms (100 percentile) and 35.9 MB (57 percentile)
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    ////////////Recursion//////////////
    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Recursion + Memoization] Stores the fibonacci results in an array for reusing them to save further computation
    //took 0 ms (100 percentile) and 35.9 MB (57 percentile)
    public int fib2(int n) {
        if(n == 0) return 0;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        return helper(n, arr);
    }
    public int helper(int n, int[] arr){
        if(n <= 0) return 0;

        if(arr[n] > 0) return arr[n];

        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }
}
