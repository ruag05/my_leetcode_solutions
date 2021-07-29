package com.company;

 * public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class RemoveDuplicatesFromSortedList {

     //PROBLEM : Remove Duplicates from Sorted List
     // Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     // Return the linked list sorted as well.
     //
     //Constraints:
     // The number of nodes in the list is in the range [0, 300].
     // -100 <= Node.val <= 100
     // The list is guaranteed to be sorted in ascending order.

    // time complexity: O(n)
    // space complexity: O(1)
    //took 0 ms (100 percentile) and 38.5 MB (62 percentile) (uses slow and fast pointers, to iterate and compare
    //whether the value at fast node equals the value at slow node)
    public ListNode deleteDuplicates(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while(fastNode != null){
            if(slowNode.val != fastNode.val) {
                slowNode.next = fastNode;
                slowNode = slowNode.next;
            }
            fastNode = fastNode.next;
        }
        if(slowNode.next != null)
            slowNode.next = null;
        return head;
    }
}
