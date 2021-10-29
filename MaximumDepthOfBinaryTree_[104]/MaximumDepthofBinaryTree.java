import java.util.Queue;
import java.util.LinkedList;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {

    }

    //Top Down solutions

    // time complexity: O(n)
    // space complexity: O(n) [taking system stack]
    //[DFS - System stack] Process the root node and pass it to a DFS method, along with the current + 1 level. Then,
    //process that current node and if that node is leaf node, return the max of result and current depth, otherwise
    //pass in the left child to the recursive method and then pass in the right child to the recursive method, meanwhile
    //keep updating the result with the values these method return
    //took 0 ms (100 percentile) and 39 MB (57 percentile)
    public static int maxDepth(TreeNode root){
        if(root == null) return 0;

        return maxDepthRec(root, 0, 1);
    }
    public static int maxDepthRec(TreeNode curr, int res, int depth){
        if(curr != null){
            if(curr.left == null && curr.right == null) res = Math.max(res, depth);
            if(curr.left != null) res = maxDepthRec(curr.left, res, depth + 1);
            if(curr.right != null) res = maxDepthRec(curr.right, res,depth + 1);
        }
        return res;
    }

    // time complexity: O(n)
    // space complexity: O(n) [taking system stack]
    //[DFS - System stack] Process the root node and pass it to a DFS method, along with the current depth + 1. Also, make
    //result variable global so that we can update it for the DFS method without returning anything. Then, process the
    //current node in the DFS method and if that node is leaf node, then update the value of result to max of result and
    //current depth else, call the DFS method for its left child and right child
    //took 0 ms (100 percentile) and 39 MB (57 percentile)
    public static int maxDepth2(TreeNode root){
        if(root == null) return 0;

        return maxDepthRec2(root, 1);
    }
    static int result = 0;
    public static int maxDepthRec2(TreeNode curr, int depth){
        if(curr != null){
            if(curr.left == null && curr.right == null) result = Math.max(result, depth);
            if(curr.left != null) maxDepthRec2(curr.left, depth + 1);
            if(curr.right != null) maxDepthRec2(curr.right, depth + 1);
        }
        return result;
    }

    // time complexity: O(n)
    // space complexity: O(n) [taking system stack]
    //[DFS - System Stack] Add onto the system stack only non-null elements. At each level, update the result to the max
    //of current depth and the current result value
    //took 1 ms (16.5 percentile) and 40.5 MB (9 percentile)
    static int res;
    public static int maxDepth3(TreeNode root) {
        res = 0;
        if(root == null) return res;
        goDeep(root, 1);
        return res;

    }
    public static void goDeep(TreeNode node, int depth){
        res = Math.max(res, depth);
        if(node.left != null) goDeep(node.left, depth + 1);
        if(node.right != null) goDeep(node.right, depth + 1);
    }

    // time complexity: O(n)
    // space complexity: O(n) [taking system stack]
    //[DFS - System Stack] Add onto the system stack only non-null elements. Only at the leaf node level, update the
    //result to the max of current depth and the current result value
    //took 1 ms (16.5 percentile) and 40.5 MB (9 percentile)
    int res2;
    public int maxDepth4(TreeNode root) {
        res2 = 0;
        if(root == null) return res2;

        goDeep2(root, 1);

        return res2;

    }
    public void goDeep2(TreeNode node, int depth){
        if(node.left == null && node.right == null) res2 = Math.max(res, depth);
        if(node.left != null) goDeep2(node.left, depth + 1);
        if(node.right != null) goDeep2(node.right, depth + 1);
    }

    //Bottom- up solution

    //  time complexity: O(n)
    //  space complexity: O(n) [taking system stack]
    //[DFS - System Stack] For each node, go deep into its left and right child until the leaf is reached. For leaf, return
    //0, otherwise return, max of value returned from left subtree and right subtree, plus 1.
    //took 0 ms (100 percentile) and 40.4 MB (13 percentile)
    public int maxDepth5(TreeNode root) {
        int res = 0;
        if(root == null) return res;

        return goDeep3(root);
    }
    public int goDeep3(TreeNode node){
        if(node == null) return 0;
        int leftMax = goDeep3(node.left);
        int rightMax = goDeep3(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }
    
    //  time complexity: O(n)
    //  space complexity: O(n) [taking system stack]
    //[DFS - System Stack] For each node, go deep into its left and right child until the leaf is reached. For leaf, return
    //0, otherwise return, max of value returned from left subtree and right subtree, plus 1 (for the distance of current root to root.left / root.right).
    //took 0 ms (100 percentile) and 39 MB (61 percentile)
    public int maxDepth6(TreeNode root) {
        if(root == null) return 0;  
      
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));     
    } 
}
