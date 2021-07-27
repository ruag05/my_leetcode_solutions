package com.company;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    //PROBLEM: Add Two Numbers
    //  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
    //  reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a
    //  linked list.
    //
    //  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    //
    //Constraints:
    //
    //  The number of nodes in each linked list is in the range [1, 100].
    //  0 <= Node.val <= 9
    //  It is guaranteed that the list represents a number that does not have leading zeros

    public static void main(String[] args) {

    }

    // time complexity: O(n + m)
    // space complexity: O(n + m)
    //took 1 ms (100 percentile) and 39.2 MB (78 percentile) (uses two pointers to iterate through both the lls.
    //Also, uses two additional pointers, one to keep track of final head & another to move this final head ahead)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headA = l1;
        ListNode headB = l2;

        ListNode head = new ListNode();
        ListNode currNode = head;

        ListNode newNode = null;
        int carry = 0;

        while(headA != null && headB != null){
            int sum = headA.val + headB.val + carry;
            if(sum > 9){
                sum %= 10;
                newNode = new ListNode(sum);
                carry = 1;
            } else{
                newNode = new ListNode(sum);
                carry = 0;
            }
            currNode.next = newNode;
            currNode = currNode.next;
            headA = headA.next;
            headB = headB.next;
        }

        while(headA != null){
            int sum = headA.val + carry;
            if(sum > 9){
                sum %= 10;
                newNode = new ListNode(sum);
                carry = 1;
            } else{
                newNode = new ListNode(sum);
                carry = 0;
            }
            currNode.next = newNode;
            currNode = currNode.next;
            headA = headA.next;
        }
        while(headB != null){
            int sum = headB.val + carry;
            if(sum > 9){
                sum %= 10;
                newNode = new ListNode(sum);
                carry = 1;
            } else{
                newNode = new ListNode(sum);
                carry = 0;
            }
            currNode.next = newNode;
            currNode = currNode.next;
            headB = headB.next;
        }
        if(carry == 1) {
            newNode = new ListNode(1);
            currNode.next = newNode;
        }
        return head.next;
    }
}
