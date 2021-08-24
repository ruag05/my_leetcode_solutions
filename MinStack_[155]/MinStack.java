import java.util.Stack;
import java.util.List;
import java.util.Arrays;

class Main{

//PROBLEM: Min Stack
//  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//  Implement the MinStack class:
//  MinStack() initializes the stack object.
//  void push(val) pushes the element val onto the stack.
//  void pop() removes the element on the top of the stack.
//  int top() gets the top element of the stack.
//  int getMin() retrieves the minimum element in the stack.
//Constraints:
//  -231 <= val <= 231 - 1
//  Methods pop, top and getMin operations will always be called on non-empty stacks.
//  At most 3 * 104 calls will be made to push, pop, top, and getMin

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.getMin()); // return 2
    }
}

// time complexity: O(1)
// space complexity: O(n)
//[Two Stacks] One stack keeps track of the elements being pushed/popped. Other Stack keeps track of the min value and its
//frequency
//took 5 ms (56 percentile) and 40.7 MB (90 percentile)
class MinStack {

    Stack<Integer> stack;
    Stack<List<Integer>> minTracker;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minTracker = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minTracker.isEmpty()) minTracker.push(Arrays.asList(val, 1));
        else {
            List<Integer> top = minTracker.peek();
            int minVal = top.get(0);
            if (val == minVal) top.set(1, top.get(1) + 1);
            else if (val < minVal) minTracker.push(Arrays.asList(val, 1));
        }
    }

    public void pop() {
        int poppedVal = stack.pop();
        List<Integer> top = minTracker.peek();

        if(poppedVal == top.get(0)) {
            if (top.get(1) == 1) minTracker.pop();
            else {
                top.set(1, top.get(1) - 1);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!minTracker.isEmpty())
            return minTracker.peek().get(0);
        else return -1;
    }
}

// time complexity: O(1)
// space complexity: O(n)
//[Two Stacks] One stack keeps track of the elements being pushed/popped. Other Stack keeps track of the min value and if
//another element with same smallest value occurs, then push that onto stack
//took 4 ms (90 percentile) and 40.5 MB (71 percentile)
class MinStack2{
    Stack<Integer> stack;
    Stack<Integer> minTracker;

    /** initialize your data structure here. */
    public MinStack2() {
        stack = new Stack<>();
        minTracker = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minTracker.isEmpty()) minTracker.push(val);
        else{
            int top = minTracker.peek();
            if(val <= top) minTracker.push(val);
        }
    }

    public void pop() {
        int poppedVal = stack.pop();

        if(poppedVal == minTracker.peek()) minTracker.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minTracker.peek();
    }
}
