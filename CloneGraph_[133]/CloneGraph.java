import java.util.*;

public class CloneGraph {

    //PROBLEM: Clone Graph
    //  Given a reference of a node in a connected undirected graph.
    //  Return a deep copy (clone) of the graph.
    //  Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
    //  class Node {
    //      public int val;
    //      public List<Node> neighbors;
    //  }
    //Test case format:
    //  For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with
    //  val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency
    //  list.
    //  An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the
    //  set of neighbors of a node in the graph. The given node will always be the first node with val = 1. You must
    //  return the copy of the given node as a reference to the cloned graph.
    //Constraints:
    //  The number of nodes in the graph is in the range [0, 100].
    //  1 <= Node.val <= 100
    //  Node.val is unique for each node.
    //  There are no repeated edges and no self-loops in the graph.
    //  The Graph is connected and all nodes can be visited starting from the given node.

    public static void main(String[] args) {

    }

    // time complexity: O(v + e); v : #vertices/nodes and e: #edges
    // space complexity: O(v + e) [O(n) in worst case when one node is connected to all the other nodes]
    //[Queue - BFS and HashMap] For each node in original nodes, create a clone layer-by-layer(BFS) using Queue and store
    //the original node and its clone in a HashMap. For each node created, add neighbor of the original node to the clone
    //one-by-one using HashMap
    //took 25 ms (89 percentile) and 38.8 MB (98 percentile)
    public Node cloneGraph(Node node){
        Map<Node, Node> map = new HashMap<>();

        Node start = new Node(node.val);
        map.put(node, start);

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            Node currNode = q.poll();
            for (Node neigh : currNode.neighbors) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    q.offer(neigh);
                }
                map.get(currNode).neighbors.add(map.get(neigh));
            }
        }

        return map.get(node);
    }

    // time complexity: O(v + e); v : #vertices/nodes and e: #edges
    // space complexity: O(v + e) [O(n) in worst case when one node is connected to all the other nodes]
    //[Stack - DFS and HashMap] For each node in original nodes, create a clone (using recursion) if the clone node
    //does not already exists but if the clone node exists then just add the existing clone node to the neighbour
    //the original node and its clone in a HashMap. For each node created, add neighbor of the original node to the clone
    //one-by-one using HashMap
    //took 26 ms (40 percentile) and 39.3 MB (49 percentile)
    Map<Node, Node> mapper = new HashMap<>();
    public Node cloneGraph2(Node node) {
        if(node == null) return null;

        Node cloneNode = new Node(node.val);
        mapper.put(node, cloneNode);

        for (Node neigh : node.neighbors){
            if (mapper.containsKey(neigh)) cloneNode.neighbors.add(mapper.get(neigh));
            else cloneNode.neighbors.add(cloneGraph2(neigh));
        }
        return cloneNode;
    }
}
class Node{
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}