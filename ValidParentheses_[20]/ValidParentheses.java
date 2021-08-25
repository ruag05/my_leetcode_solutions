import java.util.Stack;

public class ValidParentheses {

    //PROBLEM: Valid Parentheses
    //  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //  An input string is valid if:
    //  Open brackets must be closed by the same type of brackets.
    //  Open brackets must be closed in the correct order.

    public static void main(String[] args) {

    }
    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack] Uses stack to place all the characters in the String and check if the new character is closing bracket of
    //the character at the top of the stack
    //took 1ms (99 percentile) and 36.9 MB (94 percentile)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch : chars){
            if(stack.isEmpty()) stack.push(ch);
            else{
                char top = stack.peek();
                stack.push(ch);
                if(ch == '}'){
                    if(top != '{') return false;
                    stack.pop();
                    stack.pop();
                }
                if(ch == ']'){
                    if(top != '[') return false;
                    stack.pop();
                    stack.pop();
                }
                if(ch == ')'){
                    if(top != '(') return false;
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
