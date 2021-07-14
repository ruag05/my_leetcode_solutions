package com.company;

public class Main {

    //PROBLEM
    //  -Given two binary strings a and b, return their sum as a binary string
    //
    //  -Constraints:
    //
    //  1 <= a.length, b.length <= 104
    //  a and b consist only of '0' or '1' characters
    //  Each string does not contain leading zeros except for the zero itself

    public static void main(String[] args) {
        System.out.println(get("11", "1"));
    }

    //took 1 ms (100 percentile) and 38.9 MB (57 percentile)
    public static String get(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            //if there is a carry from the last addition, add it to carry
            int sum = carry;

            //subtract '0' to get the int value of the char from the ascii
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';

            //if sum == 2 or sum == 0 append 0 cause 1 + 1 = 0 in this case as this is base 2
            //(just like 1 + 9 is 0 if adding ints in columns)
            sb.append(sum % 2);

            //if sum == 2 we have a carry
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }
}
