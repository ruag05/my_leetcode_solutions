package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class DeleteNodeInALinkedList {

    //PROBLEM: Delete Node in a Linked List
    //  Write a function to delete a node in a singly-linked list. You will not be given access to the head of
    //  the list, instead you will be given access to the node to be deleted directly.
    //
    //  It is guaranteed that the node to be deleted is not a tail node in the list.
    //
    //Constraints:
    //  The number of the nodes in the given list is in the range [2, 1000].
    //  -1000 <= Node.val <= 1000
    //  The value of each node in the list is unique.
    //  The node to be deleted is in the list and is not a tail node

    // time complexity: O(1)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 38.5 MB (38 percentile) (replaces current node value with next node value and
    //bypasses next node by connect current node to next of next node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
