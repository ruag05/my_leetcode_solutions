package com.company;

import java.util.HashSet;
import java.util.Set;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedLists {

    //PROBLEM: Intersection of Two Linked Lists
    //  -Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    //  If the two linked lists have no intersection at all, return null.
    //
    //  -Constraints:
    //  The number of nodes of listA is in the m.
    //  The number of nodes of listB is in the n.
    //  0 <= m, n <= 3 * 104
    //  1 <= Node.val <= 105
    //  0 <= skipA <= m
    //  0 <= skipB <= n
    //  intersectVal is 0 if listA and listB do not intersect.
    //  intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.

    public static void main(String[] args) {

    }

    // Time complexity: O(N + M)
    // Space complexity: O(N + M)
    //took 9 ms (15 percentile) and 41.9 MB (59 percentile) (uses HashSet to detect once any node is encountered
    //twice
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visitedNodes = new HashSet<>();
        while(headA != null || headB != null){
            if(headA != null) {
                if (!visitedNodes.add(headA)) return headA;
                else headA = headA.next;
            }

            if(headB != null){
                if(!visitedNodes.add(headB)) return headB;
                else headB = headB.next;
            }
        }
        return null;
    }

    // Time complexity: O(N * M)
    // Space complexity: O(1)
    //took 812 ms (highly inefficient) and 41.7 MB (70 percentile) (brute force - check each node in second ll against
    //each node in first ll, and see if they match
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB ;
        while(nodeA != null) {
            nodeB = headB;
            while (nodeB != null) {
                if (nodeB == nodeA) return headA;
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
        }
        return null;
    }

    // Time complexity: O(N + M)
    // Space complexity: O(M)
    //took 6 ms (30 percentile) and 42.7 MB (30 percentile) (uses HashSet to add all nodes of one ll and then checks
    //for each node in other ll, if it is already present in HashSet
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        Set<ListNode> nodesInB = new HashSet<>();
        while(headB != null){
            nodesInB.add(headB);
            headB = headB.next;
        }
        while(headA != null){
            if(nodesInB.contains(headA)) return headA;
            headA = headA.next;
        }
        return null;
    }

    // Time complexity: O(N + M)
    // Space complexity: O(1)
    //took 1 ms (98 percentile) and 41.7 MB (69 percentile) (uses two pointers, to iterate the ll such that they both
    //start from the same location and traverse till the end
    public static ListNode getIntersectionNode4(ListNode headA, ListNode headB){
        int sizeA = 0;
        int sizeB = 0;

        //calculate size of first ll
        ListNode nodeA = headA;
        while(nodeA != null){
            sizeA++;
            nodeA = nodeA.next;
        }

        //calculate size of second ll
        ListNode nodeB = headB;
        while(nodeB != null){
            sizeB++;
            nodeB = nodeB.next;
        }

        //move to the node such that both ll are of same size from that node to end
        if(sizeA > sizeB){
            int i = 0;
            while(i < sizeA - sizeB){
                headA = headA.next;
                i++;
            }
        } else if(sizeB > sizeA){
            int i = 0;
            while(i < sizeB - sizeA){
                headB = headB.next;
                i++;
            }
        }

        //traverse both the ll together until they are equal or the end is reached
        while(headA != headB) {
            if(headA == null || headB == null) return null;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    // Time complexity: O(N + M)
    // Space complexity: O(1)
    //took 1 ms (98 percentile) and 41.5 MB (94 percentile)
    public static ListNode getIntersectionNode5(ListNode headA, ListNode headB){
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
