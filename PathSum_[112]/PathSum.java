public class PathSum {

    //PROBLEM: Path Sum
    //  Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
    //  such that adding up all the values along the path equals targetSum.
    //  A leaf is a node with no children.
    //Constraints:
    //  The number of nodes in the tree is in the range [0, 5000].
    //  -1000 <= Node.val <= 1000
    //  -1000 <= targetSum <= 1000

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.right = d;

        System.out.println(hasPathSum(a, 7));
    }

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[DFS - System Stack] We just start from root and check whether its value is equal to the target sum. If not,
    //we move to the left and right child and for each of them add their values to the current sum and keeps doing
    //until the leaf node is reached. If at leaf node the current sum is equal to target sum then return true else
    //return false
    //took 1 ms (21 percentile) and 40.8 MB (12 percentile)
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum) return true;

        return checkSum(root, 0, targetSum);
    }
    public static boolean checkSum(TreeNode node, int currSum, int targetSum){
        int newSum = currSum + node.val;
        if(node.left == null && node.right == null){
            if(newSum == targetSum) return true;
            else return false;
        }
        if(node.left != null)
            if(checkSum(node.left, newSum, targetSum)) return true;
        if(node.right != null)
            if(checkSum(node.right, newSum, targetSum)) return true;
        return false;
    }

    //  time complexity: O(n)
    //  space complexity: O(n)
    //[DFS - System Stack][Optimized] We just start from root and check whether its value is equal to the target sum. If not,
    //we move to the left and right child and for each of them add their values to the current sum and keeps doing
    //until the leaf node is reached. If at leaf node the current sum is equal to target sum then return true else
    //return false
    //took 0 ms (100 percentile) and 39 MB (45 percentile)
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return targetSum == root.val;

        return (hasPathSum2(root.left, targetSum - root.val) ||
                hasPathSum2(root.right, targetSum - root.val));
    }
}
