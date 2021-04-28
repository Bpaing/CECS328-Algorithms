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

    public static void BFS(Node initial)
    {
        Queue<Node> q = new LinkedList();
        q.add(initial);
        while(q.size() > 0) {
            Node nextNode = q.remove();
            for (Node n : nextNode.adj) {
                if(n.parent == null) {
                    q.add(nextNode);
                    n.parent = nextNode;
                    n.dst = nextNode.dst + 1;
                }
            }
        }
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

    public String toString()
    {
        String str = "key: " + key + ", adj: { ";
        for (Node a : adj)
            str += a.key + " ";
        return str + "}";
    }


    /*
    // mutators
    public void setParent(Node node)
    {
        parent = node;
    }

    public void setDst(int i)
    {
        dst = i;
    }

    public void add(Node node)
    {
        adj.add(node);
    }

    // accessors
    public ArrayList<Node> getAdj()
    {
        return adj;
    }

    public int getDst()
    {
        return dst;
    }

    public Node getParent()
    {
        return parent;
    }
    */
}
