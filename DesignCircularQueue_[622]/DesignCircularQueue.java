public class DesignCircularQueue {

    //PROBLEM: Design Circular Queue
    //  Design your implementation of the circular queue. The circular queue is a linear data structure in which the
    //  operations are performed based on FIFO (First In First Out) principle and the last position is connected back to
    //  the first position to make a circle. It is also called "Ring Buffer".
    //
    //  One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a
    //  normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front
    //  of the queue. But using the circular queue, we can use the space to store new values.
    //
    //  Implementation the MyCircularQueue class:
    //
    //  MyCircularQueue(k) Initializes the object with the size of the queue to be k.
    //  int Front() Gets the front item from the queue. If the queue is empty, return -1.
    //  int Rear() Gets the last item from the queue. If the queue is empty, return -1.
    //  boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
    //  boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
    //  boolean isEmpty() Checks whether the circular queue is empty or not.
    //  boolean isFull() Checks whether the circular queue is full or not.
    //  You must solve the problem without using the built-in queue data structure in your programming language.
    //Constraints:
    //
    //  1 <= k <= 1000
    //  0 <= value <= 1000
    //  At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}
// time complexity: O(n)
// space complexity: O(n)
// took 4 ms (97 percentile) and 39.3 MB (83 percentile)
class MyCircularQueue {
    int[] elements;
    int head, end;

    public MyCircularQueue(int k) {
        elements = new int[k];
        head = -1;
        end = -1;
    }

    public boolean enQueue(int value) {
        if(head == -1){
            head = 0;
            end = 0;
            elements[end] = value;
            return true;
        } else if((end + 1) % elements.length != head){
            end = (end + 1) % elements.length;
            elements[end] = value;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(head == -1) return false;
        if(head == end) {
            head = -1;
            end = -1;
            return true;
        } else{
            head = (head + 1) % elements.length;
            return true;
        }
    }

    public int Front() {
        return head != -1 ? elements[head] : -1;
    }

    public int Rear() {
        return end != -1 ? elements[end] : -1;
    }

    public boolean isEmpty() {
        return head == -1 ? true : false;
    }

    public boolean isFull() {
        return (head == (end + 1) % elements.length) ? true : false;
    }
}

