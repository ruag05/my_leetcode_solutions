import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
}

// time complexity:
//          push: O(1)
//          pop: O(n)
// space complexity:
//          push: O(1)
//          pop: O(1)
//[2 Queue] Keep pushing the new values in first Queue and for popping, poll n - 1 values from first Queue and push to
//second queue.
//took 0 ms (100 percentile) and 38.8 MB (7 percentile)
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            top = q1.poll();
            q2.offer(top);
        }

        int res = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

// time complexity:
//          push: O(n)
//          pop: O(1)
// space complexity:
//          push: O(1)
//          pop: O(1)
//[1 Queue] Push the new value in the Queue and remove n - 1 values and re-add them. For popping, just remove the value
//from the Queue
//took 0 ms (100 percentile) and 37 MB (40 percentile)
class MyStack2 {

    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MyStack2() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while(size > 1){
            q.offer(q.poll());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}


