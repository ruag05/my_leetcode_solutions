package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class RotateList {

    //PROBLEM: Rotate List
    //  Given the head of a linked list, rotate the list to the right by k places.
    //
    //Constraints:
    //  The number of nodes in the list is in the range [0, 500].
    //  -100 <= Node.val <= 100
    //  0 <= k <= 2 * 109

    public static void main(String[] args) {

    }

    // time complexity: O(n)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 38.2 MB (76 percentile) (first calculates the length and leaves a pointer at the
    //last node. Again iterates the ll to reach the node just before the index from where to rotate and leave a pointer
    //there. Finally, make a ring from last node to head, change the head and break the ll from the index where to rotate

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;

        //calculate the size of the ll and store the last node of ll
        ListNode currNode = head;
        int length = 1;
        while(currNode.next != null){
            currNode = currNode.next;
            length++;
        }

        if(k > length)
            k %= length;

        if(length - k - 1 < 0){
            return head;
        }

        //find the last node just before the kth node (from end)
        ListNode node = head;
        int counter = 0;
        while(counter < length - k - 1){
            node = node.next;
            counter++;
        }

        //rotate the ll
        currNode.next = head;
        head = node.next;
        node.next = null;

        return head;
    }
}
