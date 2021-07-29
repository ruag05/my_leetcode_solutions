package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class FindMiddleNode {

    //PROBLEM: Middle of the Linked List
    //  Given the head of a singly linked list, return the middle node of the linked list.
    //  If there are two middle nodes, return the second middle node.
    //
    //Constraints:
    //
    //  The number of nodes in the list is in the range [1, 100].
    //  1 <= Node.val <= 100

    // time complexity:O(n)
    // space complexity: O(1)
    //uses slow and fast pointer to find the middle node (returns second middle node, in case of even length)
    public ListNode findMiddleNode(ListNode head){
        if(head == null) return null;

        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }

    // time complexity:O(n)
    // space complexity: O(1)
    //uses slow and fast pointer to find the middle node (returns first middle node, in case of even length)
    public ListNode findMiddleNode2(ListNode head){
        if(head == null) return null;

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }
}
