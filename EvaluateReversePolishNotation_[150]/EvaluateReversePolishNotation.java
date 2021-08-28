import java.util.Stack;

public class EvaluateReversePolishNotation {

    //PROBLEM: Reverse Polish Notation
    //  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    //  Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
    //  Note that division between two integers should truncate toward zero.
    //  It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate
    //  to a result, and there will not be any division by zero operation.
    //Constraints:
    //  1 <= tokens.length <= 104
    //  tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN2(tokens));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack] If input string is an operator then pop two elements from stack and push the result. Otherwise, push the
    //string (convert to int) into Stack
    //took 6 ms (25 percentile) and 41.2 MB (12 percentile)
    public static int evalRPN(String[] tokens) {
        int top, secondTop;
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")) stack.push(stack.pop() + stack.pop());
            else if(s.equals("-")){
                top = stack.pop();
                secondTop = stack.pop();
                stack.push(secondTop - top);
            } else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(s.equals("/")){
                top = stack.pop();
                secondTop = stack.pop();
                stack.push(secondTop / top);
            } else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack] If input string is any of the operators then pop two elements from stack and push the result. Otherwise, push the
    //string (convert to int) into Stack
    //took 4 ms (91 percentile) and 38.8 MB (45 percentile)
    public static int evalRPN2(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        int top, secondTop, res = 0;
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                top = stack.pop();
                secondTop = stack.pop();
                switch (s) {
                    case "+":
                        res = top + secondTop;
                        break;
                    case "-":
                        res = secondTop - top;
                        break;
                    case "*":
                        res = top * secondTop;
                        break;
                    case "/":
                        res = secondTop / top;
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
