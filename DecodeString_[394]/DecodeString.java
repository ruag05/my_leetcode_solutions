import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DecodeString {

    //PROBLEM: Decode String
    //  Given an encoded string, return its decoded string.
    //  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
    //  exactly k times. Note that k is guaranteed to be a positive integer.
    //  You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
    //  Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
    //  repeat numbers, k. For example, there won't be input like 3a or 2[4].
    //Constraints:
    //  1 <= s.length <= 30
    //  s consists of lowercase English letters, digits, and square brackets '[]'.
    //  s is guaranteed to be a valid input.
    //  All the integers in s are in the range [1, 300].
    public static void main(String[] args) {
        System.out.println(decodeString2("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[StringBuilder and Stack]Keeping pushing the characters until ] is encountered. Once ] is seen, keep popping until [ is found, this
    //    //will be the string to repeat. Then, pop the [ and again start popping all digits, they will be the value of 'k'.
    //    //Then, evaluate the decodeString and push that back to the stack and keep doing so until the input string is over.
    //took 2 ms (42 percentile) and 38.9 MB (15 percentile)
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int size = s.length();
        for(int i = 0; i < size; i++){
            char ch = s.charAt(i);
            if(ch == ']'){

                //fetch string to repeat and save it
                sb = new StringBuilder();
                while(!stack.isEmpty() && !Character.isDigit(stack.peek()) && stack.peek() != '[')
                    sb.append(stack.pop());
                String strToRep = sb.reverse().toString();

                //pop the '['
                stack.pop();

                //fetch the number for how many times to repeat the string and save that
                sb.setLength(0);
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.append(stack.pop());
                int timesToRep = Integer.parseInt(sb.reverse().toString());

                //perform the repetition of the string
                sb.setLength(0);
                while(timesToRep > 0){
                    sb.append(strToRep);
                    timesToRep --;
                }

                //push the repeated string as characters back into the stack
                String str = sb.toString();
                for(int j = 0; j < str.length(); j++)
                    stack.push(str.charAt(j));
            } else
                stack.push(ch);
        }

        sb.setLength(0);
        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack][Optimized code that above] Keeping pushing the characters until ] is encountered. Once ] is seen, keep popping until [ is found, this
    //will be the string to repeat. Then, pop the [ and again start popping all digits, they will be the value of 'k'.
    //Then, evaluate the decodeString and push that back to the stack and keep doing so until the input string is over.
    //took 1 ms (63 percentile) and 36.9 MB (83 percentile)
    public static String decodeString2(String s){
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for(int i = 0; i < size; i++){
            char ch = s.charAt(i);
            if(ch == ']') {
                List<Character> decodedString = new ArrayList<>();
                while(stack.peek() != '[')
                    decodedString.add(stack.pop());

                stack.pop();

                int k = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                while(k > 0){
                    for(int j = decodedString.size() - 1; j >= 0; j--)
                        stack.push(decodedString.get(j));
                    k --;
                }
            } else{
                stack.push(ch);
            }
        }
        char[] res = new char[stack.size()];
        for(int i = res.length - 1; i >=0; i--){
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
