package Lab7;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Node {

    private char key;
    private int dst;
    private Node parent;
    private ArrayList<Node> adj;

    public Node(char name)
    {
        key = name;
        adj = new ArrayList<>();
        dst = 0;
        parent = null;
    }

    public void add(Node node)
    {
            adj.add(node);
            node.adj.add(this);
    }

    public boolean checkAdj(Node node)
    {
        for (Node n : adj) {
            if (n.key == node.key)
                return true;
        }
        return false;
    }

    //mutators
    public void setDst(int d) { dst = d; }
    public void setParent(Node n) { parent = n; }

    //accessors
    public int getDst() { return dst; }
    public Node getParent() { return parent; }
    public ArrayList<Node> getAdj() { return adj; }

    public void printAdj() {
        for (Node n : adj)
            System.out.println(n);
    }

    public String toString() { return String.valueOf(key); }

}
