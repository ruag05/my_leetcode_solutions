import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    //PROBLEM: Happy Number
    //  Write an algorithm to determine if a number n is happy.
    //  A happy number is a number defined by the following process:
    //  Starting with any positive integer, replace the number by the sum of the squares of its digits.
    //  Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does
    //  not include 1.
    //  Those numbers for which this process ends in 1 are happy.
    //  Return true if n is a happy number, and false if not.
    //Constraints:
    //  1 <= n <= 231 - 1

    public static void main(String[] args){
        int n = 19;
        System.out.println(isHappy(n));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashSet] If a number is not happy, then it will have loop i.e., at some point some number will start repeating.
    //So, if we use set then it's add method will return false as soon as a value is encountered twice.
    //took 1 ms (80 percentile) and 36.1 MB (53 percentile)
    public static boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>();
        int sum;
        while(n != 1){
            int current = n;
            sum = 0;
            while(current != 0) {
                sum += (current % 10) * (current % 10);
                current /= 10;
            }
            if(!seen.add(sum)) return false;
            n = sum;
        }
        return true;
    }


    // time complexity: O(n)
    // space complexity: O(1)
    //[fast slow pointer] Take two pointers where one pointer moves twice the speed of the other one, so that if there
    //is a loop then slow and fast pointer will become same at some point.
    //took 0 ms (100 percentile) and 36 MB (67 percentile)
    public static boolean isHappy2(int n){
        if(n == 1) return true;
        int slow = n;
        int fast = n;
        do{
            slow = digitSquare(slow);
            fast = digitSquare(fast);
            fast = digitSquare(fast);
            if(slow == 1 || fast == 1) return true;
        } while(slow != fast);
        return false;
    }
    public static int digitSquare(int n){
        int sum = 0;
        while(n >= 1){
            sum += (n % 10)*(n % 10);
            n /= 10;
        }
        return sum;
    }
}
