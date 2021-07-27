package com.company;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLists {

    //PROBLEM:
    //  Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing
    //  together the nodes of the first two lists.
    //
    //Constraints:
    //  The number of nodes in both lists is in the range [0, 50].
    //  -100 <= Node.val <= 100
    //  Both l1 and l2 are sorted in non-decreasing order

    public static void main(String[] args) {

    }

    // time complexity: O(N + M)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 38.1 MB (93 percentile) (uses two pointers to iterate through both the lls.
    //Also, uses two additional pointers, one to keep track of final head & another to move this final head ahead
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1 == null && l2 == null) return null;

        ListNode headA = l1;
        ListNode headB = l2;
        ListNode head = new ListNode();
        ListNode current = head;

        while(headA != null && headB !=null){
            if(headA.val < headB.val){
                current.next = headA;
                current = current.next;
                headA = headA.next;
            } else if(headB.val < headA.val){
                current.next = headB;
                current = current.next;
                headB = headB.next;
            } else{
                current.next = headA;
                current = current.next;
                headA = headA.next;
                current.next = headB;
                current = current.next;
                headB = headB.next;
            }
        }
        while(headA != null){
            current.next = headA;
            current = current.next;
            headA = headA.next;
        }
        while(headB != null){
            current.next = headB;
            current = current.next;
            headB = headB.next;
        }
        return head.next;
    }
}
