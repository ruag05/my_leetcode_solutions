public class SymmetricTree {

    //PROBLEM: Symmetric Tree
    //  Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    //Constraints:
    //  The number of nodes in the tree is in the range [1, 1000].
    //  -100 <= Node.val <= 100
    public static void main(String[] args) {

    }

    // time complexity: O(n)
    // space complexity: O(n)
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
}
