import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {

    //PROBLEM: Symmetric Tree
    //  Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    //Constraints:
    //  The number of nodes in the tree is in the range [1, 1000].
    //  -100 <= Node.val <= 100
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = null;
        b.right = d;
        c.left = null;
        c.right = e;

        System.out.println(isSymmetric2(a));
    }

    //Recursive Approach

    // time complexity: O(n)
    // space complexity: O(n) ([including system stack]
    //[BFS - System Stack] Go level by level, that is check that all the nodes at the current level are symmetric. Only
    //if they are symmetric then go to next level
    //took 0 ms (100 percentile) and 39 MB (21 percentile)
    public static boolean isSymmetric(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return true;

        return goDeep(root.left, root.right);
    }
    public static boolean goDeep(TreeNode nodeLeft, TreeNode nodeRight){
        if(nodeLeft == null && nodeRight == null) return true;
        else if((nodeLeft != null && nodeRight == null) ||
                (nodeLeft == null && nodeRight != null) ||
                (nodeLeft.val != nodeRight.val)) return false;
        else
            return (goDeep(nodeLeft.left, nodeRight.right) && goDeep(nodeLeft.right, nodeRight.left));
    }

    //Iterative Approach

    //  time complexity: O(n)
    //  space complexity: O(n) [because of Queue]
    //[BFS - Queue] Go level by level by adding left and right child of current node into queue. Then pop the top 2 nodes
    //and check whether they are symmetric or not. If yes, only then add their children to queue in PROPER ORDER.
    //took 2 ms (5 percentile) and 39. 1 MB (15 percentile)
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;
    }
}
