import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    //PROBLEM:
    //  You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
    //  The binary tree has the following definition:
//    struct Node {
//      int val;
//      Node *left;
//      Node *right;
//      Node *next;
//    }
    //Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
    //be set to NULL.
    //Initially, all next pointers are set to NULL.
    //Constraints:
    //  The number of nodes in the tree is in the range [0, 212 - 1].
    //  -1000 <= Node.val <= 1000
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(connect(a));
    }

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Queue] First, add root node and 'null' to Queue. And using BFS template, poll the element, if that element is null
    //then add it again else set its next to the new front element (using queue.peek()) and add its left and right children
    //to the queue. The trick to differentiate between elements of different levels is to add a null as the last element
    //for each level.
    //took 2 ms (47 percentile) and 39.3 MB (60.25 percentile)
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    static Queue<Node> q = new LinkedList<>();
    static public Node connect(Node root) {
        if(root == null) return null;

        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Node curr = q.poll();

                if(curr == null){
                    q.offer(null);
                } else{
                    curr.next = q.peek();
                    if(curr.left != null) q.offer(curr.left);
                    if(curr.right != null) q.offer(curr.right);
                }
            }
        }

        return root;
    }

    //  time complexity: O(n)
    //  space complexity: O(1)
    //[Iterative]
    //took 1 ms (61 percentile) and 44.5 MB (19 percentile)
    static public Node connect2(Node root){
        Node startNode = root;
        while(startNode != null){
            Node levelNode = startNode;
            while(levelNode != null){
                if(levelNode.left != null) levelNode.left.next = levelNode.right;
                if(levelNode.right != null && levelNode.next != null)
                    levelNode.right.next = levelNode.next.left;
                levelNode = levelNode.next;
            }
            startNode = startNode.left;
        }
        return root;
    }
}
