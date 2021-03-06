package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {

    //PROBLEM: Remove Linked List Elements
    //  Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
    //  Node.val == val, and return the new head
    //
    //Constraints:
    //  The number of nodes in the list is in the range [0, 104].
    //  1 <= Node.val <= 50
    //  0 <= val <= 50

    public static void main(String[] args) {

    }

    // time complexity: O(N)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 38.5 MB (84 percentile) (uses two pointers, one to keep track of the original
    //node and other to keep track of the new head i.e., the node to swap
    public static ListNode reverseList(ListNode head){
        if(head == null) return null;
        ListNode node = head;
        ListNode nodeToSwap = null;
        while(node.next != null){
            nodeToSwap = node.next;
            node.next = nodeToSwap.next;
            nodeToSwap.next = head;
            head = nodeToSwap;
        }

        return head;
    }
    
    // time complexity: O(N)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 39.4 MB (30 percentile)
    //[Recursion] Using recursion, move till the very last node and keep returning that so that the new head is the last node
    //Then, set the 'next' attribute of the next node of current head to point to head. Doing this will reverse the direction
    //of the list.
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
