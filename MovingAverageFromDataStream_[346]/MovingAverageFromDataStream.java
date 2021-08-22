import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {

    //PROBLEM: Moving Average from Data Stream
    //  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
    //  Implement the MovingAverage class:
    //  MovingAverage(int size) Initializes the object with the size of the window size.
    //  double next(int val) Returns the moving average of the last size values of the stream.
    //Constraints:
    //  1 <= size <= 1000
    //  -105 <= val <= 105
    //  At most 104 calls will be made to next.

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1); // return 1.0 = 1 / 1
        movingAverage.next(10); // return 5.5 = (1 + 10) / 2
        movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
        movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
    }
}

// time complexity: O(n)
// space complexity: O(1)
//took 91 ms (84 percentile)
class MovingAverage {
    Queue<Integer> queue;
    int maxSize;
    double sum;
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        maxSize = size;
        sum = 0d;
    }

    public double next(int val) {
        if(queue.size() >= maxSize)
            sum -= queue.poll();
        queue.offer(val);
        sum += val;
        return (double)sum / queue.size();
    }
}

//class MovingAverage {
//    int[] elements;
//    int head;
//    int end;
//    int size;
//    double average;
//    /*
//     * @param size: An integer
//     */public MovingAverage(int size) {
//        elements = new int[size];
//        size = 0;
//        head = -1;
//        end = -1;
//        average = 0d;
//    }
//
//    /*
//     * @param val: An integer
//     * @return:
//     */
//    public double next(int val) {
//        if(head == -1){
//            head = 0;
//            end = 0;
//            elements[end] = val;
//            size += 1;
//            average = calAverage(elements, head, size);
//            return average;
//        } else if((end + 1) % elements.length == head){
//            elements[head] = val;
//            end = ((end + 1) % elements.length);
//            head = ((head + 1) % elements.length);
//            average = calAverage(elements, head, size);
//            return average;
//        } else{
//            end = ((end + 1) % elements.length) ;
//            elements[end] = val;
//            size += 1;
//            average = calAverage(elements, head, size);
//            return average;
//        }
//    }
//    private double calAverage(int[] arr, int start, int size){
//        int sum = 0;
//        int counter = 0;
//        int i = start;
//        while(counter < size){
//            sum += arr[i];
//            counter ++;
//            i = (i + 1) % size;
//        }
//        return (double) sum / size;
//    }
//}
