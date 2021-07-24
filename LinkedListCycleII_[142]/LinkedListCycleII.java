package com.company;

import java.util.Set;
import java.util.HashSet;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    //PROBLEM : Linked List Cycle II
    //  -Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //
    //  -There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    //  following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
    //  is connected to. Note that pos is not passed as a parameter.
    //
    //  -Notice that you should not modify the linked list.
    //
    //  -Constraints:
    //      The number of the nodes in the list is in the range [0, 104].
    //      -105 <= Node.val <= 105
    //      pos is -1 or a valid index in the linked-list

    public static void main(String[] args){

    }

    //took 0 ms (100 percentile) and 39.8 MB (79 percentile) (uses two pointers, slow and fast, to detect whether
    //at any point they're equal
    public boolean hasCycle(ListNode head){
        if(head == null) return false;

        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while(slowNode != fastNode){
            if(fastNode == null || fastNode.next == null) return false;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;
    }

    //took 4 ms (19 percentile) and 39 MB (99.7 percentile) (uses HashSet to keep track if we are tracking any node
    //twice)
    public boolean hasCycle2(ListNode head){
        if(head == null) return false;

        HashSet<ListNode> set = new HashSet<ListNode>();
        do{
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        } while(head != null);
        return false;
    }
}
