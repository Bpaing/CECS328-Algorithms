package Lab8;

import java.util.ArrayList;

public class Node {

    private char key;
    private int dst;
    private int start;  //start time
    private int end;    //end time
    private Node parent;
    private ArrayList<Node> adj;
    private ArrayList<Node> edge;

    public Node(char name)
    {
        key = name;
        adj = new ArrayList<>();
        edge = new ArrayList<>();
        dst = 0;
        parent = null;
        start = -1;
        end = -1;
    }

    //This method was altered to simulate directed edges
    //Adj is two-way, Edge is only one-way
    public void add(Node node)
    {
        if(!checkAdj(node)) {
            adj.add(node);
            node.adj.add(this);
        }
        edge.add(node);
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
    public void setStart(int i) { start = i; }
    public void setEnd(int i) { end = i; }

    //accessors
    public int getDst() { return dst; }
    public Node getParent() { return parent; }
    public ArrayList<Node> getAdj() { return adj; }
    public ArrayList<Node> getEdge() { return edge; }
    public int getStart() { return start; }
    public int getEnd() { return end; }

    public String toString() { return String.valueOf(key); }
}
