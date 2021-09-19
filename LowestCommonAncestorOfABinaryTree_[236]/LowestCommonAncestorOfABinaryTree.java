import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    //PROBLEM: Lowest Common Ancestor Of A BinaryTree
    //  Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    //  According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
    //  as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    //Constraints:
    //  The number of nodes in the tree is in the range [2, 105].
    //  -109 <= Node.val <= 109
    //  All Node.val are unique.
    //  p != q
    //  p and q will exist in the tree.
    public static void main(String[] args) {

    }

    //  time complexity: O(n)
    //  space complexity: O(n) including the recursion stack
    //[Recursion] For each node, do left DFS and similarly do right DFS and see whether any of those left subtree or
    //right subtree contains any of p or q. If yes, make that subtree return true. And if any subtree returned true, then
    //using a variable for that subtree store 1, else store 0. Similarly, do the same for current node.
    //Finally, if for any node, the total value is >= 2 then that node is the answer. Otherwise, return whether the total
    //value is >= 1 or not
    //took 4 ms (100 percentile) and 41 MB (81 percentile)
    static TreeNode res = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)     {
        helper(root, p , q);
        return res;
    }
    public static boolean helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;

        int left = helper(node.left, p , q) ? 1 : 0;
        int right = helper(node.right, p , q) ? 1 : 0;
        int curr = (node == p || node == q) ? 1 : 0;

        if(left + right + curr >= 2) {
            res = node;
        }

        return (left + right + curr >= 1);
    }

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[Iterative] Iterate the tree using Stack and for each node, store the node and its parent in a HashMap. Then, for p (or q)
    //store all its ancestors and then for the other element q (or p) check if that element is present in the ancestors or not
    //if not then check for its parent whether that is present in the ancestors and continue till that reaches null
    //took 9 ms (33 percentile) and 39.1 MB (99.8 percentile)
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
        nodeParentMap.put(root, null);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr.left != null){
                nodeParentMap.put(curr.left, curr);
                stack.push(curr.left);
            }
            if(curr.right != null){
                nodeParentMap.put(curr.right, curr);
                stack.push(curr.right);
            }
        }

        List<TreeNode> ancestors = new ArrayList<>();
        while(p != null){
            ancestors.add(p);
            p = nodeParentMap.get(p);
        }
        while(!ancestors.contains(q)){
            q = nodeParentMap.get(q);
        }

        return q;
    }
}
