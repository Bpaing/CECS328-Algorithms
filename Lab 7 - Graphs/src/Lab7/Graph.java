package Lab7;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> vertices;

    public Graph()
    {
        vertices = new ArrayList();
    }
    
    public Graph(ArrayList<Node> copy)
    {
        vertices = new ArrayList(copy);
    }

    public void add(Node node)
    {
        vertices.add(node);
    }

    public static Node getVertex(char i)
    {
        return vertices.get(i - 97);
    }


    public static Graph generateExample()
    {
        ArrayList<Node> list = new ArrayList();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');

        a.add(c);
        a.add(d);
        b.add(c);
        b.add(e);
        c.add(d);
        d.add(f);
        d.add(e);
        e.add(f);
        f.add(h);

        return new Graph(list);
    }

}
