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

        for(int num : inorderTraversal4(nA))
            System.out.println(num);
    }

    // time complexity: O(n)
    // space complexity: O(n) (including call stack)
    //[Recursion]
    //took 1 ms (8 percentile) and 39.3 MB (7 percentile)
    static List<Integer> res;
    public static List<Integer> inorderTraversal(TreeNode1 root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root);
        return res;
    }
    public static void dfs(TreeNode1 node){
        if(node != null){
            TreeNode1 currNode = node;
            if(currNode.left != null) dfs(currNode.left);
            res.add(currNode.val);
            if(currNode.right != null) dfs(currNode.right);
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Iteratively - Stack]
    //took 1 ms (8 percentile) and 39.3 MB (7 percentile)
    public static List<Integer> inorderTraversal2(TreeNode1 root) {
        Stack<TreeNode1> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode1 currNode = root;
        while(currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            res.add(currNode.val);
            currNode = currNode.right;
        }

        return res;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Iteratively - Stack] Same as above just the implementation is more intuitive
    //took 1 ms (8 percentile) and 39.3 MB (7 percentile)
    public static List<Integer> inorderTraversal3(TreeNode1 root) {
        Stack<TreeNode1> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode1 currNode = root;
        while(currNode != null || !stack.isEmpty()) {
            if(currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                currNode = stack.pop();
                res.add(currNode.val);
                currNode = currNode.right;
            }
        }

        return res;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Morris Traversal] In this approach, if the left child to the current node exists then we find the rightmost node
    //in that left subtree and then make the current node as its right child. Also, we make the left child as the new
    //current node and also, make the left child of old current node to null (very important to actually do the displacement
    //without this step the nodes will only be copied, so it is important to remove the nodes from their previous place.[it
    //works as it is pass by reference])
    //took 0 ms (100 percentile) and 37.1 MB (77 percentile)
    public static List<Integer> inorderTraversal4(TreeNode1 root){
        List<Integer> res = new ArrayList<>();
        TreeNode1 currNode = root;
        TreeNode1 pre;
        while(currNode != null) {
            if (currNode.left == null) {
                res.add(currNode.val);
                currNode = currNode.right;
            } else {
                pre = currNode.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = currNode;
                TreeNode1 temp = currNode;
                currNode = currNode.left;
                temp.left = null;
            }
        }
        return res;
    }
}
