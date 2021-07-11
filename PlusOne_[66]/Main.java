package com.company;

public class Main {

    //PROBLEM
    //  -Given a non-empty array of decimal digits representing a non-negative integer,
    //  increment one to the integer.
    //
    //  -The digits are stored such that the most significant digit is at the head of the list, and
    //  each element in the array contains a single digit.
    //
    //  -You may assume the integer does not contain any leading zero, except the number 0 itself.
    //
    //  -Constraints:
    //  1 <= digits.length <= 100
    //  0 <= digits[i] <= 9

    public static void main(String[] args) {
        int[] nums = new int[]{9,9,9};

        for(int num : plusOne3(nums)){
            System.out.print(num);
        }
    }

    //took 0 ms (100 percentile) and 38.8 MB (16 percentile) (brute force)
    public static int[] plusOne(int[] digits){
            int i = digits.length - 1;
                boolean carryOver = false;
                while(i >= 0) {
                    if(carryOver){
                        if(i == 0){
                            if(digits[i] == 9){
                                digits[i] = 0;
                                int[] extendedArr = new int[digits.length + 1];
                                System.arraycopy(digits,0, extendedArr, 1, digits.length);
                                extendedArr[i] ++;
                                return extendedArr;
                            } else{
                                digits[i]++;
                                return digits;
                            }
                        } else{
                            if (digits[i] == 9) {
                                digits[i] = 0;
                                i--;
                            } else {
                                digits[i] ++;
                                return digits;
                            }
                        }
                    } else{
                        if(i == 0){
                            if(digits[i] == 9){
                                digits[i] = 0;
                                int[] extendedArr = new int[digits.length + 1];
                                System.arraycopy(digits,0, extendedArr, 1, digits.length);
                                extendedArr[i] ++;
                                return extendedArr;
                            } else{
                                digits[i]++;
                                return digits;
                            }
                        } else{
                            if (digits[i] == 9) {
                                digits[i] = 0;
                                i--;
                                carryOver = true;
                            } else {
                                digits[i]++;
                                return digits;
                            }
                        }


                    }
                }

                return digits;
    }

    //took 0 ms (100 percentile) and 39.1 MB (8 percentile) (extra code removed)
    public static int[] plusOne2(int[] digits){
        for(int i = digits.length - 1; i >= 0; i--){
            if(i == 0){
                if(digits[i] == 9) {
                    digits[i] = 0;
                    int[] extendedArr = new int[digits.length + 1];
                    System.arraycopy(digits,0, extendedArr, 1, digits.length);
                    extendedArr[i] = 1;
                    return extendedArr;
                } else{
                    digits[i]++;
                    return digits;
                }
            } else if(i == digits.length - 1){
                if(digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            } else{
                if(digits[i] == 9){
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
        }

        return digits;
    }

    //took 0 ms (100 percentile) and 37.7 MB (38 percentile) (code optimized)
    public static int[] plusOne3(int[] digits){
        for(int i = digits.length - 1; i >= 0; i--){

            //if digit encountered is anything other than 9
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            //if digit encountered is 9
            digits[i] = 0;
        }

        //if all digits were 9 and we have crossed the most significant digit
        int[] extendedArr = new int[digits.length + 1];
        extendedArr[0] = 1;
        return extendedArr;
    }
}
