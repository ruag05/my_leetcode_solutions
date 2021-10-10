public class SwapNodesInPairs {
    //PROBLEM
    //Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
    // modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode n = head.next;
        head.next = swapPairs(n.next);
        n.next = head;

        return n;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
