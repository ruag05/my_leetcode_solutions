package com.company;

public class Main {

    //PROBLEM
    //  -Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    //
    //  -Clarification:
    //  What should we return when needle is an empty string? This is a great question to ask during an interview.
    //  For the purpose of this problem, we will return 0 when needle is an empty string.
    //  This is consistent to C's strstr() and Java's indexOf()

    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "pi"));
        String name = "Ruchir";
        System.out.println(name.indexOf("ch"));
    }

    //** Approach 1 ** (uses Naive Searching Algorithm/Brute Force)
    //took 1338 ms (9 percentile) and 39.2 mb (23 percentile)
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;

        int m = haystack.length();
        int n = needle.length();
        if(m < n) return -1;

        for(int i = 0; i <= m - n; ++i){
            int j;
            for(j = 0; j < n; ++j){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if(j == n) return i;
        }
        return -1;
    }
    // End of approach 1

    //** Approach 2 ** (uses KMP algorithm)
    //took 6 ms (25 percentile) and 39.3 MB (18 percentile)
    public static int strStr2(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int[] parr = kmpPreprocess(needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else if(j > 0) {
                j = parr[j - 1];
            } else {
                i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }
    private static int[] kmpPreprocess(String pattern) {
        int i = 1, j = 0;
        int[] res = new int[pattern.length()];
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                res[i] = j+1;
                i++; j++;
            } else if (j > 0) {
                j = res[j-1];
            } else {
                res[i] = 0;
                i++;
            }
        }
        return res;
    }
    //** End of approach 2

    //** Approach 3 **
    //took 300 ms (17 percentile) and 40.1 MB (9 percentile)
    public static int strStr3(String haystack, String needle) {
        if (needle.isEmpty() || haystack.equals(needle)) return 0;

        String evalString = "";
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            evalString = haystack.substring(i, i + needle.length());
            if (evalString.equals(needle)) return i;
        }

        return -1;
    }
    //** End of approach 3
}
