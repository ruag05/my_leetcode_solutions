import java.util.Stack;

public class CountUnivalueSubtrees {

    //PROBLEM: Count Univalue Subtrees
    //  Given the root of a binary tree, return the number of uni-value subtrees.
    //  A uni-value subtree means all nodes of the subtree have the same value.
    //Constraints:
    //  The numbrt of the node in the tree will be in the range [0, 1000].
    //  -1000 <= Node.val <= 1000
    public static void main(String[] args) {

    }

    //took 163 ms (lintcode: 75 percentile) and 13.52 MB
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return res;
        checkUni(root);
        return res;
    }
    public boolean checkUni(TreeNode node){
        if(node.left == null && node.right == null) {
            res++;
            return true;
        }
        boolean isUniVal = true;
        if(node.left != null)
            isUniVal = checkUni(node.left) &&
                    node.left.val == node.val
                    && isUniVal;
        if(node.right != null)
            isUniVal = checkUni(node.right) && isUniVal &&
                    node.right.val == node.val;

        if(!isUniVal) return false;
        res++;
        return isUniVal; //i.e, true
    }
}
