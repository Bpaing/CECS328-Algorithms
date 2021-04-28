package Lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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

    public static void BFS(Node initial)
    {
        Queue<Node> q = new LinkedList();
        q.add(initial);
        while(q.size() > 0) {
            Node nextNode = q.remove();
            for (Node n : nextNode.getAdj()) {
                if(n.getParent() == null) {
                    q.add(nextNode);
                    n.setParent(nextNode);
                    n.setDst(nextNode.getDst() + 1);
                }
            }
        }
    }

    public static Graph generateRandom(int v, int e)
    {
        Random rand = new Random();
        ArrayList<Node> list = new ArrayList();
        for (char name = 0; name < v; name++){
            list.add(new Node((char) (name + 97)));
        }
        for (int i = 0; i < e; i++) {
            Node nodeOne = list.get(rand.nextInt(v));
            Node nodeTwo = list.get(rand.nextInt(v));
            if (!nodeOne.checkAdj(nodeTwo))
                nodeOne.add(nodeTwo);
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

    public void add(Node node) { vertices.add(node); }
    public Node getVertex(int i) { return vertices.get(i); }        //list index
    public Node getVertex(char i) { return vertices.get(i - 97); }  //char key
    public int size() { return vertices.size(); };

}