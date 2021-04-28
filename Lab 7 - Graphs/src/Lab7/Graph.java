package Lab7;

import java.util.ArrayList;
import java.util.Random;

public class Graph {

    private ArrayList<Node> vertices;

    //constructors
    public Graph()
    {
        vertices = new ArrayList();
    }
    public Graph(ArrayList<Node> copy)
    {
        vertices = new ArrayList(copy);
    }

    public void add(Node node) { vertices.add(node); }
    public Node getVertex(int i) { return vertices.get(i); }        //list index
    public Node getVertex(char i) { return vertices.get(i - 97); }  //char key
    public int size() { return vertices.size(); };

    public static Graph generateRandom(int v, int e)
    {
        Random rand = new Random();
        ArrayList<Node> list = new ArrayList();
        for (char name = 0; name < v; name++){
            list.add(new Node((char) (name + 97)));
        }
        for (int i = 0; i < e; i++) {
            Node node = list.get(rand.nextInt(v));
            Node next = list.get(rand.nextInt(v));
            if (!node.checkAdj(next))
                node.add(next);
        }
        return new Graph(list);
    }


    public static Graph generateExample()
    {
        ArrayList<Node> list = new ArrayList();
        Node a = new Node('a');
        list.add(a);
        Node b = new Node('b');
        list.add(b);
        Node c = new Node('c');
        list.add(c);
        Node d = new Node('d');
        list.add(d);
        Node e = new Node('e');
        list.add(e);
        Node f = new Node('f');
        list.add(f);
        Node g = new Node('g');
        list.add(g);
        Node h = new Node('h');
        list.add(h);

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