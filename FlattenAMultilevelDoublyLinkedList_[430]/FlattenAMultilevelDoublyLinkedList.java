package com.company;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class FlattenAMultilevelDoublyLinkedList {

    //PROBLEM : Flatten a Multilevel Doubly Linked List
    //  You are given a doubly linked list which in addition to the next and previous pointers, it could have a child
    //  pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more
    //  children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
    //
    //  Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head
    //  of the first level of the list.

    // time complexity: O(n)
    // space complexity: O(n)
    //took 0 ms (100 percentile) and 37.1 MB (50 percentile)
    public static Node flatten(Node head) {
        Node currNode = head;
        Node nextNode;
        Node childNode;
        Node tail;

        //iterate through the base layer
        while(currNode != null){
            //store the next and child (if any) nodes of the current node
            nextNode = currNode.next;
            childNode = currNode.child;

            if(childNode != null){
                //as the current node has child, make child as the next of the current node
                //similarly, set prev of child to current node
                //also, as we have defined the next/prev fields, disconnect the parent and child
                currNode.next = childNode;
                childNode.prev = currNode;
                currNode.child = null;

                //find the last node in the sub-layer
                tail = childNode;
                while(tail.next != null)
                    tail = tail.next;

                //connect the last node in sub-layer to next node of current node
                if(nextNode != null){
                    tail.next = nextNode;
                    nextNode.prev = tail;
                }
            }
            //keep moving the current node until we reach the end
            currNode = currNode.next;
        }
        return head;
    }
}
