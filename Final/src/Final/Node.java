package Final;

import java.util.ArrayList;

public class Node {

    private String key;
    private int dst;
    private Node parent;
    private ArrayList<Edge> adj;
    private String color;

    public Node(String name)
    {
        key = name;
        adj = new ArrayList<>();
        dst = 0;
        parent = null;
    }

    public void add(Node node, int weight)
    {
        adj.add(new Edge(node, weight));
    }

    public int w(Edge edge)
    {
        return adj.get(adj.indexOf(edge)).getWeight();
    }

    public boolean checkAdj(Node node)
    {
        for (Edge n : adj) {
            if (n.getNode().key == node.key)
                return true;
        }
        return false;
    }

    //mutators
    public void setDst(int d) { dst = d; }
    public void setParent(Node n) { parent = n; }
    public void setColor(String str) { color = str; }

    //accessors
    public int getDst() { return dst; }
    public Node getParent() { return parent; }
    public String getColor() { return color; }
    public ArrayList<Edge> getAdj() { return adj; }

    public String toString() { return key; }
}

