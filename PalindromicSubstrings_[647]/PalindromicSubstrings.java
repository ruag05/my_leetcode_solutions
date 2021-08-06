public class PalindromicSubstrings {

    //PROBLEM: Palindromic Substrings
    //  Given a string s, return the number of palindromic substrings in it.
    //  A string is a palindrome when it reads the same backward as forward.
    //  A substring is a contiguous sequence of characters within the string
    //Constraints:
    //  1 <= s.length <= 1000
    //  s consists of lowercase English letters.

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    //Each character will be a palindrome. Then, consider each character as a center and using two pointers (i, j),
    //expand in both the directions until either string edges are encountered or mismatch of character at i and j occur
    //took 1 ms (99.82 percentile) and 37.1 MB (82 percentile)
    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count = 0;
        int i = 0, j = 0;

        //for possible odd length palindromes
        for(int c = 0; c < n; c++){
            count++;
            i = c - 1;
            j = c + 1;
            while(i >= 0 && j < n && chars[i--] == chars[j++])
                count++;
        }

        //for possible even length palindromes
        for(int c = 0; c < n; c++){
            i = c;
            j = c + 1;
            while(i >= 0 && j < n && chars[i--] == chars[j++])
                count++;
        }
        return count;
    }
}
