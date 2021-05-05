package Lab8;

import java.util.Scanner;

public class Lab8 {
    public static void main(String args[]) {
        //part A
        Scanner in = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("A = Part A\nB = Part B\nAll other input will exit.");
            String selection = in.next().toUpperCase();
            if (selection.equalsIgnoreCase("A")) {
                //part A
                Graph example = Graph.generateExampleA();
                System.out.print("Part A\nExample Graph\n");
                example.printAdjacencyMatrix();
                System.out.print("Please enter initial vertex from a - h to perform BFS: ");
                char c = in.next().charAt(0);
                example.BFS(example.getVertex(c));

                System.out.print("\nRandom Graph\nPlease enter number of vertices: ");
                int v = in.nextInt();
                System.out.printf("Please enter number of edges, max %d: ", (v * (v + 1)) / 2);
                int e = in.nextInt();
                example = Graph.generateRandom(v, e);
                example.printAdjacencyMatrix();
                System.out.printf("Please enter initial vertex from %s - %s to perform BFS: ",
                        example.getGraph().get(0), example.getGraph().get(example.size() - 1));
                c = in.next().charAt(0);
                example.BFS(example.getVertex(c));
                System.out.println();
            } else if (selection.equalsIgnoreCase("B")){
                //part B
                System.out.println("\nPart B\nExample Graph");
                Graph example = Graph.generateExampleB();
                example.printAdjacencyMatrix();
                example.explore();
                System.out.print("\nRandom Graph\nPlease enter number of vertices: ");
                int v = in.nextInt();
                System.out.printf("Please enter number of edges, max %d: ", (v * (v + 1)) / 2);
                int e = in.nextInt();
                example = Graph.generateRandom(v, e);
                example.printAdjacencyMatrix();
                example.explore();
                System.out.println();
            }
            else { menu = false; }
        }
        in.close();
    }
}
