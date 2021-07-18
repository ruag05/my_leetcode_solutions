package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rename_Words_in_a_String_III {

    //PROBLEM
    //  -Given a string s, reverse the order of characters in each word within a sentence while
    //   still preserving whitespace and initial word order.
    //
    // -Constraints:
    //      1 <= s.length <= 5 * 104
    //      s contains printable ASCII characters.
    //      s does not contain any leading or trailing spaces.
    //      There is at least one word in s.
    //      All the words in s are separated by a single space.

    public static void main(String[] args) {
        System.out.println(reverseWords2("God Ding"));
    }

    //took 7 ms(50 percentile) and 39.3 MB (86 percentile)
    public static String reverseWords(String s){
        StringBuilder sb = new StringBuilder(s);

        int i = 0, j = 0;
        StringBuilder sbInner;
        while(i < sb.length()){
            while(i < sb.length() && sb.charAt(i) != ' ')
                i++;
            sbInner = new StringBuilder(sb.substring(j, i)).reverse();
            sb.replace(j, i, sbInner.toString());
            i++;
            j = i;
        }

        return sb.toString();
    }

    //took 8 ms (45 percentile) and 39.8 MB (42 percentile)
    public static String reverseWords2(String s) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }

    //took 4 ms (82 percentile) and 39.8 MB (48 percentile)
    public static String reverseWords3(String s){
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words)
            sb.append(new StringBuilder(word).reverse().toString() + " ");

        return sb.toString().trim();
    }
}
