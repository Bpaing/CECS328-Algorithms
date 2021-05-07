package Lab8;

import java.util.Scanner;

public class Lab8 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Graph g1 = Graph.generateG1();
        Graph g2 = Graph.generateG2();
        while (true) {
            System.out.println("e = example graphs\nr = random graph\nany other input will quit the program.");
            String input = in.next().toLowerCase();
            if (input.equals("e")) {
                System.out.println("G1 Adjacency Matrix");
                g1.printAdjacencyMatrix();
                g1.DFS(g1.getVertex(0));
                System.out.println("\nG2 Adjacency Matrix");
                g2.printAdjacencyMatrix();
                g2.DFS(g2.getVertex(0));
            } else if (input.equals("r")) {
                System.out.print("# vertices: ");
                int v = in.nextInt();
                System.out.printf("\n# edges, max %d: ", v*(v+1) / 2);
                int e = in.nextInt();
                Graph rand = Graph.generateRandom(v, e);
                rand.printAdjacencyMatrix();
                rand.DFS(rand.getVertex(0));
            } else {
                break;
            }
        }
        in.close();
    }
}
