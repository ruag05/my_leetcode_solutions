public class KthSymbolInGrammar {

    //PROBLEM:
    //  We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
    //  we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
    //
    //  For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
    //  Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
    public static void main(String[] args) {
        System.out.println(kthGrammar(4,3));
    }

    /////////////approach#1////////////
    //  time complexity: O(n^2)
    //  space complexity: O(n)
    //threw Memory limit exceeded
    public static int kthGrammar(int n, int k) {
        if(n < 2) return n - 1;
        int totalLength = (int)Math.pow(2, n - 1);
        int[] cache = new int[totalLength];
        cache[0] = 0;

        int prevLength = -1;
        int currLength = -1;
        for(int r = 2; r <= n; r++){
            prevLength = (int)Math.pow(2, r - 2) - 1;
            currLength = (int)Math.pow(2, r - 1) - 1;
            for(int j = prevLength; j >= 0; j = j - 1){
                if(cache[j] == 0){
                    cache[currLength--] = 1;
                    cache[currLength--] = 0;
                } else if(cache[j] == 1){
                    cache[currLength--] = 0;
                    cache[currLength--] = 1;
                }
            }
        }
        for(Integer i : cache)
            System.out.print(i + " ");

        return cache[k-1];
    }

    /////////////approach#2////////////

    //  time complexity: O(lg n)
    //  space complexity: O(n) including recursion stack
    //took 0 ms (100 percentile) and 35.6 MB (80 percentile)
    //[recursion] start bottom to top, and every index at nth level is derived from n/2th index from previous level.
    public int kthGrammar2(int n, int k) {
        if(n == 1) return 0;

        if(k % 2 == 0){
            if(kthGrammar2(n - 1, k/2) == 0) return 1;
            else return 0;
        } else{
            if(kthGrammar2(n - 1, (k+1)/2) == 0) return 0;
            else return 1;
        }
    }
}
