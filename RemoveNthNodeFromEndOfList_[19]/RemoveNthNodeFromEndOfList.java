package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class RemoveNthNodeFromEndOfList {

    //PROBLEM: Remove Nth Node From End of List
    //  Given the head of a linked list, remove the nth node from the end of the list and return its head
    //
    //Constraints:
    //  The number of nodes in the list is sz.
    //  1 <= sz <= 30
    //  0 <= Node.val <= 100
    //  1 <= n <= sz
    public static void main(String[] args) {

    }

    // Time complexity: O(L); L is length of the list
    // Space complexity: O(1)
    //took 0 ms (100 percentile) and 37 MB (50 percentile) (uses two passes, one to calculate size of the ll and other
    //to move to nth node and remove the nth node
    public ListNode removeNthFromEnd(ListNode head, int n){
        int size = 0;

        //calculate the size
        ListNode node = head;
        while(node != null){
            size++;
            node = node.next;
        }

        //traverse from the start till nth index
        int currIndex = 0;
        node = head;
        if(size - n - 1 < 0){
            head = head.next;
            return head;
        }
        while(currIndex < (size - n - 1)){
            currIndex++;
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }


    // Time complexity: O(L): L is length of the list
    // Space complexity: O(1)
    //took 0 ms (100 percentile) and 37.3 MB (24 percentile) (uses single pass with two pointers, slow and fast. The
    //pointer stays ahead of slow pointer by exactly n nodes
    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slowNode = dummyHead;
        ListNode fastNode = dummyHead;

        int counter = 0;
        while(counter <= n) {
            fastNode = fastNode.next;
            counter++;
        }

        while(fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;

        return dummyHead.next;
    }
}
