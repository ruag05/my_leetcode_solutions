package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class RemoveLinkedListElements {

    //PROBLEM: Remove Linked List Elements
    //  Given the head of a linked list and an integer val, remove all the nodes of the linked list that
    //  as Node.val == val, and return the new head.
    //
    //Constraints:
    //  The number of nodes in the list is in the range [0, 104].
    //  1 <= Node.val <= 50
    //  0 <= val <= 50

    public static void main(String[] args) {
    }

    // time complexity: O(N)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 39.7 MB (84 percentile) (uses two pointers, one to move forward checking if
    //the value equals target value and other, to store the latest node to keep in ll
    public static ListNode removeElements(ListNode head, int val){
        if(head == null) return head;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null){
            if(fastNode.val != val){
                slowNode = fastNode;
                fastNode = fastNode.next;
            } else{
                //till the node val equals target val, keep moving further
                do{
                    fastNode = fastNode.next;
                } while(fastNode != null && fastNode.val == val);
                slowNode.next = fastNode;
            }
        }
        if(head.val == val)
            head= head.next;
        return head;
    }

    // time complexity: O(N)
    // space complexity: O(1)
    //took 1 ms (74 percentile) and 40.5 MB (22 percentile) (uses recursive algorithm to return either the current node
    //or next node depending on whether the node value does not match or matches the target value to remove
    public static ListNode removeElements2(ListNode head, int val){
        if(head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
