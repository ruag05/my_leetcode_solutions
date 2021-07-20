package com.company;

import java.util.Arrays;

public class URLify {

    //PROBLEM : URLify
    //  -Write a method to replace all spaces in a string with '%20'. You may assume that the string
    //  has sufficient space at the end to hold the additional characters, and that you are given the "true"
    //  length of the string. (Note: If implementing in Java, please use a character array so that you can
    //  perform this operation in place.)

    public static void main(String[] args) {
        String url = " Mr John Smith      ";
        System.out.println(urlify(url, 14));
    }
    static String urlify(String s, int actualLength){
        char[] chArr = s.toCharArray();
        int k = 0;

        for(int i = actualLength - 1; i >= 0; i--){
            char c = chArr[i];
            int endIndex = i;

            //reach the space after the previous word
            while(c != ' ') {
                i--;
                if(i < 0) return Arrays.toString(chArr);
                c = chArr[i];
            }

            //shift word to the rightmost available positions
            while(endIndex > i)
                chArr[chArr.length - 1 - k++] = chArr[endIndex--];

            //insert %20 in blank space formed in between by shifting the word
            chArr[chArr.length - 1 - k++] = '0';
            chArr[chArr.length - 1 - k++] = '2';
            chArr[chArr.length - 1 - k++] = '%';

        }
        return Arrays.toString(chArr);
    }
}
