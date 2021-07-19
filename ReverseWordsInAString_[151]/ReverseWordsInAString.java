package com.company;

import java.util.*;

public class ReverseWordsInAString {

    //PROBLEM - Reverse Words in a String
    //  -Given an input string s, reverse the order of the words.
    //
    //  -A word is defined as a sequence of non-space characters. The words in s will be separated by
    //  at least one space.
    //
    //  -Return a string of the words in reverse order concatenated by a single space.
    //
    //  -Note that s may contain leading or trailing spaces or multiple spaces between two words.
    //  The returned string should only have a single space separating the words. Do not include any extra spaces.
    //
    //  -Constraints:
    //  1 <= s.length <= 104
    //  s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    //  There is at least one word in s

    public static void main(String[] args){
        System.out.println(reverseWords("a good    example "));
    }

    //took 7 ms (56 percentile) and 39.2 MB (55 percentile)
    public static String reverseWords(String s){
        String[] words = Arrays.stream(s.split(" ")).filter(value ->
                value.length() > 0).toArray(size -> new String[size]);
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i > 0 ; i--)
            sb.append(words[i] + " ");
        sb.append(words[0]);

        return sb.toString();
    }

    // took 9 ms (36 percentile) and 39.7 MB (28 percentile)
    public static String reverseWords2(String s){
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    //took 5 ms (71 percentile) and 38.9 MB (81 percentile)
    public static String reverseWords3(String s){
        int i = 0, j = s.length() - 1;

        //remove leading spaces
        while(i < j && s.charAt(i) == ' ') i++;

        //remove trailing spaces
        while(j > i && s.charAt(j) == ' ') j--;

        Deque<String> res = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while(i <= j){

            //split words and add them to result
            char c = s.charAt(i);
            if (c != ' '){
                word.append(s.charAt(i));
            }
             else if(word.length() > 0 && c == ' '){
                 res.offerFirst(word.toString());
                 word.setLength(0);
            }
            i++;
        }

        //add last word
        res.offerFirst(word.toString());

        //merge words
        return String.join(" ", res);
    }
}
