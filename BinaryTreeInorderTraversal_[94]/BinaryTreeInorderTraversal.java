import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
public class BinaryTreeInorderTraversal {

    //PROBLEM: Binary Tree Inorder Traversal
    //  Given the root of a binary tree, return the inorder traversal of its nodes' values.
    //Constraints:
    //  The number of nodes in the tree is in the range [0, 100].
    //  -100 <= Node.val <= 100
    public static void main(String[] args) {
        TreeNode1 nA = new TreeNode1(1);
        TreeNode1 nB = new TreeNode1(2);
        TreeNode1 nC = new TreeNode1(3);
        TreeNode1 nD = new TreeNode1(4);
        TreeNode1 nE = new TreeNode1(5);
        TreeNode1 nF = new TreeNode1(6);
        TreeNode1 nG = new TreeNode1(7);

        nA.left = nB;
        nA.right = nC;
        nB.left = nD;
        nB.right = nE;
        nC.left = nF;
        nC.right = nG;

        for(int num : inorderTraversal3(nA))
            System.out.println(num);
    }

    // time complexity: O(n)
    // space complexity: O(n) [including system call stack]
    //[Recursion] Start from the root node and since it is InOrder, do not add root node to result, instead go it to its
    //left child recursively and then add the current node. Finally, go to the right child recursively
    //took 0 ms (100 percentile) and 38.7 MB (20 percentile)
    public static List<Integer> inorderTraversal(TreeNode1 root){
        List<Integer> res = new ArrayList<>();
        if(root != null){
            inOrder(root, res);
        }

        return res;
    }
    public static void inOrder(TreeNode1 node, List<Integer> list){
        if(node != null){
            if(node.left != null) inOrder(node.left, list);
            list.add(node.val);
            if(node.right != null) inOrder(node.right, list);
        }
    }


    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Iteratively - Stack] Check if the current node is null/not.
    //              -If not, then push it onto stack (as we need to check for its left child first) and make left child
    //              as current node.
    //              -Else, if current node was null (it means that we crossed the leaf node) then pop the element, add it
    //              to result (as it will actually be the left child) and make its right child as the current node.
    //If at this point, there is a right child, then repeat the above steps (as it is a subtree) else pop the element (as
    //it was actually the right child and now we need to go one level up)
    //took 1 ms (14 percentile) and 38.8 MB (14 percentile)
    public static List<Integer> inorderTraversal2(TreeNode1 root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode1> stack = new Stack<>();

        TreeNode1 curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else{
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Morris Traversal] In this approach, if the left child of the current node exists then we find the rightmost node
    //in that left subtree and then make the current node as its right child. Also, we make the left child as the new
    //current node and also, make the left child of old current node to null (very important to actually do the displacement
    //without this step the nodes will only be copied, so it is important to remove the nodes from their previous place.
    //[it works as in this way as it is pass by reference])
    //took 0 ms (100 percentile) and 37.1 MB (77 percentile)
    public static List<Integer> inorderTraversal3(TreeNode1 root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        TreeNode1 curr = root;
        while(curr != null) {
            if (curr.left != null) {
                TreeNode1 left = curr.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = curr;

                TreeNode1 temp = curr;
                curr = curr.left;
                temp.left = null;
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }
