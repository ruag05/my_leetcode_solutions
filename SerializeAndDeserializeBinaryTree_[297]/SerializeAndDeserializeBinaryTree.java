import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    //PROBLEM: Serialize and Deserialize Binary Tree
    //  Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
    //  stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
    //  the same or another computer environment.
    //
    //  Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/
    //  deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string
    //  and this string can be deserialized to the original tree structure.
    //
    //  Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not
    //  necessarily need to follow this format, so please be creative and come up with different approaches yourself.
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = null;
        TreeNode e = null;
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left= d;
        b.right = e;
        c.left = f;
        c.right = g;

        Codec1 ser = new Codec1();
        Codec1 deser = new Codec1();
        TreeNode ans = deser.deserialize(ser.serialize(a));
    }
}

//  time complexity: O(n)
//  space complexity: O(n)
//Uses Queue - BFS  for serialization (with some variables for not considering the extra null elements) and recursion for
//deserialization
//took 115 ms (7 percentile) and 42.2 MB (38 percentile)
class Codec {

    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode lastNotNullInQ = root;
        TreeNode lastNotNullPopped = null;
        TreeNode curr = root;
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            curr = q.poll();

            if(curr != null) {
                lastNotNullPopped = curr;

                if(curr.left != null) lastNotNullInQ = curr.left;
                q.offer(curr.left);

                if(curr.right != null) lastNotNullInQ = curr.right;
                q.offer(curr.right);

                sb.append(curr.val);
            } else sb.append("null");
            sb.append(",");

            if(lastNotNullInQ == lastNotNullPopped) break;
        }

        return sb.toString();

        //Unoptimized approach
        /* Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            if(curr != null) {
                q.offer(curr.left);
                q.offer(curr.right);
                sb.append(curr.val);
            } else sb.append("null");
        }
        return sb.toString(); */
    }
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        helper(root, 0, 1, arr, nodes);

        return root;
    }
    public void helper(TreeNode parent, int parentIndex, int startIndex, String[] arr, List<TreeNode> nodes){
        int n = arr.length;
        if(startIndex > n - 1) return;

        if(startIndex <= n - 1) {
            if(isNumeric(arr[startIndex])) {
                parent.left = new
                        TreeNode(Integer.parseInt(arr[startIndex]));
                nodes.add(parent.left);
            }
        }

        if(startIndex + 1 <= n - 1) {
            if (isNumeric(arr[startIndex + 1])) {
                parent.right = new
                        TreeNode(Integer.parseInt(arr[startIndex + 1]));
                nodes.add(parent.right);
            }
        }

        helper(nodes.get(parentIndex + 1),parentIndex + 1, startIndex + 2, arr, nodes);
    }
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

//  time complexity: O(n)
//  space complexity: O(n)
//Uses preorder traversal with recursion for serialization and Queue with recursion for deserialization
//took 18 ms (46 percentile) and 42 MB (41 percentile)
class Codec1{

    public String serialize(TreeNode root){
        if(root == null) return "X,";

        String leftSubtree = serialize(root.left);
        String rightSubtree = serialize(root.right);

        return root.val + "," + leftSubtree + rightSubtree;
    }
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return helper(q);
    }
    public TreeNode helper(Queue<String> q){
        if(q.size() == 0) return null;

        String currVal = q.poll();
        if(currVal.equals("X")) return null;

        TreeNode currNode = new TreeNode(Integer.parseInt(currVal));

        currNode.left = helper(q);
        currNode.right = helper(q);

        return currNode;
    }
}