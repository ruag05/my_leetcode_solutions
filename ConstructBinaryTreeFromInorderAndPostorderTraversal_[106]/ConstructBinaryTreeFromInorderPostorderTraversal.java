import java.util.HashMap;

public class ConstructBinaryTreeFromInorderPostorderTraversal {

    //PROBLEM: Construct Binary Tree from Inorder and Postorder Traversal
    //  Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
    //  postorder is the postorder traversal of the same tree, construct and return the binary tree.
    //Constraints:
    //  1 <= inorder.length <= 3000
    //  postorder.length == inorder.length
    //  -3000 <= inorder[i], postorder[i] <= 3000
    //  inorder and postorder consist of unique values.
    //  Each value of postorder also appears in inorder.
    //  inorder is guaranteed to be the inorder traversal of the tree.
    //  postorder is guaranteed to be the postorder traversal of the tree
    public static void main(String[] args) {

    }

    //time complexity:
    //space complexity: O(n)
    //[Recursion - HashMap] From Postorder array, go to last element to find the root. Then, search this root in inorder
    //array, which will divide the inorder array into two, the elements on the left of this element in inorder array will
    //be on the left to the root in binary tree and elements on the right of this element in inorder array will be on the
    //right of the root in the binary tree. Since, Postorder traversal is LRP, the parent of right subtree will come up
    //before when going from right to left in postorder traversal. So, keep decrementing the index in postorder and search
    //that element in the inorder to split it into left and right.
    //and find that element in inorder.
    //took 2 ms (62 percentile) and 41.8 MB (15 percentile)
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int pIndex = -1;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int index = 0;
        for(int val : inorder){
            map.put(val, index++);
        }
        pIndex = postorder.length - 1;
        return helper(0, inorder.length - 1, inorder, postorder);
    }
    public static TreeNode helper(int start, int end, int[] inorder, int[] postorder){
        if(start > end || pIndex < 0) return null;

        TreeNode root = new TreeNode(postorder[pIndex]);

        int iIndex = map.get(root.val);
        pIndex--;

        root.right = helper(iIndex + 1, end, inorder, postorder);
        root.left = helper(start, iIndex - 1, inorder, postorder);

        return root;
    }
}
