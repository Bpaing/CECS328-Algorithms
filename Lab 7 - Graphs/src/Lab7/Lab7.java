package Lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab7 {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Graph example = Graph.generateExample();
        System.out.println("Example Graph\nPlease enter a vertex from a - h");
        char c = in.next().charAt(0);
        Node.BFS(Graph.getVertex(c));
    }

    public static boolean isBipartite()
    {
        return true;
    }
    

}

/*
public class Node {

    private char key;
    private int dst;
    private Node parent;
    private ArrayList<Node> adj;

    public Node(char name) {
        key = name;
        adj = new ArrayList<>();
        dst = 0;
        parent = null;
    }

    public void add(Node node) {
        adj.add(node);
        node.adj.add(this);
    }

    public static void BFS(Node initial) {
        Queue<Node> q = new LinkedList();
        q.add(initial);
        while (q.size() > 0) {
            Node nextNode = q.remove();
            for (Node n : nextNode.adj) {
                if (n.parent == null) {
                    q.add(nextNode);
                    n.parent = nextNode;
                    n.dst = nextNode.dst + 1;
                }
            }
        }
    }
}
 */
