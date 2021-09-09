import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    //PROBLEM: Binary Tree Level Order Traversal
    //  Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to
    //  right, level by level).
    //Constraints:
    //  The number of nodes in the tree is in the range [0, 2000].
    //  -1000 <= Node.val <= 1000

    public static void main(){

    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[BFS - Queue] Following the BFS template, push the root into queue then poll it and check the current size of the
    //queue. Then, re-initialize a List (for levels) and start a for loop where for each element in the queue, poll it
    //and add it to the level list. Then, once the loop ends add that list to the result list
    //took 0 ms (100 percentile) and 39.2 MB (58 percentile)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        List<Integer> levelList;
        while(!q.isEmpty()){
            int size = q.size();
            levelList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                levelList.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            res.add(levelList);
        }

        return res;
    }
}
