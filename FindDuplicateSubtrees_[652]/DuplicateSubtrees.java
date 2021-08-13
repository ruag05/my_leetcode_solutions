import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class DuplicateSubtrees {
    static String NT = "#";
    static Set<String> visited = new HashSet<>();
    static Map<String, TreeNode> res = new HashMap<>();
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n2Dup = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n4Dup1 = new TreeNode(4);
        TreeNode n4Dup2 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n2Dup;
        n3.right = n4Dup2;
        n2Dup.left = n4Dup1;

        for(TreeNode node : findDuplicateSubtrees(n1))
            System.out.println(node.val);
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap and HashSet] Use a HashSet to store the path travelled in postorder traversal from bottom to top and see,
    //if we have encountered the same path earlier. If yes, add it to map with key as that path and the node as value
    //took 34 ms (14 percentile) and 69 MB
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraversal(root);
        return new LinkedList<>(res.values());
    }
    public static String postOrderTraversal(TreeNode node){
        StringBuilder sb = new StringBuilder();
        String leftSubTree = NT, rightSubTree = NT;

        if(node.left != null) leftSubTree = postOrderTraversal(node.left);
        if(node.right != null) rightSubTree = postOrderTraversal(node.right);

        sb.append(node.val);

        sb.append(",");
        sb.append(leftSubTree);
        sb.append(",");
        sb.append(rightSubTree);

        if(visited.contains(sb.toString())) res.put(sb.toString(), node);
        visited.add(sb.toString());
        return sb.toString();
    }
}
