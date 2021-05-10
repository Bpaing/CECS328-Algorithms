package Final;

public class Edge {
    private Node connection;
    private int weight;

    public Edge(Node n, int w)
    {
        connection = n;
        weight = w;
    }

    public Node getNode() { return connection; }
    public int getWeight() { return weight; }

}
