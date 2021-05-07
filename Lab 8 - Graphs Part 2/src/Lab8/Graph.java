package Lab8;

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

    public void DFS(Node initial)
    {
        boolean cycle = false;
        int time = 0;
        Queue<Node> tpl = new LinkedList();
        for (Node node : vertices) {
            if (node.getStart() == -1)
                cycle = dfsVisit(node, time, tpl);
            if  (node.getEnd() != -1 && node.getEnd() > time) //time tracker
                time = node.getEnd();
        }

        if (!cycle) {
            System.out.println("\nTopological Order");
            for (Node n : tpl) {
                System.out.printf("%c %d/%d\n", n.getKey(), n.getStart(), n.getEnd());
            }
            System.out.println();
        } else{
            System.out.println("Cycle detected, topological sort is impossible\n");
        }

    }

    private boolean dfsVisit(Node node, int time, Queue<Node> list)
    {
        boolean cycle = false;
        time++;
        node.setStart(time);
        for (int i = 0; i < node.getAdj().size() && !cycle; i++) {
            Node v = node.getAdj().get(i);
            if (v.getStart() != -1 && v.getEnd() == -1) {
                return true;
            }
            if (v.getStart() == -1) {
                v.setParent(node);
                cycle = dfsVisit(v, time, list);
            }
            if  (v.getEnd() != -1 && v.getEnd() > time) //time tracker
                time = v.getEnd();
        }
        if (!cycle) {
            time++;
            node.setEnd(time);
            list.add(node);
        }
        return cycle;
    }

    public void printAdjacencyMatrix()
    {
        int[][] matrix = new int[vertices.size()][vertices.size()];
        for (int row = 0; row < vertices.size(); row++) {
            for (int col = 0; col < vertices.size(); col++) {
                Node one = vertices.get(row);
                Node two = vertices.get(col);
                if (one.getAdj().contains(two)) {
                    matrix[row][col]++;
                }
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
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
            else
                i--;
        }
        return new Graph(list);
    }


    public static Graph generateG1()
    {
        ArrayList<Node> example = new ArrayList();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');

        a.add(b);
        a.add(c);
        a.add(d);
        b.add(d);
        c.add(d);
        d.add(e);
        f.add(e);
        g.add(e);

        example.add(a);
        example.add(b);
        example.add(c);
        example.add(d);
        example.add(e);
        example.add(f);
        example.add(g);
        return new Graph(example);
    }

    public static Graph generateG2()
    {
        ArrayList<Node> example = new ArrayList();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.add(b);
        a.add(c);
        b.add(c);
        b.add(d);
        b.add(e);
        c.add(e);
        d.add(f);
        e.add(b);
        e.add(d);
        f.add(e);

        example.add(a);
        example.add(b);
        example.add(c);
        example.add(d);
        example.add(e);
        example.add(f);
        return new Graph(example);
    }

    public void add(Node node) { vertices.add(node); }
    public ArrayList<Node> getGraph() { return vertices; }
    public Node getVertex(int i) { return vertices.get(i); }        //list index
    public Node getVertex(char i) { return vertices.get(i - 97); }  //char key
    public int size() { return vertices.size(); };

}