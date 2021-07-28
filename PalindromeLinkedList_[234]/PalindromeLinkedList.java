package com.company;

import java.util.List;
import java.util.ArrayList;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class PalindromeLinkedList {

    //PROBLEM : Palindrome Linked List
    //  Given the head of a singly linked list, return true if it is a palindrome.
    //
    //Constraints:
    //  The number of nodes in the list is in the range [1, 105].
    //  0 <= Node.val <= 9

    // time complexity: O(n)
    // space complexity: O(n)
    //took 7 ms (51 percentile) and 51.4 MB (51 percentile) (converts the list to array and then uses two pointers, one
    //from start and other from end, and compare whether they are equal or not)
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode currNode = head;
        while(currNode != null){
            list.add(currNode.val);
            currNode = currNode.next;
        }

        int start = 0;
        int end = list.size() - 1;
        while(start < end){
            if(!list.get(start).equals(list.get(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //took 5 ms (77 percentile) and 49 MB (82 percentile) (uses various pointers to, first calculate ll length, then
    //find middle element, then reverse the second half of ll and finally, compare the first half and second half)
    public boolean isPalindrome2(ListNode head){
        if(head.next == null) return true;

        //calculate length of the ll
        int length = 0;
        ListNode lastNode = head;
        while(lastNode != null){
            length++;
            lastNode = lastNode.next;
        }

        //move to middle element
        int counter = 0;
        ListNode midNode = head;
        while(counter < (length - 1) / 2) {
            midNode = midNode.next;
            counter++;
        }

        //reverse all the nodes after mid node
        ListNode currNode = midNode;
        ListNode startNode = currNode.next;
        ListNode nodeToSwap;
        while(startNode.next !=null) {
            nodeToSwap = startNode.next;
            startNode.next = nodeToSwap.next;
            nodeToSwap.next = midNode.next; //startNode
            midNode.next = nodeToSwap;

            currNode = currNode.next;
        }

        //compare whether the nodes from start and from mid, are equal/not
        ListNode nodeNextToMid = midNode.next;
        ListNode frontNode = head;
        while(frontNode.val == nodeNextToMid.val){
            frontNode = frontNode.next;
            nodeNextToMid = nodeNextToMid.next;
            if(frontNode == midNode.next || nodeNextToMid == null) return true;
        }
        return false;
    }
}
