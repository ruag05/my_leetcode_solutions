import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //PROBLEM: Construct Binary Tree from Preorder and Inorder Traversal
    //  Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and
    //  inorder is the inorder traversal of the same tree, construct and return the binary tree.
    //Constraints:
    //  1 <= preorder.length <= 3000
    //  inorder.length == preorder.length
    //  -3000 <= preorder[i], inorder[i] <= 3000
    //  preorder and inorder consist of unique values.
    //  Each value of inorder also appears in preorder.
    //  preorder is guaranteed to be the preorder traversal of the tree.
    //  inorder is guaranteed to be the inorder traversal of the tree

    public static void main(String[] args) {

    }

    //time complexity: O(n)
    //space complexity: O(n)
    //[Recursion - HashMap] From Preorder array, go to first element to find the root. Then, search this root in inorder
    //array, which will divide the inorder array into two, the elements on the left of this element in inorder array will
    //be on the left to the root in binary tree and elements on the right of this element in inorder array will be on the
    //right of the root in the binary tree. Since, Preorder traversal is PLR, the parent of left subtree will come up
    //before when going from left to right in preorder traversal. So, keep incrementing the index in preorder and search
    //that element in the inorder to split it into left and right
    //took 2 ms (64 percentile) and 42.1 MB (10 percentile)
    HashMap<Integer, Integer> map = new HashMap<>();
    int pIndex = -1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index = 0;
        for(int val : inorder){
            map.put(val, index++);
        }

        pIndex = 0;
        return helper(0, inorder.length - 1, inorder, preorder);
    }
    public TreeNode helper(int start, int end, int[] inorder, int[] preorder){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[pIndex]);
        int iIndex = map.get(root.val);
        pIndex ++;

        root.left = helper(start, iIndex - 1, inorder, preorder);
        root.right = helper(iIndex + 1, end, inorder, preorder);

        return root;
    }
}
