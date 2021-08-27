import java.util.Stack;

public class ImplementQueueWithStack {

    //PROBLEM: Implement Queue using Stacks
    //  Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
    //  functions of a normal queue (push, peek, pop, and empty).
    //Implement the MyQueue class:
    //void push(int x) Pushes element x to the back of the queue.
    //int pop() Removes the element from the front of the queue and returns it.
    //int peek() Returns the element at the front of the queue.
    //boolean empty() Returns true if the queue is empty, false otherwise.
    //Notes:
    //
    //You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is
    //empty operations are valid.
    //Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or
    //deque (double-ended queue) as long as you use only a stack's standard operations.
    //Constraints:
    //  1 <= x <= 9
    //  At most 100 calls will be made to push, pop, peek, and empty.
    //  All the calls to pop and peek are valid

    public static void main(String[] args) {

    }
}

// time complexity:
//              push: O(n)
//              pop: O(1)
//              peek: O(1)
// space complexity:
//              push: O(n)
//              pop: O(1)
//              peek: O(1)
//  [2 Stacks] Before pushing any new value, pop all values from first stack and push in second stack, then add new value
//  to second stack and finally, pop all values from second stack and push them in first stack. For popping, pop the value
//  from the first stack
//  took 0 ms (100 percentile) and 38.4 MB (8 percentile)
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack2.push(x);
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack1.isEmpty()){
            int res = stack1.pop();
            return res;
        } else return -1;
    }

    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

// time complexity:
//              push: O(1)
//              pop: Amortized O(1), Worst-case O(n)
//              peek: O(1)
// space complexity:
//              push: O(n)
//              pop: O(1)
//              peek: O(1)
//[2 stacks] Push all values in first stack and for popping, is second stack is empty pop values from first stack to it
//and then pop from the second stack. Else, pop from the second stack
//took 0 ms (100 percentile) and 37 MB (47 percentile)
class MyQueue1 {

    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;
    /** Initialize your data structure here. */
    public MyQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = -1;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()) front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s1.isEmpty() && s2.isEmpty()) return -1;

        if(s2.isEmpty())
            while(!s1.isEmpty()) s2.push(s1.pop());

        int res = s2.pop();
        if(!s2.empty()) front = s2.peek();
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}