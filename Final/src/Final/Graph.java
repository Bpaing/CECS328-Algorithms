package Final;

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

    public void minimumCost(Node initial)
    {
        Queue<Node> q = new LinkedList();
        Node path = null;
        q.add(initial);
        while(q.size() > 0) {
            Node next = q.remove();
            for (Edge edge : next.getAdj()) {
                Node n = edge.getNode();
                int weight = next.getDst() + edge.getWeight();
                if(((weight < n.getDst() || n.getDst() == 0))
                        && (n != initial || !q.contains(n))) {
                    q.add(n);
                    n.setParent(next);
                    n.setDst(weight);
                }
            }
            if (next.getAdj().size() == 0)
                path = next;
        }
        System.out.printf("Minimum Cost: %d\n", path.getDst());
        System.out.println("Path (from destination)");
        while (path != null) {
            System.out.println(path + " ");
            path = path.getParent();
        }
    }

    public static Graph problem3()
    {
        ArrayList<Node> trip = new ArrayList();
        Node LB = new Node("Long Beach");
        trip.add(LB);
        Node SF = new Node("San Francisco");
        trip.add(SF);
        Node PT = new Node("Portland");
        trip.add(PT);
        Node SLC = new Node("Salt Lake City");
        trip.add(SLC);
        Node LV = new Node("Las Vegas");
        trip.add(LV);
        Node PH = new Node("Phoenix");
        trip.add(PH);
        Node ASP = new Node("Aspen");
        trip.add(ASP);
        Node GNP = new Node("Glacer N-Park");
        trip.add(GNP);

        LB.add(SF, 200);
        LB.add(LV, 50);
        LB.add(ASP, 800);
        LB.add(PH, 170);
        SF.add(SLC, 150);
        SF.add(PT, 250);
        LV.add(SLC, 190);
        LV.add(ASP, 400);
        PH.add(ASP, 650);
        SLC.add(ASP, 210);
        ASP.add(GNP, 350);
        SLC.add(GNP, 250);
        PT.add(GNP, 270);
        return new Graph(trip);
    }

    public void add(Node node) {
        vertices.add(node);
    }
    public ArrayList<Node> getGraph() { return vertices; }
    public Node getVertex(int i) { return vertices.get(i); }        //list index
    public Node getVertex(char i) { return vertices.get(i - 97); }  //char key
    public int size() { return vertices.size(); };

}
