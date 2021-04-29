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

    public void BFS(Node initial)
    {
        Queue<Node> q = new LinkedList();
        q.add(initial);
        while(q.size() > 0) {
            Node nextNode = q.remove();
            for (Node n : nextNode.getAdj()) {
                if(n.getParent() == null && n != initial) {
                    q.add(n);
                    n.setParent(nextNode);
                    n.setDst(nextNode.getDst() + 1);
                }
            }
        }
        printBFS(initial);
    }

    //helper method to print BFS
    private void printBFS(Node initial)
    {
        System.out.printf("From initial node '%s':", initial);
        for (Node n : vertices) {
            System.out.printf("\n'%s', dst %d\tShortest Path: ", n, n.getDst());
            if (n.getParent() == null)
                System.out.print("Initial/Unconnected.");
            while (n.getParent() != null) {
                System.out.print(n + " ");
                n = n.getParent();
            }
        }
    }

    public void explore()
    {
        Node first = vertices.get(0);
        for (Node n : vertices)
            n.setColor("gray");
        first.setColor("blue");
        boolean result = isBipartite(first);
        for (Node n : vertices) {
            if (n.getColor() == "gray") {
                n.setColor("blue");
                result = isBipartite(n);
            }
        }
        if (result)
            System.out.println("Graph is bipartite.");
        else
            System.out.println("NOT bipartite.");
        for (Node n : vertices)
            System.out.printf("'%s'\t%s\n", n, n.getColor());
    }

    public boolean isBipartite(Node node)
    {
        Queue<Node> q = new LinkedList();
        boolean bipartite = true;
        q.add(node);
        while(q.size() > 0 && bipartite) {
            Node u = q.remove();
            for (Node v : u.getAdj()) {
                if (v.getColor() == "gray") {
                    v.setColor("red");
                } else if (v.getColor() == u.getColor()) {
                    bipartite = false;
                }
            }
        }
        return bipartite;
    }

    public void printAdjacencyMatrix()
    {

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
            else
                i--;
        }
        return new Graph(list);
    }


    public static Graph generateExampleA()
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

    public static Graph generateExampleB()
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
        Node i = new Node('i');
        list.add(h);
        a.add(d);
        c.add(d);
        c.add(e);
        b.add(d);
        b.add(f);
        d.add(f);
        g.add(h);
        g.add(i);
        i.add(h);
        return new Graph(list);
    }

    public void add(Node node) { vertices.add(node); }
    public ArrayList<Node> getGraph() { return vertices; }
    public Node getVertex(int i) { return vertices.get(i); }        //list index
    public Node getVertex(char i) { return vertices.get(i - 97); }  //char key
    public int size() { return vertices.size(); };

}