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
    //twice
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
