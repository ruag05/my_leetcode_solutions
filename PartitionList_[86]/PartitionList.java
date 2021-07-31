package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class PartitionList {

    //PROBLEM:
    //  Given the head of a linked list and a value x, partition it such that all nodes less than x come before
    //  nodes greater than or equal to x.
    //
    //  You should preserve the original relative order of the nodes in each of the two partitions.
    //Constraints:
    //  The number of nodes in the list is in the range [0, 200].
    //  -100 <= Node.val <= 100
    //  -200 <= x <= 200

    // time complexity: O(n)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 38.2 MB (78 percentile) (uses two pointers to point to head of shorter nodes and
    //head of larger nodes. Also, using two more pointers, link the shorter/larger nodes to short/large node
    public static ListNode partition2(ListNode head, int x){
        if(head == null) return null;

        ListNode leftHead = new ListNode();
        ListNode leftCurr = leftHead;
        ListNode rightHead = new ListNode();
        ListNode rightCurr = rightHead;

        ListNode currNode = head;
        while(currNode != null){
            if(currNode.val < x){
                leftCurr.next = currNode;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = currNode;
                rightCurr = rightCurr.next;
            }
            currNode = currNode.next;
        }

        leftCurr.next = rightHead.next;
        rightCurr.next = null;

        return leftHead.next;
    }
}
