import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNodeII {

    //PROBLEM: Populating Next Right Pointers in Each Node II
    //  Given a binary tree
    //  struct Node {
    //      int val;
    //      Node *left;
    //      Node *right;
    //      Node *next;
    //  }
    //  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
    //  should be set to NULL.
    //  Initially, all next pointers are set to NULL.
    //Constraints:
    //  The number of nodes in the tree is in the range [0, 6000].
    //  -100 <= Node.val <= 100
    public static void main(String[] args) {

    }

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Queue] Place root node in Queue and then before adding each children in Queue, just check whether the element
    //polled was the last element of that level. If yes, then it's next pointer keep pointing null, otherwise set next of
    //that element to current front element in Queue.
    //took 2 ms (22 percentile) and 42.1 MB (18 percentile)
    public Node1 connect(Node1 root) {
        if(root == null) return null;

        Queue<Node1> q = new LinkedList<>();
        q.offer(root);

        Node1 curr;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                curr = q.poll();
                if(i != size - 1) curr.next = q.peek();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }

        return root;
    }

    //  time complexity: O(n)
    //  space complexity: O(1)
    //[
    //took 0 ms (100 percentile) and 41.8 MB (29 percentile)
    public Node1 connect2(Node1 root) {
        Node1 parent = root;
        Node1 childHead = null;
        Node1 child = null;

        while(parent != null){
            while(parent != null){
                if(parent.left != null){
                    if(childHead == null){
                        childHead = parent.left;
                    } else{
                        child.next = parent.left;
                    }
                    child = parent.left;
                }
                if(parent.right != null){
                    if(childHead == null){
                        childHead = parent.right;
                    } else{
                        child.next = parent.right;
                    }
                    child = parent.right;
                }
                parent = parent.next;
            }
            parent = childHead;
            childHead = child = null;
        }

        return root;
    }
}
